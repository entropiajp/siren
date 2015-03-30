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
public class TuneListener implements EntityListener<Tune> {

    @Override
    public void preInsert(Tune entity, PreInsertContext<Tune> context) {
    }

    @Override
    public void preUpdate(Tune entity, PreUpdateContext<Tune> context) {
    }

    @Override
    public void preDelete(Tune entity, PreDeleteContext<Tune> context) {
    }

    @Override
    public void postInsert(Tune entity, PostInsertContext<Tune> context) {
    }

    @Override
    public void postUpdate(Tune entity, PostUpdateContext<Tune> context) {
    }

    @Override
    public void postDelete(Tune entity, PostDeleteContext<Tune> context) {
    }
}