package test;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import orh.whut.hibernate.module.Student;
import orh.whut.hibernate.module.Teacher;

import java.util.Iterator;
import java.util.List;

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
//            student.setCardId("123456");
//
//            Teacher teacher = new Teacher();
//            teacher.setName("zzz");
//            teacher.setSalary(5000);
//            session.save(student);
//            session.save(teacher);

            Query query = session.createQuery("from orh.whut.hibernate.module.Person");//多态查询

//            Iterator it = query.iterate();            查询方式一
//            while(it.hasNext()){
//                Person p = (Person) it.next();
//
//                System.out.println(p.getClass().getName());
//                System.out.println(p.getName());
//            }

            List list = query.list();
            for(int i=0;i<list.size();i++){
                if(list.get(i) instanceof Student){
                    System.out.println(((Student) list.get(i)).getCardId());
                }
                if(list.get(i) instanceof Teacher){
                    System.out.println(((Teacher) list.get(i)).getSalary());
                }
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
