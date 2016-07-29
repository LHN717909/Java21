package com.kaishengit.test;
import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by lhn on 2016/7/26.
 */
public class NativeSqlTestCase {
    @Test
    public void testFindAll(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        String sql="select * from t_user";
        SQLQuery query=session.createSQLQuery(sql);
        List<Object[]> result=query.list();

        for (Object[] objects:result){
            System.out.println(objects[0]+":"+objects[1]+":"+objects[2]);
        }

        session.getTransaction().commit();
    }
@Test
    public void testFindById(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        String sql="select * from t_user WHERE id=:id";
        SQLQuery query=session.createSQLQuery(sql);
        query.setInteger("id",5);

        Object[] objects= (Object[]) query.uniqueResult();
        System.out.println(objects[0]+"->"+objects[1]+"->"+objects[2]);

        session.getTransaction().commit();
    }

    @Test
    public void testFindByIdToUser(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        String sql="select * from t_user WHERE id=:id";
        SQLQuery query=session.createSQLQuery(sql).addEntity(User.class);
        query.setInteger("id",5);

        User user= (User) query.uniqueResult();
        System.out.println(user);
        session.getTransaction().commit();
    }

}
