package uz.pdp.firstproject.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("STUDENT_GROUP");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContextListener.super.contextInitialized(sce);
    }
}
