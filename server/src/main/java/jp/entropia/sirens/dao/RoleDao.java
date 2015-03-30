package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Role;
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
    Role selectById(Integer roleId);

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
}