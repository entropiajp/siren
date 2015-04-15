package jp.entropia.sirens.dao;

import java.util.List;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Role;
import jp.entropia.sirens.entity.RoleEntity;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface RoleDao {

    /**
     * @param roleId
     * @return the Role entity
     */
    @Select
    Role selectById(Integer id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Role entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Role entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Role entity);

    @Select
	List<RoleEntity> selectAll(Integer eventId);
}