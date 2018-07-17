package com.test.hibernate.util;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.test.hibernate.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    private static void init(){
        //创建配置对象，加载配置文件 hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
//        Configuration configuration = new AnnotationConfiguration().configure(new File("hibernate.cfg.xml"));
        //创建会话连接工厂
        sessionFactory = configuration.buildSessionFactory();
        //打开会话
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
    }

    private static void destory(){
        try{
            //提交事务
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        //关闭会话
        session.close();
        //关闭工厂会话连接
        sessionFactory.close();
    }

    /**
     * 单表 保存
     */
    public static void testSaveCourseAnno() {
        init();
        CourseAnno cou = new CourseAnno();
        cou.setName("c#");
        cou.setDescription("编程语言");
        session.save(cou);
        destory();
    }
    /**
     * 单表 更新
     */
    public static void testUpdateCou() {
        init();
        // 获取一个课程对象
        CourseAnno cou = (CourseAnno) session.get(CourseAnno.class, 1);
        cou.setName("java");
        session.saveOrUpdate(cou);
        destory();
    }

    /*************************one to one ********************************/

    public static void TestOneToOne(){
        init();
        Person person = new Person();
        Idcard idcard = new Idcard();

        /*person.setName("1");
        session.save(person);
        idcard.setName("1");
        idcard.setPerson(person);
        session.save(idcard);*/
        person = session.get(Person.class,1);
        System.out.println(person);
        idcard = session.get(Idcard.class,1);
        System.out.println(idcard);
        destory();
    }
    /*********************************************************/

    /**************************one to many *******************************/
    public static void testOneToMany(){
        init();
        Department department = new Department();
        User user = new User();
//        department.setName("11");
        department.setDepartmentId(1L);
        department.setName("22");
        session.delete(department);
       /* department = session.get(Department.class,1L);
        user.setDepartment(department);
        user.setName("22");
        session.save(user);*/
        destory();
    }
    /*********************************************************/

    /******************************many to many***************************/
    public static void testManyToMany(){
        init();
        UserMany many1 = new UserMany();
        many1.setName("4");
        UserMany many2 = new UserMany();
        many2.setName("5");
        UserMany many3 = new UserMany();
        many3.setName("6");

        Role role1 = new Role();
        role1.setName("4");
        Role role2 = new Role();
        role2.setName("5");
        Role role3 = new Role();
        role3.setName("6");

        /*session.save(role1);
        session.save(role2);
        session.save(role3);*/
        /*role1=session.get(Role.class,1L);
        role2=session.get(Role.class,2L);
        role3=session.get(Role.class,3L);*/
        /*Set<Role> set = new HashSet<>();
        set.add(role2);
        set.add(role3);
        many2.setRoles(set);
        session.save(many2);*/

        /*session.save(many1);
        session.save(many2);
        session.save(many3);

        Set<UserMany> setM = new HashSet<>();
        setM.add(many1);
        setM.add(many2);
        role1.setUserManies(setM);
        session.save(role1);*/

        many1 = session.get(UserMany.class,1L);

        System.out.println(many1);
        System.out.println(many1.getRoles());
        destory();
    }
    /*********************************************************/


}
