import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.IdCard;
import org.whut.hibernate.module.Student;
import org.whut.hibernate.module.Team;

import java.util.HashSet;

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

//        Student student = new Student();//插入一对一的数据
//        student.setName("zhangsan");
//
//        IdCard idCard = new IdCard();
//        idCard.setNumber(987654);
//
//        student.setIdCard(idCard);
//        idCard.setStudent(student);
//        Team team = new Team();
//        team.setName("team1");
//        team.setStudents(new HashSet<Student>());
//
//        team.getStudents().add(student);
//        student.setTeam(team);
//
//
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
        Team team = null;

        try{
            tx = session.beginTransaction();

            team = (Team) session.get(Team.class, "8a0df8684a76595e014a765960980000");
            System.out.println(team.getName());

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
