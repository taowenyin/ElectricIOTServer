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
    public void delete(long id) {
        this.dao.delete(id);
    }

    @Override
    public void update(T entity) {
        this.dao.update(entity);
    }

    @Override
    public T findById(long id) {
        return this.dao.findById(id);
    }

    @Override
    public List<T> findByParams(String sql, String[] params) {
        return this.dao.findByParams(sql, params);
    }
}
