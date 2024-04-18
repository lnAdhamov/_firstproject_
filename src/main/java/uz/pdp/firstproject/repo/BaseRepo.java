package uz.pdp.firstproject.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;

public class BaseRepo<T> {
    public static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("STUDENT_GROUP");
    protected static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    private final Class<T> persistenceClass;

    public BaseRepo() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass();
    }

    public void begin() {
        entityManager.getTransaction().begin();
    }

    public void commit() {
        entityManager.getTransaction().commit();
    }

    public void save(T t) {
        begin();
        entityManager.persist(t);
        commit();
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + persistenceClass.getSimpleName(), persistenceClass).getResultList();
    }

    public void delete(UUID id) {
        begin();
        T t = entityManager.find(persistenceClass, id);
        entityManager.remove(t);
        commit();
    }
}
