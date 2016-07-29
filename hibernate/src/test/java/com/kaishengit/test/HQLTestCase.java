package com.kaishengit.test;
import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import java.util.List;


/**
 * Created by lhn on 2016/7/25.
 */
public class HQLTestCase {
@Test
    public void testFindAll(){
        /*HQL 全部是Java对象 与数据库无关*/
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        String hql="from User where password=?";
        Query query=session.createQuery(hql);
        query.setParameter(0,"123123");
        List<User> userList=query.list();



        for (User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }
@Test
    public void findByCloumn(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        String hql="select id,username from User";
        Query query=session.createQuery(hql);
    /*查询多列*/
        List<Object[]> result=query.list();
         for (Object[] objects:result){
             System.out.println(objects[0]+"->"+objects[1]);
         }

    /*查询一列时*/
        /*List<String> result=query.list();

        for (String name:result){
            System.out.println(name);
        }*/
        session.getTransaction().commit();
    }
@Test
        public void testCount(){
            Session session=HibernateUtil.getSession();
            session.beginTransaction();

            String hql="select count(*),Max (id) from User ";
            Query query=session.createQuery(hql);

            /*Long count= (Long) query.uniqueResult();
            System.out.println("Count:"+count);*/
            Object[] objects= (Object[]) query.uniqueResult();
            System.out.println("Count:"+objects[0]);
            System.out.println("Max:"+objects[1]);


            session.getTransaction().commit();
        }
    @Test
    public void testPage(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        String hql="from User order by id desc";
        Query query=session.createQuery(hql);

        query.setFirstResult(3);
        query.setMaxResults(3);//limit 0,3

        List<User> userList=query.list();
        for (User user:userList){
            System.out.println(user);
        }


        session.getTransaction().commit();
    }

}
