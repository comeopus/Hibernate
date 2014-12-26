import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Address;
import org.whut.hibernate.module.Student;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-24
 * Time: 下午3:37
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
//            student.setName("zhangsan");
//            Address address = new Address();
//            address.setHomeAddress("beijing");
//            address.setSchoolAddress("shanghai");
//            student.setAddress(address);
//            session.save(student);

            Student student = (Student) session.get(Student.class,"8a0df8684a7b3d94014a7b3d967f0000");

            System.out.println(student.getName());
            System.out.println(student.getAddress().getHomeAddress());
            System.out.println(student.getAddress().getSchoolAddress());

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
