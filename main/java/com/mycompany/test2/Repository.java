/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.test2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 *
 * @author Jose
 */
public class Repository {

    protected final EntityManager entityManager;
    protected final EntityManagerFactory emf;
    
    public Repository(String pu){
        emf = Persistence.createEntityManagerFactory(pu);
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
    }
    
    protected Query query(String query){
        Query ret = entityManager.createQuery(query);
        return ret;
    }
    
    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
