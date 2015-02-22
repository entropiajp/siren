package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Data;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface DataDao {

    /**
     * @param userid
     * @return the Data entity
     */
    @Select
    Data selectById(String userid);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Data entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Data entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Data entity);
}