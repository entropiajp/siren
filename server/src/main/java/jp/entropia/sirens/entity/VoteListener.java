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
public class VoteListener implements EntityListener<Vote> {

    @Override
    public void preInsert(Vote entity, PreInsertContext<Vote> context) {
    }

    @Override
    public void preUpdate(Vote entity, PreUpdateContext<Vote> context) {
    }

    @Override
    public void preDelete(Vote entity, PreDeleteContext<Vote> context) {
    }

    @Override
    public void postInsert(Vote entity, PostInsertContext<Vote> context) {
    }

    @Override
    public void postUpdate(Vote entity, PostUpdateContext<Vote> context) {
    }

    @Override
    public void postDelete(Vote entity, PostDeleteContext<Vote> context) {
    }
}