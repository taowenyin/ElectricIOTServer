package siso.edu.cn.dao;

import java.util.List;

public interface IDao<T> {

    /**
     * 增加一条记录
     * @param entity 实体对象
     */
    public void save(T entity);

    /**
     * 删除一条记录
     * @param id ID号
     */
    public T delete(long id);

    /**
     * 修改一条记录
     * @param entity 实体对象
     * @return 更新后的新对象
     */
    public T update(T entity);

    /**
     * 根据ID查找一条记录
     * @param id ID号
     * @return null表示没有找到，非null表示唯一的一个结果
     */
    public T findById(long id);

    /**
     * 根据条件查询一组记录
     * @param sql SQL语句
     * @param params 参数列表
     * @return null表示没有找到，非null表示一组结果
     */
    public List<T> findByParams(String sql, Object[] params);

    /**
     * 获取最大值
     * @param sql SQL语句
     * @return null表示没有找到，非null表示一组结果
     */
    public int findMaxValue(String sql);

}
