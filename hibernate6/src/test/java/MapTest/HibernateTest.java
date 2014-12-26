package MapTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Team;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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

//            Team team = new Team();
//            team.setTeamName("team1");
//            Map map = team.getStudents();
//            map.put("zhangsan","helloworld");
//            map.put("lisi","welcome");
//            map.put("wangwu","haha");
//            map.put("zhaoliu","test123");
//            session.save(team);

            Team team = (Team) session.createQuery("from Team t where t.teamName = 'team1'").uniqueResult();

            Map map = team.getStudents();

            Collection col = map.values();

            Iterator it = col.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
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
