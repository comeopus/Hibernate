package test;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.whut.hibernate.module.Student;
import org.whut.hibernate.module.Team;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-26
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public class QBCHibernateTest {

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


//            Criteria criteria = session.createCriteria(Student.class).add(
//                    Restrictions.between("age",new Integer(12),new Integer(30)));
            //查询学生中名字以t开头的
//            Criteria criteria = session.createCriteria(Student.class).add(
//                    Restrictions.like("name","t%"));
            //查询学生名字在数组names之中的
//            String[] names = {"tomclus","tom","jerry","test"};
//            Criteria criteria = session.createCriteria(Student.class).add(Restrictions.in("name",names));

            //排序   根据学生的年龄升序并且根据cardId降序
            Criteria criteria = session.createCriteria(Student.class).
                    addOrder(Order.asc("age")).addOrder(Order.desc("cardId"));
            List<Student> list = criteria.list();
            for(Student student:list){
                System.out.println(student.getName());
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
