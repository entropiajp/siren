package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Candidate;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface CandidateDao {

    /**
     * @param eventId
     * @param tuneId
     * @return the Candidate entity
     */
    @Select
    Candidate selectById(Integer eventId, Integer tuneId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Candidate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Candidate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Candidate entity);

    @Delete(sqlFile = true)
	int deleteAll(Integer eventId);
}