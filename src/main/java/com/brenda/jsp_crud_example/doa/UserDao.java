package com.brenda.jsp_crud_example.doa;


import com.brenda.jsp_crud_example.bean.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import  util.HibernateUtil;

import java.util.List;

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
    // get list of all users


    public List<User> getAllUser()

    {
        Transaction transaction = null;
        List <User> listOfUsers = null;
        try ( Session session =  HibernateUtil.getSessionFactory().openSession()){
            //start transaction
            transaction = session.beginTransaction();
            //save student object
           listOfUsers = session.createQuery(" from  User ").getResultList();
            // commit trans
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUsers;
    }

}
