/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.test2;

import jakarta.persistence.*;

/**
 * Contains one item and its description
 * @author Jose
 */
@Entity
@Table(name = "container")
public class Container {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idnum;
    @Column(name = "item_name", nullable=false, length=50)
    private String itemName;
    @Column(name = "item_description", nullable=false, length=200)
    private String itemDesc;
    @Column(name = "user", nullable=false, length=200)
    private String user;
    
    public Container(){}
    public Container(String itemName, String itemDesc){
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }
    
    public long getidnum(){return idnum;}
    public String getitemname(){return itemName;}
    public String getitemdesc(){return itemDesc;}
    public String getuser(){return user;}
    
    public void setID(long id){idnum = id;}
    public void setitemname(String s){itemName = s;}
    public void setitemdesc(String s){itemDesc = s;}
    public void setuser(User user){this.user = user.getfirstname() + " " + user.getlastname();}
}
