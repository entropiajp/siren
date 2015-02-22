package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Authorities;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface AuthoritiesDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Authorities entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Authorities entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Authorities entity);
}