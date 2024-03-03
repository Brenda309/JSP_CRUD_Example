package com.brenda.jsp_crud_example.doa;


import com.brenda.jsp_crud_example.bean.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import  util.HibernateUtil;

public class UserDao {
    public void SaveUser(User user){
        Transaction transaction = null;
        try ( Session session =  HibernateUtil.getSessionFactory().openSession()){
            //start transaction
            transaction = session.beginTransaction();
            //save student object
            session.save(user);
            // commit trans
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
