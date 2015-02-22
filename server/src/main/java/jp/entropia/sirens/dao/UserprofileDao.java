package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Userprofile;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface UserprofileDao {

    /**
     * @param userid
     * @return the Userprofile entity
     */
    @Select
    Userprofile selectById(String userid);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Userprofile entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Userprofile entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Userprofile entity);
}