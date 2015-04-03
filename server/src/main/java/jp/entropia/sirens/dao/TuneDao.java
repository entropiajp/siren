package jp.entropia.sirens.dao;

import java.util.List;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Tune;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface TuneDao {

    /**
     * @param id
     * @return the Tune entity
     */
    @Select
    Tune selectById(Integer id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Tune entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Tune entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Tune entity);
    
    @Select
    List<Tune> selectAll();

    @Select
	List<String> selectStoredArtists();
    
    @Select
	List<String> selectStoredSources();
    
}