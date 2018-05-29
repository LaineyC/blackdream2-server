package pers.laineyc.blackdream.framework.dao;

import java.util.List;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.dao.query.Limit;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.model.PageResult;

/**
 * @author LaineyC
 *
 */
public interface Dao<E extends Po, K extends Comparable<? super K>> {

    /**
     * 根据po插入数据
     * @param po 完全对应表结构的对象
     * @return sql执行后影响行数
     */
    int insert(E po);

    /**
     * 根据po的id删除数据
     * @param po 完全对应表结构的对象
     * @return sql执行后影响行数
     */
    int delete(E po);

    /**
     * 根据query作为sql的where条件删除数据 ，所有值都是and操作。
     * @param query 所有属性基本对应表字段，可扩展，但不能加入别的表的字段
     * @return sql执行后影响行数
     */
    int deleteList(Query<E> query);

    /**
     * 根据po更新数据，根据id更新 对你注入的字段全部更新（不判断是否为Null）
     * @param po 完全对应表结构的对象
     * @return sql执行后影响行数
     */
    int update(E po);

    /**
     * 根据po更新数据，根据id更新 会对字段进行判断再更新(如果为Null就忽略更新)
     * @param po 完全对应表结构的对象
     * @return sql执行后影响行数
     */
    int updateSelective(E po);

    /**
     * 根据query作为sql的where条件删除数据，所有值都是and操作。根据po作为更新值
     * @param query 所有属性基本对应表字段，可扩展，但不能加入别的表的字段
     * @param po 完全对应表结构的对象
     * @return sql执行后影响行数
     */
    int updateList(Query<E> query, E po);

    /**
     * 根据主键查询单条数据
     * @param id 主键
     * @return 一条数据
     */
    E selectById(K id);

    /**
     * 根据主键集合查询单条数据
     * @param ids 主键集合
     * @return 多条数据
     */
    //List<E> selectByIds(Iterable<K> ids);

    /**
     * 根据query作为sql的where条件查询单条数据，所有值都是and操作。如果数据库有多条数据返回会报异常。
     * @param query 所有属性基本对应表字段，可扩展，但不能加入别的表的字段
     * @return 一条数据
     */
    E selectOne(Query<E> query);

    /**
     * 根据query作为sql的where条件查询多条数据，所有值都是and操作，可以根据单个字段排序。
     * @param query 所有属性基本对应表字段，可扩展，但不能加入别的表的字段
     * @return 多条数据
     */
    List<E> selectList(Query<E> query);

    /**
     * 根据query作为sql的where条件查询多条数据，所有值都是and操作，可以根据单个字段排序，可以分页。
     * @param query 所有属性基本对应表字段，可扩展，但不能加入别的表的字段
     * @return 多条数据
     */
    //List<E> selectLimit(Query<E> query);

    /**
     * 根据query作为sql的where条件查询数据行数
     * @param query 所有属性基本对应表字段，可扩展，但不能加入别的表的字段
     * @return 数据行数
     */
    int selectCount(Query<E> query);

    /**
     * 默认分页
     */
    default PageResult<E> selectPage(Query<E> query){
        PageResult<E> pageResult = new PageResult<>();

        int total = this.selectCount(query);
        if(total == 0) {
            return pageResult;
        }
        pageResult.setTotal(total);

        Limit limit = query.getLimit();
        Integer firstResult = limit.getFirstResult();
        Integer maxResults = limit.getMaxResults();

        int page = firstResult / maxResults + 1;

        int maxPage = (total - 1) / maxResults + 1;
        if(page > maxPage){
            query.limit((maxPage - 1) * maxResults, maxResults);
        }

        List<E> poList = this.selectList(query);
        pageResult.setRecords(poList);

        return pageResult;
    }

}