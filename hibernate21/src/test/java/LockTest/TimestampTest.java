package LockTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Student;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-26
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
public class TimestampTest {

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
            Student student = new Student();
            student.setName("zhangsan");
            student.setAge(25);
            student.setCardId("123456");
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
    }
}
