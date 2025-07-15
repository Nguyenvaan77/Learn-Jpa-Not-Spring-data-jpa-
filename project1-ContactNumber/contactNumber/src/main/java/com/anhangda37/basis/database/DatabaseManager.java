package com.anhangda37.basis.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseManager {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.anhangda37.basis-postgres-hibernate-PU");
    private static EntityManager em = emf.createEntityManager();

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static EntityManager getEm() {
        return em;
    }
}
