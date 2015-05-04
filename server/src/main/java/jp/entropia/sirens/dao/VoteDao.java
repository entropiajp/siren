package jp.entropia.sirens.dao;

import java.util.List;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.CheckableTune;
import jp.entropia.sirens.entity.Vote;
import jp.entropia.sirens.entity.VoteResult;

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
     * @param tuneId
     * @return the Vote entity
     */
    @Select
    Vote selectById(Integer memberId, Integer tuneId);

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

	@Delete(sqlFile = true)
	int deleteAll(Integer memberId);

	@Select
	List<CheckableTune> selectAllTunesWithVotes(Integer memberId);

	@Select
	List<VoteResult> selectVoteResult(Integer eventId);
	
	@Delete(sqlFile=true)
    int deleteByEventId(Integer eventId);
}