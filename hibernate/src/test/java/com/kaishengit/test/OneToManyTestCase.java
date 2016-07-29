package com.kaishengit.test;

import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lhn on 2016/7/26.
 */
public class OneToManyTestCase {
@Test
/*最佳实践  先存一再存多
*          让一的一端放弃关系维护（）
*          fetch=join可以避免N+1事件*/
    public void testSave() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept=new Dept();
        dept.setDeptname("C++ 研发部");

        Employee employee1=new Employee();
        employee1.setEmpname("李斌");
        employee1.setDept(dept);

        Employee employee=new Employee();
        employee.setEmpname("赵峰");
        employee.setDept(dept);

        Set<Employee> employees=new HashSet<>();
        employees.add(employee);
        employees.add(employee1);

        dept.setEmployeeSet(employees);

        session.save(dept);
        session.save(employee);
        session.save(employee1);

        session.getTransaction().commit();
    }
@Test
    public void testFind(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept= (Dept) session.get(Dept.class,16);
        /*System.out.println(dept);*/
        System.out.println(dept.getDeptname());

        Set<Employee> employees=dept.getEmployeeSet();
        for (Employee employee:employees){
            System.out.println(employee.getEmpname());
        }


        session.getTransaction().commit();
    }
@Test
    public void testFindEmployee(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Employee employee= (Employee) session.get(Employee.class,30);
        System.out.println(employee.getEmpname());

        Dept dept=employee.getDept();
        System.out.println(dept.getDeptname());

        session.getTransaction().commit();

    }
    @Test
    public void testFindAll(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
       //N+1    在配置中fetch=join
        //在配置中 lazy=false()
        Criteria criteria=session.createCriteria(Employee.class);
        List<Employee> employees=criteria.list();
        for (Employee employee:employees){
            System.out.println(employee.getId()+"->"+employee.getEmpname()+"->"+employee.getDept().getDeptname());
        }
        session.getTransaction().commit();
    }
@Test
    public void testDel(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        /*Employee employee= (Employee) session.get(Employee.class,29);
        session.delete(employee);*/

        Dept dept= (Dept) session.get(Dept.class,15);
        session.delete(dept);

        session.getTransaction().commit();
    }

}
