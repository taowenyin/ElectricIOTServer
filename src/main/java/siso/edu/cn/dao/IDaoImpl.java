package siso.edu.cn.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
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
    public T delete(long id) {
        T obj = this.findById(id);
        if (obj != null) {
            this.entityManager.remove(obj);
        }

        return obj;
    }

    @Override
    public T update(T entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public T findById(long id) {
        return (T) this.entityManager.find(this.clazz, id);
    }

    @Override
    public List<T> findByParams(String sql, Object[] params) {
        Query query = this.entityManager.createQuery(sql);
        for (int i = 1; params != null && i <= params.length; i++) {
            query.setParameter(i, params[i - 1]);
        }

        return query.getResultList();
    }

    @Override
    public int findMaxValue(String sql) {
        Query query = this.entityManager.createNativeQuery(sql);
        List resultList = query.getResultList();

        return (int) resultList.get(0);
    }

}
