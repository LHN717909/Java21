package com.kaishengit.test;

import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.Task;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by lhn on 2016/7/27.
 */
public class UuidPrimaryKeyTestCase {
@Test
    public void testSave(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        Task task=new Task();
        task.setTitle("X-2");

        session.save(task);

        session.getTransaction().commit();
    }
    @Test
    public void testFindById() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        //一级缓存
        Task task = (Task) session.get(Task.class,"8a8082e454bc3f1b0154bc3f1f6a0000");
        //System.out.println(session.contains(task));
        //session.clear(); 持久态 -> 游离态  并清空一级缓存
        //session.evict(task); //将指定对象从一级缓存中清除
        session.getTransaction().commit();
        //-------------------------------------------------

        //将对象从二级缓存中清除
        //Cache cache = HibernateUtil.getSessionFactory().getCache();
        //cache.evictEntityRegion(Task.class);
        //cache.evictAllRegions();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        Task task2 = (Task) session2.get(Task.class,"8a8082e454bc3f1b0154bc3f1f6a0000");
        System.out.println(task2.getTitle());

        session2.getTransaction().commit();
    }
    @Test
    public void testUpdate() throws InterruptedException {
        final Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Task task= (Task) session.get(Task.class,"4028800d563177520156317756af0000");
        task.setTitle("x-111");

      /*  Thread.sleep(10000);*/
        /*悲观锁*/
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Session session1=HibernateUtil.getSession();
                session1.beginTransaction();

                Task task1= (Task) session1.get(Task.class,"4028800d563177520156317756af0000");
                task1.setTitle("x-222");

                session1.getTransaction().commit();
            }
        });
        thread.start();

        Thread.sleep(5000);



        session.getTransaction().commit();
    }
}
