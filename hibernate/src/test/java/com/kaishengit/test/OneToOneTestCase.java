package com.kaishengit.test;

import com.kaishengit.Util.HibernateUtil;
import com.kaishengit.pojo.Card;
import com.kaishengit.pojo.Person;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by lhn on 2016/7/26.
 */
public class OneToOneTestCase {
   @Test
   /*最佳实践  先存主，在存从*/
    public void testSave(){
        Session session= HibernateUtil.getSession();
        session.beginTransaction();

        Person person=new Person();
        person.setName("张飞");

        Card card=new Card();
        card.setCardname("VIP-321");
        card.setPerson(person);

        session.save(person);
        session.save(card);

        session.getTransaction().commit();
    }
@Test

    public void testFindPerson(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();

       Person person= (Person) session.get(Person.class,10);
        System.out.println(person.getName());
        System.out.println(person.getCard().getCardname());

        session.getTransaction().commit();
    }
    @Test
    public void testFindCard() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Card card= (Card) session.get(Card.class,10);
        System.out.println(card.getCardname());
        System.out.println(card.getPerson().getName());
        session.getTransaction().commit();
    }
@Test
    public void testDelCard(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Card card= (Card) session.get(Card.class,10);
        session.delete(card);

        session.getTransaction().commit();

    }
   @Test
    public void testDelPerson(){
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        Person person= (Person) session.get(Person.class,12);
        session.delete(person);

        session.getTransaction().commit();
    }
}
