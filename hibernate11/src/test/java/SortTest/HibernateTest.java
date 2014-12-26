package SortTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Student;
import org.whut.hibernate.module.Team;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-23
 * Time: 下午4:42
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

//        Student student1 = new Student();//插入一对一的数据
//        student1.setName("zhangsan");
//        student1.setCardId("aa");
//        student1.setAge(20);
//        Student student2 = new Student();
//        student2.setName("spark");
//        student2.setAge(25);
//        student2.setCardId("aa");
//        Student student3 = new Student();
//        student3.setName("jerry");
//        student3.setCardId("cc");
//        student3.setAge(26);
//        Student student4 = new Student();
//        student4.setName("tom");
//        student4.setCardId("dd");
//        student4.setAge(30);
//
//        Team team = new Team();
//        team.setName("team1");
//        team.setStudents(new HashSet<Student>());
//
//        team.getStudents().add(student1);
//        team.getStudents().add(student2);
//        team.getStudents().add(student3);
//        team.getStudents().add(student4);
//        student1.setTeam(team);
//        student2.setTeam(team);
//        student3.setTeam(team);
//        student4.setTeam(team);
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try{
//            tx = session.beginTransaction();
//
//            session.save(team);
//
//            tx.commit();
//        }catch (Exception ex){
//            if(tx!=null){
//                tx.rollback();
//
//            }
//            ex.printStackTrace();
//        }finally {
//                session.close();
//
//        }

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            Team team = (Team) session.get(Team.class,"8a0df8684a7a3fff014a7a4001490000");
            Set<Student> students = team.getStudents();

            for(Iterator<Student> it = students.iterator();it.hasNext();){
                System.out.println(it.next().getName());
            }

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
