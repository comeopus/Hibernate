package LockTest;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Student;

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
//            tx = session.beginTransaction();
//            Student student = new Student();
//            student.setName("zhangsan");
//            student.setAge(25);
//            student.setCardId("123456");
//            session.save(student);

    /*       这里会出现异常   原因：每次更新的时候version都会自增，session1更新了name之后  version会变为1
             session2没有任何操作   因此其version为2。接着开启第二个事务对session2进行操作，修改student中
             的name，当提交事务的时候   数据库会更新数据库   其更新的条件是根据id和version 通过查询数据库得到
             其version为1，但是session2中查到的数据库的version为0，不匹配   因此会出现异常
     Session session1 = sessionFactory.openSession();
            Session session2 = sessionFactory.openSession();

            Student student1 = (Student) session1.createQuery("from Student s where s.name = :name").
                    setString("name", "zhangsan").
                    uniqueResult();
            Student student2 = (Student) session2.createQuery("from Student s where s.name = :name").
                    setString("name", "zhangsan").
                    uniqueResult();
            System.out.println(student1.getVersion());
            System.out.println(student2.getVersion());
            Transaction tx1 = session1.beginTransaction();

            student1.setName("lisi");
            tx1.commit();
            System.out.println(student1.getVersion());
            System.out.println(student2.getVersion());

            Transaction tx2 = session2.beginTransaction();
            student2.setName("wangwu");
            tx2.commit();
            session1.close();
            session2.close();    */
           // tx.commit();
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
