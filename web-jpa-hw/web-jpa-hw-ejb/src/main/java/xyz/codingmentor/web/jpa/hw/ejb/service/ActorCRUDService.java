package xyz.codingmentor.web.jpa.hw.ejb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepositoryQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDService;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDServiceQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.ActorEntity;

/**
 *
 * @author Krisz
 */
@Stateless
@CRUDServiceQualifier(EntityModel.ACTOR)
public class ActorCRUDService extends GeneralCRUDService<ActorEntity> implements CRUDService<ActorEntity> {

    public ActorCRUDService() {
        super(null);
    }

    @Inject
    public ActorCRUDService(@CRUDRepositoryQualifier(EntityModel.ACTOR) CRUDRepository<ActorEntity> repository) {
        super(repository);
    }

}
