package jp.entropia.sirens.dao;

import java.util.List;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Event;
import jp.entropia.sirens.entity.EventPortalEntity;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface EventDao {

    /**
     * @param id
     * @return the Event entity
     */
    @Select
    Event selectById(Integer id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Event entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Event entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Event entity);

    @Select
	List<Event> selectManagedEvent(String userId);

    @Select
	List<Event> selectJoinedEvents(String userId);

    @Select
	List<EventPortalEntity> selectAll(String userId);
    
    @Select
    EventPortalEntity selectByIdAndUserId(Integer id, String userId);
}