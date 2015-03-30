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
public class ManagerListener implements EntityListener<Manager> {

    @Override
    public void preInsert(Manager entity, PreInsertContext<Manager> context) {
    }

    @Override
    public void preUpdate(Manager entity, PreUpdateContext<Manager> context) {
    }

    @Override
    public void preDelete(Manager entity, PreDeleteContext<Manager> context) {
    }

    @Override
    public void postInsert(Manager entity, PostInsertContext<Manager> context) {
    }

    @Override
    public void postUpdate(Manager entity, PostUpdateContext<Manager> context) {
    }

    @Override
    public void postDelete(Manager entity, PostDeleteContext<Manager> context) {
    }
}