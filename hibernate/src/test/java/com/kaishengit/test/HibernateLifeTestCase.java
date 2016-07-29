package com.kaishengit.test;

import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.User;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by lhn on 2016/7/25.
 */
public class HibernateLifeTestCase {
    @Test
    public void testFindByLoad(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        User user= (User) session.load(User.class,2);
        session.getTransaction().commit();
    }
    @Test
    public void testFindByGet(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();


        User user= (User) session.get(User.class,2);
        session.getTransaction().commit();
    }
    @Test
    public void testSave(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        User user=new User();
        user.setUsername("lisi");
        user.setPassword("123123");


        session.persist(user);
        System.out.println(user.getId());

        session.getTransaction().commit();
    }
}
