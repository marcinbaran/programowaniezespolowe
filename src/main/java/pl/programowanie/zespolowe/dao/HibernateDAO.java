/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.programowanie.zespolowe.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pl.programowanie.zespolowe.model.User;

public abstract class HibernateDAO<T, Id extends Serializable> {

    private Session currentSession;

    private Transaction currentTransaction;

    private Class clazz;

    public HibernateDAO() {
        this.clazz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = new MetadataSources(builder.build())
                .addAnnotatedClass(User.class)
                .buildMetadata()
                .buildSessionFactory();
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void save(T entity) {
        openCurrentSessionwithTransaction();
        getCurrentSession().persist(entity);
        closeCurrentSessionwithTransaction();
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public T findById(Id id) {
        T object = (T) getCurrentSession().get(this.clazz, id);
        return object;
    }

}
