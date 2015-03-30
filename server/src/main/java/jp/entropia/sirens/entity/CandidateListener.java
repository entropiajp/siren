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
public class CandidateListener implements EntityListener<Candidate> {

    @Override
    public void preInsert(Candidate entity, PreInsertContext<Candidate> context) {
    }

    @Override
    public void preUpdate(Candidate entity, PreUpdateContext<Candidate> context) {
    }

    @Override
    public void preDelete(Candidate entity, PreDeleteContext<Candidate> context) {
    }

    @Override
    public void postInsert(Candidate entity, PostInsertContext<Candidate> context) {
    }

    @Override
    public void postUpdate(Candidate entity, PostUpdateContext<Candidate> context) {
    }

    @Override
    public void postDelete(Candidate entity, PostDeleteContext<Candidate> context) {
    }
}