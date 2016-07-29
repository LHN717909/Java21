package com.kaishengit.test;

import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/**
 * Created by lhn on 2016/7/26.
 */
public class CriteriaTestCase {

    @Test
    public void FindAll(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(User.class);
       /* criteria.add(Restrictions.eq("username","david"));
        criteria.add(Restrictions.eq("password","234432"));*/
    /*这个很重要*/
       /* criteria.add(Restrictions.or(Restrictions.eq("username","david"),
                                    Restrictions.eq("password","123123")));*/

    /*disjunction表示或的关系*/
   /* Disjunction disjunction=Restrictions.disjunction();
    disjunction.add(Restrictions.eq("username","tom"));
    disjunction.add(Restrictions.eq("password","234432"));
    criteria.add(disjunction);*/

        criteria.add(Restrictions.in("username", new Object[]{"tom","david"}));
        List<User> userList=criteria.list();

        for (User user:userList){
            System.out.println(user);
        }

        session.getTransaction().commit();


    }
    @Test
    public void testUnique(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username","tom"));

        User user= (User) criteria.uniqueResult();
        System.out.println(user);


        session.getTransaction().commit();
    }

    public void testByPage(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(User.class);
        criteria.addOrder(Order.desc("id"));//排序
        criteria.setFirstResult(0);//分页
        criteria.setMaxResults(3);

        List<User> userList=criteria.list();
        session.getTransaction().commit();
    }
    @Test
    public void testProject(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(User.class);

        ProjectionList projectionList= Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.max("id"));
        criteria.setProjection(projectionList);

        Object[] objects= (Object[]) criteria.uniqueResult();
        System.out.println("Count:"+objects[0]);

        System.out.println("Max:"+objects[1]);

        session.getTransaction().commit();
    }
}
