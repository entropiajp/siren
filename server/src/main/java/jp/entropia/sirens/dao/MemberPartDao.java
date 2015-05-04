package jp.entropia.sirens.dao;

import jp.entropia.sirens.ConfigAutowireable;
import jp.entropia.sirens.entity.MemberPart;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
@ConfigAutowireable
public interface MemberPartDao {

    /**
     * @param memberId
     * @param partId
     * @return the MemberPart entity
     */
    @Select
    MemberPart selectById(Integer memberId, Integer partId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MemberPart entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MemberPart entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MemberPart entity);
    
    @Delete(sqlFile=true)
    int deleteByEventId(Integer eventId);
}