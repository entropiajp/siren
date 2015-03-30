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
public class MemberListener implements EntityListener<Member> {

    @Override
    public void preInsert(Member entity, PreInsertContext<Member> context) {
    }

    @Override
    public void preUpdate(Member entity, PreUpdateContext<Member> context) {
    }

    @Override
    public void preDelete(Member entity, PreDeleteContext<Member> context) {
    }

    @Override
    public void postInsert(Member entity, PostInsertContext<Member> context) {
    }

    @Override
    public void postUpdate(Member entity, PostUpdateContext<Member> context) {
    }

    @Override
    public void postDelete(Member entity, PostDeleteContext<Member> context) {
    }
}