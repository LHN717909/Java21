package com.kaishengit.test;


import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Teacher;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lhn on 2016/7/27.
 */
public class ManyToManyTestCase {
    /*在多对多中：最佳实践  要求其中一方放弃关系维护*/
@Test
    public void testSave(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher1=new Teacher();
        teacher1.setTeaname("T1");
        Teacher teacher2=new Teacher();
        teacher2.setTeaname("T2");

        Student student1=new Student();
        student1.setStuname("S1");

        Student student2=new Student();
        student2.setStuname("S2");

        Set<Teacher> teacherSet= new HashSet<>();
        teacherSet.add(teacher1);
        teacherSet.add(teacher2);

        student1.setTeacherSet(teacherSet);
        student2.setTeacherSet(teacherSet);

        session.save(teacher1);
        session.save(teacher2);
        session.save(student1);
        session.save(student2);

        session.getTransaction().commit();
    }
     @Test
    public void testFind(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher= (Teacher) session.get(Teacher.class,20);
        System.out.println(teacher.getTeaname());

        Set<Student> studentSet=teacher.getStudentSet();
         for (Student student:studentSet){
             System.out.println(student.getId()+"->"+student.getStuname());
         }


        session.getTransaction().commit();
    }

}
