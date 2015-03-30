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
public class EventListener implements EntityListener<Event> {

    @Override
    public void preInsert(Event entity, PreInsertContext<Event> context) {
    }

    @Override
    public void preUpdate(Event entity, PreUpdateContext<Event> context) {
    }

    @Override
    public void preDelete(Event entity, PreDeleteContext<Event> context) {
    }

    @Override
    public void postInsert(Event entity, PostInsertContext<Event> context) {
    }

    @Override
    public void postUpdate(Event entity, PostUpdateContext<Event> context) {
    }

    @Override
    public void postDelete(Event entity, PostDeleteContext<Event> context) {
    }
}