package jp.entropia.sirens.dao;

import java.util.List;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.Member;
import jp.entropia.sirens.entity.MemberEntity;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface MemberDao {

    /**
     * @param id
     * @return the Member entity
     */
    @Select
    Member selectById(Integer id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Member entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Member entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Member entity);

    @Select
	List<MemberEntity> selectAllJoinedMember(Integer eventId);

    @Select
	Member selectByEventIdAndUserId(Integer eventId, String userId);
}