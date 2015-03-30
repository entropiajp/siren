package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Vote;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface VoteDao {

    /**
     * @param memberId
     * @param candidateId
     * @return the Vote entity
     */
    @Select
    Vote selectById(Integer memberId, Integer candidateId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Vote entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Vote entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Vote entity);
}