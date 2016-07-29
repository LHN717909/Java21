package com.kaishengit.test;

import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import java.util.List;

/**
 * Created by lhn on 2016/7/25.
 */
public class HibernateTestCase {
@Test
    public void testSave(){
    Configuration configuration=new Configuration().configure();
    ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);


    Session session=sessionFactory.getCurrentSession();
    Transaction transaction=session.beginTransaction();

    User user=new User();
    user.setUsername("田七");
    user.setPassword("131131");

    session.save(user);

    /*代码*/

    transaction.commit();
    /*transaction.rollback();*/
    /*session.getTransaction().commit();
    session.getTransaction().rollback();*/
   }
    @Test
    public void testfindById(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        User user= (User) session.get(User.class,41);
        System.out.println(user.getUsername());

        session.getTransaction().commit();
    }
    @Test
    public void testupdate(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        User user= (User) session.get(User.class,1);
        user.setPassword("521521");
        session.getTransaction().commit();

    }
    @Test
    public void testdel(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        User user= (User) session.get(User.class,1);
        session.delete(user);

        session.getTransaction().commit();
    }
    @Test
    public void findAll(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        String hql="from User";
        Query query=session.createQuery(hql);
        List<User> userList=query.list();
        for (User user:userList){
            System.out.println(user.getId()+"->"+user.getUsername());
        }

        session.getTransaction().commit();
    }
}

