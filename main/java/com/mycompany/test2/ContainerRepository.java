/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.test2;

/**
 *
 * @author Jose
 */
public class ContainerRepository extends Repository{

    public ContainerRepository(){
        super("user_pu");
    }
    
    //adds a container to a user
    public void addItem(User user, Container container){
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        container.setuser(user);
        user.addlist(container);
        entityManager.persist(container);
        entityManager.getTransaction().commit();
    }
    
    public Container findContainer(long id){
        return entityManager.find(Container.class, id);
    }
    
    public void updateContainer(Container container){
        Container update = findContainer(container.getidnum());
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        update.setitemname(container.getitemname());
        update.setitemdesc(container.getitemdesc());
        entityManager.getTransaction().commit();
    }
    
    public void deleteContainer(Container container){
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.remove(container);
        entityManager.getTransaction().commit();
    }
}
