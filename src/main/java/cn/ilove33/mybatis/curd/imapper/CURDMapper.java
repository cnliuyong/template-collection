package cn.ilove33.mybatis.curd.imapper;

import cn.ilove33.mybatis.curd.provider.DeleteSQLProvider;
import cn.ilove33.mybatis.curd.provider.InsertSQLProvider;
import cn.ilove33.mybatis.curd.provider.SelectSQLProvider;
import cn.ilove33.mybatis.curd.provider.UpdateSQLProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 基础泛型Mapper接口,继承此接口即可拥有基础的CURD方法.
 * 
 * @author Andy Chen
 * @date 10/1/19 2:39 PM
 * @param <T>
 */
public interface CURDMapper<T> {
    /**
     * 在数据库中插入一条记录.
     * @param obj
     * @return
     */
    @InsertProvider(type = InsertSQLProvider.class, method = "insert")
    int insert(T obj);

    /**
     * 更新数据库记录, 以{@link }为标明的类为属性
     * @param obj
     * @return
     */
    @UpdateProvider(type = UpdateSQLProvider.class, method = "update")
    int update(T obj);

    /**
     * 删除对象，以obj的不为空的属性做条件
     *
     * @param obj
     * @return
     */
    @DeleteProvider(type = DeleteSQLProvider.class, method = "delete")
    int delete(T obj);

    /**
     * 删除对象，以obj主键作为唯一条件
     * @param obj
     * @return
     */
    @DeleteProvider(type = DeleteSQLProvider.class, method = "deletePrimary")
    int deletePrimary(T obj);

    /**
     * 查询对象，返回一条数据，以obj的不为空的属性做条件
     *
     * @param obj
     * @return
     */
    @SelectProvider(type = SelectSQLProvider.class, method = "selectPrimary")
    T selectPrimary(T obj);

    /**
     * 分页查询，以obj的不为空的属性做条件，若不提供RowBounds对象，则默认返回20条数据
     *
     * @param obj
     * @param rowBounds
     * @return
     */
    @SelectProvider(type = SelectSQLProvider.class, method = "selectRowBounds")
    List<T> selectRowBounds(T obj, RowBounds rowBounds);

    /**
     * 查询总数，以obj的不为空的属性做条件,与分页连用
     *
     * @param obj
     * @return
     */
    @SelectProvider(type = SelectSQLProvider.class, method = "selectCount")
    int selectCount(T obj);
}
