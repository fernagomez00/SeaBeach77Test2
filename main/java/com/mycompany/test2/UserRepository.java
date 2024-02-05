/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.test2;
import jakarta.persistence.Query;

/**
 *
 * @author Jose
 */
public class UserRepository extends Repository{
    
    
    public UserRepository(){
        super("user_pu");
    }

    public void addUser(User user){
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
    
    public User findUser(long id){
        return entityManager.find(User.class, id);
    }
    
    public void updateUser(User user){
        User userupdate = findUser(user.getidnum());
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        userupdate.setfirstname(user.getfirstname());
        userupdate.setlastname(user.getlastname());
        userupdate.setusername(user.getusername());
        userupdate.setpassword(user.getpassword());
        entityManager.getTransaction().commit();
    }
    
    public void deleteUser(User user){
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
    
    public void printFirstNames(){
        //need to get the whole package declaration for the querys the annotations will handle it
        for(Object s : super.query("Select u.firstname from com.mycompany.test2.User u").getResultList().toArray()){
            System.out.println(s.toString()+"\n");
        }
    }
    
    public void printLastNames(){
        //need to get the whole package declaration for the querys the annotations will handle it
        for(Object s : super.query("Select u.lastname from com.mycompany.test2.User u").getResultList().toArray()){
            System.out.println(s.toString()+"\n");
        }
    }
    
    public void printFullNames(){
        //entityManager.getTransaction().begin();
        //need to get the whole package declaration for the querys the annotations will handle it
        for(Object s : super.query("SELECT CONCAT(u.firstname, ' ', u.lastname) AS full_name FROM com.mycompany.test2.User u").getResultList().toArray()){
            System.out.println(s+"\n");
        }
    }
}
