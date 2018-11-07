package siso.edu.cn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class IDaoImpl<T> implements IDao<T> {

    private Class<T> clazz = null;

    @PersistenceContext
    private EntityManager entityManager;

    public IDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];

        System.out.println("DAO Current Class = " + this.clazz.getName());
    }

    @Override
    public void save(T entity) {
        this.entityManager.persist(entity);
    }

    @Override
    public void delete(long id) {
        this.entityManager.remove(this.findById(id));
    }

    @Override
    public void update(T entity) {
        this.entityManager.merge(entity);
    }

    @Override
    public T findById(long id) {
        return (T) this.entityManager.find(this.clazz, id);
    }

    @Override
    public List<T> findByParams(String sql, String... params) {
        Query query = this.entityManager.createQuery(sql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i + 1, params);
        }

        return query.getResultList();
    }

}
