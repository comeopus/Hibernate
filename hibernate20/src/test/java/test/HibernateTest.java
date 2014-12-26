package test;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Student;
import org.whut.hibernate.module.Team;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-23
 * Time: 下午6:39
 * To change this template use File | Settings | File Templates.
 */
public class HibernateTest {

    private static SessionFactory sessionFactory;

    static {
        try{

            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            Team team = (Team) session.get(Team.class,"8a0df8684a809b51014a809b52ca0001");

//            Query query = session.createQuery("from Student s where s.team = :team and s.age > 20");
//           // query.setParameter("team",team, Hibernate.entity(Team.class));
//            query.setEntity("team",team);
            Query query = session.createFilter(team.getStudents(),"where age>20");
            List list = query.list();
            System.out.println(list.size());


            tx.commit();
        }catch (Exception ex){
            if(tx!=null){
                tx.rollback();

            }
            ex.printStackTrace();
        }finally {
            session.close();

        }


    }
}
