package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Part;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface PartDao {

    /**
     * @param partId
     * @return the Part entity
     */
    @Select
    Part selectById(Integer partId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Part entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Part entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Part entity);
}