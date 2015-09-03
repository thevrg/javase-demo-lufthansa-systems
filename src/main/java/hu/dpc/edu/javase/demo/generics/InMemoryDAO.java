package hu.dpc.edu.javase.demo.generics;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author U122951
 */
public abstract class InMemoryDAO<E extends Entity<ID>, ID extends Serializable> {

    private Class<E> type;
    private Map<ID, E> map = new HashMap<>();

    protected InMemoryDAO(Class<E> type) {
        this.type = type;
    }

    public E createNew() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void persist(E entity) {
        map.put(entity.getId(), entity);
    }

    public void remove(E entity) {
        map.remove(entity.getId());
    }

    public void removeById(ID id) {
        map.remove(id);
    }

    public E findById(ID id) {
        return map.get(id);
    }
    
}
