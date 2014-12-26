package Customer_OrderTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Customer;
import org.whut.hibernate.module.Order;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-22
 * Time: 下午2:51
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

        /*  一对多   插入
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Customer customer = new Customer();
            customer.setName("zhangsan");

            customer.setOrders(new HashSet<Order>());

            Order order1 = new Order();
            order1.setOrderNumber("order1");

            Order order2 = new Order();
            order2.setOrderNumber("order2");

            Order order3 = new Order();
            order3.setOrderNumber("order3");
            order1.setCustomer(customer);
            order2.setCustomer(customer);
            order3.setCustomer(customer);

            customer.getOrders().add(order1);
            customer.getOrders().add(order2);
            customer.getOrders().add(order3);
            session.save(customer);
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
        }  */

       /* 查询一的这方   */
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Customer customer = null;

        try{
            tx = session.beginTransaction();
            customer = (Customer) session.get(Customer.class,new Long(2));
            System.out.println(customer.getName());

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
        System.out.println(customer.getOrders());   //如果不设置lazy=false   就不会去查询多的一方
     /*  查询多的一方
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Order order = null;

        try{
            tx = session.beginTransaction();
            order = (Order) session.get(Order.class,new Long(1));
            System.out.println(order.getOrderNumber());

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
        System.out.println(order.getCustomer().getName());      */

//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        Customer customer = null;
//
//        try{
//            tx = session.beginTransaction();
//            customer = (Customer) session.get(Customer.class,new Long(1));
//            //先删除多的一方   再删除多的一方
//            /**
//             *  Hibernate: delete from orders where id=?
//             Hibernate: delete from orders where id=?
//             Hibernate: delete from orders where id=?
//             Hibernate: delete from customers where id=?
//             */
//            session.delete(customer);
//
//            tx.commit();
//        }catch (Exception ex){
//            if(tx!=null){
//                tx.rollback();
//
//            }
//            ex.printStackTrace();
//        }finally {
//            {
//                session.close();
//            }
//        }
    }
}
