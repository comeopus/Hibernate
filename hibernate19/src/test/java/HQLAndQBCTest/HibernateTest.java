package HQLAndQBCTest;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Course;
import org.whut.hibernate.module.Student;
import org.whut.hibernate.module.Team;

import java.util.HashSet;
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


//        Student student1 = new Student();
//        student1.setName("tomclus");
//        student1.setCardId("1");
//        student1.setAge(25);
//        student1.setCourses(new HashSet<Course>());
//
//
//        Student student2 = new Student();
//        student2.setName("tom");
//        student2.setCardId("2");
//        student2.setAge(25);
//        student2.setCourses(new HashSet<Course>());
//
//        Student student3 = new Student();
//        student3.setName("spark");
//        student3.setCardId("3");
//        student3.setAge(25);
//        student3.setCourses(new HashSet<Course>());
//
//        Student student4 = new Student();
//        student4.setName("jerry");
//        student4.setCardId("4");
//        student4.setAge(25);
//
//        student4.setCourses(new HashSet<Course>());
//
//        Course course1 = new Course();
//        course1.setName("history");
//        course1.setStudents(new HashSet<Student>());
//
//        Course course2 = new Course();
//        course2.setName("computer");
//        course2.setStudents(new HashSet<Student>());
//
//        Course course3 = new Course();
//        course3.setName("music");
//        course3.setStudents(new HashSet<Student>());
//
//        Course course4 = new Course();
//        course4.setName("math");
//        course4.setStudents(new HashSet<Student>());
//
//        Course course5 = new Course();
//        course5.setName("politics");
//        course5.setStudents(new HashSet<Student>());
//
//        Team team1 = new Team();
//        team1.setTeamName("team1");
//
//        Team team2 = new Team();
//        team2.setTeamName("team2");
//
//        Team team3 = new Team();
//        team3.setTeamName("team3");
//
//
//        team1.getStudents().add(student1);
//        team1.getStudents().add(student2);
//        team2.getStudents().add(student3);
//        team3.getStudents().add(student4);
//
//        student1.setTeam(team1);
//        student2.setTeam(team1);
//        student3.setTeam(team2);
//        student4.setTeam(team3);
//
//        student1.getCourses().add(course1);
//        student1.getCourses().add(course2);
//
//        student2.getCourses().add(course3);
//        student3.getCourses().add(course4);
//        student4.getCourses().add(course5);
//
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try{
//            tx = session.beginTransaction();
//            session.save(student1);
//            session.save(student2);
//            session.save(student3);
//            session.save(student4);
//
//
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
        Query query = null;
        List list = null;

        try{
            tx = session.beginTransaction();

//            Query query = session.createQuery("select s.name,s.age from Student s");
//
//            List list = query.list();
//            for(int i=0;i<list.size();i++){
//                Object[] obj = (Object[]) list.get(i);
//                System.out.println(obj[0] + "," + obj[1]);
//            }


//            Query query = session.createQuery("select new Student(s.name,s.age ) from Student s");
//
//            List list = query.list();
//            for(int i=0;i<list.size();i++){
//                Student student = (Student) list.get(i);
//                System.out.println(student.getName() + ":" +student.getAge());
//                System.out.println(student.getCardId());
//            }

//            Query query = session.createQuery("from Team t join t.students"); //连接返回的是两个表字段的并集
//            List list = query.list();
//            for(int i=0; i<list.size();i++){
//                Object[] objects = (Object[]) list.get(i);
//                Team team = (Team) objects[0];
//                Student student = (Student) objects[1];
//
//                System.out.println(team.getTeamName());
//                System.out.println(student.getName());
//                System.out.println("----------------------");
//            }

            query = session.createQuery("from Team t join t.students"); //连接返回的是两个表字段的并集
            list = query.list();

            tx.commit();
        }catch (Exception ex){
            if(tx!=null){
                tx.rollback();

            }
            ex.printStackTrace();
        }finally {
            session.close();

        }

        for(int i=0; i<list.size();i++){
            Object[] objects = (Object[]) list.get(i);
            Team team = (Team) objects[0];
            Student student = (Student) objects[1];

            System.out.println(team.getTeamName());
            System.out.println(student.getName());
            System.out.println("----------------------");
        }


    }
}
