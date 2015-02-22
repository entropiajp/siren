package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Userconnection;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface UserconnectionDao {

    /**
     * @param userid
     * @param providerid
     * @param provideruserid
     * @return the Userconnection entity
     */
    @Select
    Userconnection selectById(String userid, String providerid, String provideruserid);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Userconnection entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Userconnection entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Userconnection entity);
}