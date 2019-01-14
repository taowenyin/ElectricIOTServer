package siso.edu.cn.service;

import siso.edu.cn.dao.IDaoImpl;

import java.util.List;

public class IServiceImpl<T> implements IService<T> {

    private IDaoImpl<T> dao;

    public IServiceImpl(IDaoImpl<T> dao) {
        this.dao = dao;
    }

    @Override
    public void save(T entity) {
        this.dao.save(entity);
    }

    @Override
    public T delete(long id) {
        return this.dao.delete(id);
    }

    @Override
    public T update(T entity) {
        return this.dao.update(entity);
    }

    @Override
    public T findById(long id) {
        return this.dao.findById(id);
    }

    @Override
    public List<T> findByParams(String sql, Object[] params) {
        return this.dao.findByParams(sql, params);
    }

    @Override
    public List<T> findByParams(String sql, Object[] params, int limit) {
        return this.dao.findByParams(sql, params, limit);
    }

    @Override
    public int findMaxValue(String sql) {
        return this.dao.findMaxValue(sql);
    }

    @Override
    public List<T> findAll() {
        return this.dao.findAll();
    }
}
