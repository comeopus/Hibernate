package Test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Contact;
import org.whut.hibernate.module.Student;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-24
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */

/**
 * 集合类型的组件映射
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

            Student student = new Student();
            student.setName("zhangsan");

            Contact contact1 = new Contact();
            contact1.setMethod("telephone");
            contact1.setAddress("123456");

            Contact contact2 = new Contact();
            contact2.setMethod("address");
            contact2.setAddress("beijing");

            student.getContacts().add(contact1);
            student.getContacts().add(contact2);

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
