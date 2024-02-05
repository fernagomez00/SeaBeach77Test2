/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.test2;
/**
 *
 * @author Jose
 */
public class Test2 {
    public static void main(String args[]) {
        ContainerRepository cr = new ContainerRepository();
        UserRepository ur = new UserRepository();       
        //below is to add users (dont need to add as these have already been added)
        ur.addUser(new User("Fernando","Gomez","fgomez5","1191108"));
        ur.addUser(new User("Tristan","Sutton","TSutton00","534768"));
        ur.addUser(new User("Luis","Luna","LLuna","5743618"));
//        ur.deleteUser(ur.findUser(1));
        cr.addItem(ur.findUser(2), new Container("test item1","Test item 1 description"));
        cr.addItem(ur.findUser(3), new Container("test item2","Test item 2 description"));
        cr.addItem(ur.findUser(1), new Container("test item3","Test item 3 description"));
        cr.addItem(ur.findUser(2), new Container("test item4","Test item 4 description"));
        cr.addItem(ur.findUser(3), new Container("test item5","Test item 5 description"));
        cr.addItem(ur.findUser(1), new Container("test item6","Test item 6 description"));

        ur.printFirstNames();
        ur.printLastNames();
        ur.printFullNames();
        
        ur.close();
        cr.close();
    }
}
