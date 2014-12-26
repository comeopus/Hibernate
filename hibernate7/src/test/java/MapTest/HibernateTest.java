package MapTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Student;
import org.whut.hibernate.module.Team;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-23
 * Time: 下午7:47
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

            Team team = new Team();
            team.setTeamName("team1");
            Map map = team.getStudents();

            Student student1 = new Student();
            student1.setAge(20);
            student1.setName("zhangsan");
            student1.setTeam(team);

            Student student2 = new Student();
            student2.setAge(30);
            student2.setName("lisi");
            student2.setTeam(team);

            Student student3 = new Student();
            student3.setAge(40);
            student3.setName("wangwu");
            student3.setTeam(team);

            map.put("111",student1);
            map.put("222",student2);
            map.put("333",student3);

            session.save(team);
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
