package many.to.many;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Course;
import org.whut.hibernate.module.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

        Student student = new Student();
        student.setName("lisi");
        Course course = new Course();
        course.setName("music");

        student.setCourses(new HashSet<Course>());
        course.setStudents(new HashSet<Student>());

        student.getCourses().add(course);
        //course.getStudents().add(student);
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.save(student);


            tx.commit();
        }catch (Exception ex){
            if(tx!=null){
                tx.rollback();

            }
            ex.printStackTrace();
        }finally {
                session.close();

        }

//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//
//        try{
//            tx = session.beginTransaction();
//            Student student = (Student) session.get(Student.class,"8a0df8684a76c784014a76c786400000");
////            Course course = (Course) session.get(Course.class,"8a0df8684a76c8f2014a76c8f4c80001");学生再选一门音乐课
////            student.getCourses().add(course);
////            course.getStudents().add(student);
//            Course course = (Course) session.get(Course.class,"8a0df8684a76c8f2014a76c8f4c80001");//学生现在不想选了
//            student.getCourses().remove(course);
////            Set<Course> courses = student.getCourses();
////            for(Iterator<Course> it = courses.iterator();it.hasNext();){
////                System.out.println(it.next().getName());
////            }
//
//            tx.commit();
//        }catch (Exception ex){
//            if(tx!=null){
//                tx.rollback();
//
//            }
//            ex.printStackTrace();
//        }finally {
//            session.close();
//
//        }

    }
}
