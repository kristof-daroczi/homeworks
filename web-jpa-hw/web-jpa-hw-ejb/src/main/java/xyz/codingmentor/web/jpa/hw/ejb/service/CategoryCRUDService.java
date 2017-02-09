package xyz.codingmentor.web.jpa.hw.ejb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepositoryQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDService;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDServiceQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.CategoryEntity;

/**
 *
 * @author Krisz
 */
@Stateless
@CRUDServiceQualifier(EntityModel.CATEGORY)
public class CategoryCRUDService extends GeneralCRUDService<CategoryEntity> implements CRUDService<CategoryEntity> {

    public CategoryCRUDService() {
        super(null);
    }

    @Inject
    public CategoryCRUDService(@CRUDRepositoryQualifier(EntityModel.CATEGORY) CRUDRepository<CategoryEntity> repository) {       
        super(repository);
    }
}
