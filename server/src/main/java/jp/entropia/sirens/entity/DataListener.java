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
public class DataListener implements EntityListener<Data> {

    @Override
    public void preInsert(Data entity, PreInsertContext<Data> context) {
    }

    @Override
    public void preUpdate(Data entity, PreUpdateContext<Data> context) {
    }

    @Override
    public void preDelete(Data entity, PreDeleteContext<Data> context) {
    }

    @Override
    public void postInsert(Data entity, PostInsertContext<Data> context) {
    }

    @Override
    public void postUpdate(Data entity, PostUpdateContext<Data> context) {
    }

    @Override
    public void postDelete(Data entity, PostDeleteContext<Data> context) {
    }
}