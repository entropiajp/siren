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
public class PartListener implements EntityListener<Part> {

    @Override
    public void preInsert(Part entity, PreInsertContext<Part> context) {
    }

    @Override
    public void preUpdate(Part entity, PreUpdateContext<Part> context) {
    }

    @Override
    public void preDelete(Part entity, PreDeleteContext<Part> context) {
    }

    @Override
    public void postInsert(Part entity, PostInsertContext<Part> context) {
    }

    @Override
    public void postUpdate(Part entity, PostUpdateContext<Part> context) {
    }

    @Override
    public void postDelete(Part entity, PostDeleteContext<Part> context) {
    }
}