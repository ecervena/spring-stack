package org.jboss.examples.springmvc.stack.hibernateorm.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.examples.springmvc.stack.api.Dao;
import org.jboss.examples.springmvc.stack.hibernateorm.dao.ContactDao;
import org.springframework.util.ReflectionUtils;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

/**
 * Created by ecervena on 1/30/14.
 */
public class AbstractHibernateDao<T extends Object> implements Dao<T> {

    @Inject
    private SessionFactory sessionFactory;

    private Class<T> domainClass;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    private String getDomainClassName() {
        return domainClass.getName();
    }

    @Override
    public void create(T t) {
        Method method = ReflectionUtils.findMethod(getDomainClass(), "setDateCreated", new Class[] {Date.class});
        if (method != null) {
            try {
                method.invoke(t, new Date());
            } catch (Exception e) { /* Ignore */ }
        }
        getSession().save(t);
    }

    @Override
    public T get(Serializable id) {
        return (T) getSession().get(getDomainClass(), id);
    }

    @Override
    public T load(Serializable id) {
        return (T) getSession().load(getDomainClass(), id);
    }

    @Override
    public List<T> getAll() {
        return getSession().createQuery("from" + getDomainClassName()).list();
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    @Override
    public void deteleById(Serializable id) {
        delete(load(id));
    }

    @Override
    public void deleteAll() {
        getSession().createQuery("delete " + getDomainClassName());
    }

    @Override
    public long count() {
        return (Long) getSession()
                .createQuery("select count(*) from " + getDomainClassName())
                .uniqueResult();
    }

    @Override
    public boolean exists(Serializable id) {
        return (get(id) != null);
    }
}
