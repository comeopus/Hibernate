package BagTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Student;
import org.whut.hibernate.module.Team;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-23
 * Time: 下午7:47
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

            Team team1 = new Team();
            team1.setTeamName("team1");

            Team team2 = new Team();
            team2.setTeamName("team2");

            Student student1 = new Student();
            Student student2 = new Student();
            Student student3 = new Student();
            Student student4 = new Student();
            Student student5 = new Student();
            Student student6 = new Student();

            student1.setName("zhangsan");
            student2.setName("lisi");
            student3.setName("wangwu");
            student4.setName("zhaoliu");
            student5.setName("hello");
            student6.setName("world");
            student1.setTeam(team1);
            student2.setTeam(team1);

            student3.setTeam(team2);
            student4.setTeam(team2);
            student5.setTeam(team2);
            student6.setTeam(team2);

            team1.getStudents().add(student1);
            team1.getStudents().add(student2);

            team2.getStudents().add(student3);
            team2.getStudents().add(student4);
            team2.getStudents().add(student5);
            team2.getStudents().add(student6);

            session.save(team1);
            session.save(team2);
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
