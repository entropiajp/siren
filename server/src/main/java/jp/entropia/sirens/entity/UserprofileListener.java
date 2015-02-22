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
public class UserprofileListener implements EntityListener<Userprofile> {

    @Override
    public void preInsert(Userprofile entity, PreInsertContext<Userprofile> context) {
    }

    @Override
    public void preUpdate(Userprofile entity, PreUpdateContext<Userprofile> context) {
    }

    @Override
    public void preDelete(Userprofile entity, PreDeleteContext<Userprofile> context) {
    }

    @Override
    public void postInsert(Userprofile entity, PostInsertContext<Userprofile> context) {
    }

    @Override
    public void postUpdate(Userprofile entity, PostUpdateContext<Userprofile> context) {
    }

    @Override
    public void postDelete(Userprofile entity, PostDeleteContext<Userprofile> context) {
    }
}