package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Users;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface UsersDao {

    /**
     * @param username
     * @return the Users entity
     */
    @Select
    Users selectById(String username);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Users entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Users entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Users entity);
}