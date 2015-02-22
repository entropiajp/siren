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
public class UsersListener implements EntityListener<Users> {

    @Override
    public void preInsert(Users entity, PreInsertContext<Users> context) {
    }

    @Override
    public void preUpdate(Users entity, PreUpdateContext<Users> context) {
    }

    @Override
    public void preDelete(Users entity, PreDeleteContext<Users> context) {
    }

    @Override
    public void postInsert(Users entity, PostInsertContext<Users> context) {
    }

    @Override
    public void postUpdate(Users entity, PostUpdateContext<Users> context) {
    }

    @Override
    public void postDelete(Users entity, PostDeleteContext<Users> context) {
    }
}