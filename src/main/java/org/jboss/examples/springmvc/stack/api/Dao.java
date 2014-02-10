package org.jboss.examples.springmvc.stack.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ecervena on 1/30/14.
 */
public interface Dao<T extends Object> {

    void create(T t);

    T get(Serializable id);

    T load(Serializable id);

    List<T> getAll();

    void update(T t);

    void delete(T t);

    void deteleById(Serializable id);

    void deleteAll();

    long count();

    boolean exists(Serializable id);
    
}
