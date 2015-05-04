package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Manager;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface ManagerDao {

    /**
     * @param eventId
     * @param memberId
     * @return the Manager entity
     */
    @Select
    Manager selectById(Integer eventId, Integer memberId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Manager entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Manager entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Manager entity);

    @Select
	boolean isAdmin(Integer eventId, String userId);
    
    @Delete(sqlFile=true)
    int deleteByEventId(Integer eventId);
}