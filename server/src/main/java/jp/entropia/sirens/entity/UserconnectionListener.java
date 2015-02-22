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
public class UserconnectionListener implements EntityListener<Userconnection> {

    @Override
    public void preInsert(Userconnection entity, PreInsertContext<Userconnection> context) {
    }

    @Override
    public void preUpdate(Userconnection entity, PreUpdateContext<Userconnection> context) {
    }

    @Override
    public void preDelete(Userconnection entity, PreDeleteContext<Userconnection> context) {
    }

    @Override
    public void postInsert(Userconnection entity, PostInsertContext<Userconnection> context) {
    }

    @Override
    public void postUpdate(Userconnection entity, PostUpdateContext<Userconnection> context) {
    }

    @Override
    public void postDelete(Userconnection entity, PostDeleteContext<Userconnection> context) {
    }
}