package CategoriesTest;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.whut.hibernate.module.Category;
import org.whut.hibernate.module.Customer;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-22
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public class CategoriesTest {

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
        Customer customer = null;

        try{
            tx = session.beginTransaction();

            Category category1 = new Category("level1",null,new HashSet<Category>());    //这是一个临时对象
            Category category2 = new Category("level2",null,new HashSet<Category>());
            Category category3 = new Category("level2",null,new HashSet<Category>());
            Category category4 = new Category("level3",null,new HashSet<Category>());
            Category category5 = new Category("level3",null,new HashSet<Category>());
            Category category6 = new Category("level3",null,new HashSet<Category>());
            Category category7 = new Category("level3",null,new HashSet<Category>());

            /*
            * 树形的方式构造  category1为根节点  依次有两个子节点构造

            category2.setParentCategory(category1);
            category3.setParentCategory(category1);

            category1.getChildCategory().add(category2);
            category1.getChildCategory().add(category3);

            category4.setParentCategory(category2);
            category5.setParentCategory(category2);

            category2.getChildCategory().add(category4);
            category2.getChildCategory().add(category5);

            category6.setParentCategory(category3);
            category7.setParentCategory(category3);

            category3.getChildCategory().add(category6);
            category3.getChildCategory().add(category7);

            session.save(category1); //调用save之后   category1变为了持久化对象（已经具备了OID）
             */
            /*   get与load的区别    用load作查询时  返回的时代理对象，只有当使用该代理对象时  才会通过id在
                数据库去查询从而得到查询对象。而get方法则是直接返回一个查询对象
            Category category = (Category) session.get(Category.class,new Long(8));
            Category category_ = (Category) session.get(Category.class,new Long(8));  */
            /**这是使用load时的后台输出
             *  Hibernate: select category0_.id as id2_0_, category0_.name as name2_0_, category0_.category_id as category3_2_0_ from categories category0_ where category0_.id=?
                level1
                true
             */
            Category category = (Category) session.load(Category.class,new Long(8));
            Category category_ = (Category) session.load(Category.class,new Long(8)); //这个是从session的缓存中拿的对象
            System.out.println(category.getName());
            System.out.println(category_.getName());
            System.out.println(category==category_);
            /*   查询
             Category category = (Category) session.get(Category.class,new Long(1));
            System.out.println(category.getChildCategory().iterator().next().getName()); */
            /*  删除
            Category category = (Category) session.get(Category.class,new Long(1));
            session.delete(category); */

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
        //在session关闭之后的java对象  称为游离对象  它具备OID  只是不在Session的缓存中
    }
}
