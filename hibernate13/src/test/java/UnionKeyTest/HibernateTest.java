package UnionKeyTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Student;
import org.whut.hibernate.module.StudentPrimaryKey;

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

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
//            Student student = new Student();
//
//            student.setAge(20);
//
//            StudentPrimaryKey studentPrimaryKey = new StudentPrimaryKey();
//            studentPrimaryKey.setCardId("123456");
//            studentPrimaryKey.setName("zhangsan");
//            student.setStudentPrimaryKey(studentPrimaryKey);
//            session.save(student);
//
            StudentPrimaryKey studentPrimaryKey = new StudentPrimaryKey();
            studentPrimaryKey.setCardId("123456");
            studentPrimaryKey.setName("zhangsan");

            Student student = (Student) session.get(Student.class,studentPrimaryKey);

            System.out.println(student.getAge());

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
