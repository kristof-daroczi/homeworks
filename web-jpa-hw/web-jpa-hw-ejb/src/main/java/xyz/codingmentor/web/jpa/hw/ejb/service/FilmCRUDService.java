package xyz.codingmentor.web.jpa.hw.ejb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepositoryQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDService;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDServiceQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.FilmEntity;

/**
 *
 * @author Krisz
 */
@Stateless
@CRUDServiceQualifier(EntityModel.FILM)
public class FilmCRUDService extends GeneralCRUDService<FilmEntity> implements CRUDService<FilmEntity> {

    public FilmCRUDService() {
        super(null);
    }

    @Inject
    public FilmCRUDService(@CRUDRepositoryQualifier(EntityModel.FILM) CRUDRepository<FilmEntity> repository) {
        super(repository);
    }

}
