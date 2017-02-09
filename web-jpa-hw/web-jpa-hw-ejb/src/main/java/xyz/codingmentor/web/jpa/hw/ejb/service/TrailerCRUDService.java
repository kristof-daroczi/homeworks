package xyz.codingmentor.web.jpa.hw.ejb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepositoryQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDService;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDServiceQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.TrailerEntity;

/**
 *
 * @author Krisz
 */
@Stateless
@CRUDServiceQualifier(EntityModel.TRAILER)
public class TrailerCRUDService extends GeneralCRUDService<TrailerEntity> implements CRUDService<TrailerEntity> {

    public TrailerCRUDService() {
        super(null);
    }

    @Inject
    public TrailerCRUDService(@CRUDRepositoryQualifier(EntityModel.TRAILER) CRUDRepository<TrailerEntity> repository) {
        super(repository);
    }

}
