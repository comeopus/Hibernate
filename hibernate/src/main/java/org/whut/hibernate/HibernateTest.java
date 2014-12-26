package org.whut.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-19
 * Time: 下午8:40
 * To change this template use File | Settings | File Templates.
 */
public class HibernateTest {

    private static SessionFactory sessionFactory;

    static {
        try{
            System.out.println("=========");
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        /*  插入数据
        People people = new People();
        people.setUsername("zhangsan");
        people.setPassword("123456");
        people.setTelephone(888);
        people.setGender('F');
        people.setGraduation(true);
        Date date = new Date(new java.util.Date().getTime());
        people.setBirthday(date);
        people.setMarryTime(new Timestamp(new java.util.Date().getTime()));

        InputStream is = new FileInputStream("D:/test.txt");

        int length = is.available();
        byte[] buffer = new byte[length];
        is.read(buffer);
        people.setFile(buffer);

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.save(people);
            tx.commit();
        }catch (Exception ex){
            if(tx != null)
                tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }   */

      /*
         查询全部
       Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            //限制查询  用于限定查询记录返回最大数目
            Query query = session.createQuery("from People as p order by p.id").setFirstResult(1).setMaxResults(2);
            List<People> list = (List<People>)query.list();

            for(Iterator<People> it = list.iterator();it.hasNext();){
                People people = it.next();

                System.out.println(people.getId());
                System.out.println(people.getUsername());
                System.out.println(people.getPassword());
                System.out.println(people.getBirthday());
                System.out.println(people.getTelephone());
                System.out.println(people.getGraduation());
                System.out.println(people.getGender());
                System.out.println(people.getMarryTime());

                System.out.println("--------------------");
                byte[] buffer = people.getFile();

                OutputStream os = new FileOutputStream("c:/" + people.getId() + ".txt");
                os.write(buffer);
                os.close();

            }
            tx.commit();
        }catch (Exception ex){
            if(tx != null)
                tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }   */
        /**
         * 通过id查询


        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            People people = (People) session.get(People.class,new Long(1));

            people.setUsername("lisi");
            people.setGender('M');

            people.setUsername("wangwu");
            people.setGender('F');

            people.setUsername("zhangsan");
            session.update(people);
            tx.commit();
        }catch (Exception ex){
            if(tx != null)
                tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        } */

        /**
         *删除所有的记录
         */
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from People");

         //   Iterator<People> it = query.iterate();
            List<People> list = query.list();
            Iterator<People> it = list.iterator();
            while (it.hasNext()){
                session.delete(it.next());
            }
            tx.commit();
        }catch (Exception ex){
            if(tx != null)
                tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }


    }
}
