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
public class SongListener implements EntityListener<Song> {

    @Override
    public void preInsert(Song entity, PreInsertContext<Song> context) {
    }

    @Override
    public void preUpdate(Song entity, PreUpdateContext<Song> context) {
    }

    @Override
    public void preDelete(Song entity, PreDeleteContext<Song> context) {
    }

    @Override
    public void postInsert(Song entity, PostInsertContext<Song> context) {
    }

    @Override
    public void postUpdate(Song entity, PostUpdateContext<Song> context) {
    }

    @Override
    public void postDelete(Song entity, PostDeleteContext<Song> context) {
    }
}