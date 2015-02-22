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
public class AuthoritiesListener implements EntityListener<Authorities> {

    @Override
    public void preInsert(Authorities entity, PreInsertContext<Authorities> context) {
    }

    @Override
    public void preUpdate(Authorities entity, PreUpdateContext<Authorities> context) {
    }

    @Override
    public void preDelete(Authorities entity, PreDeleteContext<Authorities> context) {
    }

    @Override
    public void postInsert(Authorities entity, PostInsertContext<Authorities> context) {
    }

    @Override
    public void postUpdate(Authorities entity, PostUpdateContext<Authorities> context) {
    }

    @Override
    public void postDelete(Authorities entity, PostDeleteContext<Authorities> context) {
    }
}