package UnionPrimayKeyTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Student;

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
//            student.setCardId("123456");
//            student.setName("zhangsan");
//            student.setAge(20);
//
//
//            session.save(student);

            Student studentPrimaryKey = new Student();
            studentPrimaryKey.setCardId("123456");
            studentPrimaryKey.setName("zhangsan");

            Student student = (Student) session.get(Student.class,studentPrimaryKey);

            System.out.println(student.getName());
            System.out.println(studentPrimaryKey.getName());

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
