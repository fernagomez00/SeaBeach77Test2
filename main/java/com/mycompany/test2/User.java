/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.test2;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Gomez
 */
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idnum;
    
    @Column(name = "first_name", nullable=false, length=150)
    private String firstname;
    @Column(name ="last_name", nullable=false, length=200)
    private String lastname;
    @Column(name ="username", nullable=false, length=200)
    private String username;
    @Column(name ="password", nullable=false, length=200)
    private String password;
    
    @OneToMany(targetEntity = Container.class)
    private final List<Container> containers;
    
    public User(){containers = new ArrayList<>();}
    public User(User user){
        firstname = user.firstname;
        lastname = user.lastname;
        username = user.username;
        password = user.password;
        containers = user.getlist();
        
    }
    public User(String firstname, String lastname, String username, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        containers = new ArrayList<>();
        
    }
    public User(String firstname, String lastname, String username, String password, long idnum){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.idnum = idnum;
        containers = new ArrayList<>();
        
    }
    
    public long getidnum(){return idnum;}
    public String getfirstname(){return firstname;}
    public String getlastname(){return lastname;}
    public String getusername(){return username;}
    public String getpassword(){return password;}
    public List getlist(){return containers;}
    
    public void setID(long id){idnum = id;}
    public void setfirstname(String s){firstname = s;}
    public void setlastname(String s){lastname = s;}
    public void setusername(String s){username = s;}
    public void setpassword(String s){password = s;}
    public void addlist(Container c){containers.add(c);}
    
    
    @Override
    public String toString(){
        String ret = "";
        
        ret+= "ID number: "+ idnum + "\nFirst name: " + firstname + "\nLast name: " + lastname + "\nUsername: " + username + "\nPassword: " + password;
        
        return ret;
    }
}
