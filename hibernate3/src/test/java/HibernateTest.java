import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.IdCard;
import org.whut.hibernate.module.Student;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-23
 * Time: 上午10:29
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

        Student student = new Student();//插入一对一的数据
        student.setName("zhangsan");

        IdCard idCard = new IdCard();
        idCard.setNumber(987654);

        student.setIdCard(idCard);
        idCard.setStudent(student);


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
            {
                session.close();
            }
        }


//        Session session = sessionFactory.openSession();//查询
//        Transaction tx = null;
//         Student student = null;
//
//        try{
//            tx = session.beginTransaction();
//            student = (Student) session.get(Student.class,"8a0df8684a762411014a7624133f0000");
//            tx.commit();
//        }catch (Exception ex){
//            if(tx!=null){
//                tx.rollback();
//
//            }
//            ex.printStackTrace();
//        }finally {
//            session.close();
//        }
//        System.out.println(student.getName());
//        System.out.println(student.getIdCard().getNumber());

//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        Student student = null;
//
//        try{
//            tx = session.beginTransaction();
//            student = (Student) session.get(Student.class,"bbc5cbf94a750b95014a750b97470000");
//            student.setName("lisi");
//            tx.commit();
//        }catch (Exception ex){
//            if(tx!=null){
//                tx.rollback();
//
//            }
//            ex.printStackTrace();
//        }finally {
//            session.close();
//        }
//        System.out.println(student.getName());
//        System.out.println(student.getIdCard().getNumber());
//
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        Student student = null;
//
//        try{
//            tx = session.beginTransaction();
//            student = (Student) session.get(Student.class,"bbc5cbf94a750b95014a750b97470000");
//            session.delete(student);
//            tx.commit();
//        }catch (Exception ex){
//            if(tx!=null){
//                tx.rollback();
//
//            }
//            ex.printStackTrace();
//        }finally {
//            session.close();
//        }
    }
}
