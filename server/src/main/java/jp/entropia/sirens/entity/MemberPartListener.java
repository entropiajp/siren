package jp.entropia.sirens.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class MemberPartListener implements EntityListener<MemberPart> {

    @Override
    public void preInsert(MemberPart entity, PreInsertContext<MemberPart> context) {
    }

    @Override
    public void preUpdate(MemberPart entity, PreUpdateContext<MemberPart> context) {
    }

    @Override
    public void preDelete(MemberPart entity, PreDeleteContext<MemberPart> context) {
    }

    @Override
    public void postInsert(MemberPart entity, PostInsertContext<MemberPart> context) {
    }

    @Override
    public void postUpdate(MemberPart entity, PostUpdateContext<MemberPart> context) {
    }

    @Override
    public void postDelete(MemberPart entity, PostDeleteContext<MemberPart> context) {
    }
}