package com.kaishengit.test;

import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.Topic;
import com.kaishengit.pojo.TopicContent;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by lhn on 2016/7/27.
 */
public class OneToOne2TestCase {
   @Test
    public void testSave(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
       Topic topic=new Topic();
       topic.setTitle("五一假期通知");

       TopicContent topicContent=new TopicContent();
       topicContent.setContent("关于五一节假日放假通知：根据国家规定我们放假一周!");
        topic.setTopicContent(topicContent);

        session.save(topic);
       session.save(topicContent);
        session.getTransaction().commit();
    }
@Test
    public void testFind(){

        Session session=HibernateUtil.getSession();
        session.beginTransaction();

        Topic topic= (Topic) session.get(Topic.class,3);

        /*topic.getTopicContent().getContent();
        Hibernate.initialize(topic.getTopicContent());*/

        session.getTransaction().commit();
        /*System.out.println(topic.getTopicContent().getContent());*/

    }
}
