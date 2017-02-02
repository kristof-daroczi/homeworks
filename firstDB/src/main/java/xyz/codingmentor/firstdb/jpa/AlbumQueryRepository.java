package xyz.codingmentor.firstdb.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import xyz.codingmentor.firstdb.api.AlbumDTO;
import xyz.codingmentor.firstdb.api.AlbumQuery;
import xyz.codingmentor.firstdb.api.RepositoryException;
import xyz.codingmentor.firstdb.entity.AlbumEntity;
import xyz.codingmentor.firstdb.entity.GenreEnum;

/**
 *
 * @author Krisz
 */
@Stateless
public class AlbumQueryRepository implements AlbumQuery {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;

    public AlbumQueryRepository() {
        factory = Persistence.createEntityManagerFactory("homeworkPU");
        entityManager = factory.createEntityManager();
    }

    private static AlbumDTO buildAlbumDTO(AlbumEntity album) {
        AlbumDTO dto = new AlbumDTO();
        dto.setGenre(album.getGenre());
        dto.setPublishDate(album.getPublishDate());
        dto.setId(album.getId());
        return dto;
    }

    @Override
    public AlbumDTO getAlbumByName(String name) throws RepositoryException {
        String selectQuery = "SELECT album FROM AlbumEntity album WHERE album.id.albumName LIKE :name";
        TypedQuery<AlbumEntity> query = entityManager.createQuery(selectQuery, AlbumEntity.class);
        query.setParameter("name", "%" + name + "%");

        AlbumEntity result = query.getSingleResult();
        return buildAlbumDTO(result);

    }

    @Override
    public List<AlbumDTO> getAlbumsByCompositor(String compositor) throws RepositoryException {
        String selectQuery = "SELECT album FROM AlbumEntity album WHERE album.id.compositor LIKE :comp";
        TypedQuery<AlbumEntity> query = entityManager.createQuery(selectQuery, AlbumEntity.class);
        query.setParameter("comp", "%" + compositor + "%");

        List<AlbumEntity> albums = query.getResultList();

        List<AlbumDTO> result = new ArrayList<>();
        for (AlbumEntity entity : albums) {
            result.add(buildAlbumDTO(entity));
        }
        return result;
    }

    @Override
    public List<AlbumDTO> getAlbumsReleasedBetween(Date begin, Date end) throws RepositoryException {
        String selectQuery = "SELECT album FROM AlbumEntity album WHERE album.publishDate BETWEEN :begin AND :end ";
        TypedQuery<AlbumEntity> query = entityManager.createQuery(selectQuery, AlbumEntity.class);
        query.setParameter("begin", begin);
        query.setParameter("end", end);

        List<AlbumEntity> albums = query.getResultList();

        List<AlbumDTO> result = new ArrayList<>();
        for (AlbumEntity entity : albums) {
            result.add(buildAlbumDTO(entity));
        }
        return result;
    }

    @Override
    public void updateAlbumsGenreWhereCompositorStartsWithLetter(String letter) throws RepositoryException {
        String updateQuery = "UPDATE AlbumEntity album SET album.genre = :newGengre WHERE album.id.compositor LIKE :letter";
        Query query = entityManager.createQuery(updateQuery);
        query.setParameter("letter", letter + "%");
        query.setParameter("newGengre", GenreEnum.METAL);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        query.executeUpdate();
        tx.commit();

    }

    @Override
    public void deleteAllAlbumsWhereCompositorIsNotLike(String compositor) throws RepositoryException {
        String deleteQuery = "DELETE FROM AlbumEntity album WHERE album.id.compositor NOT LIKE :compositor";
        Query query = entityManager.createQuery(deleteQuery);
        query.setParameter("compositor", compositor);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        query.executeUpdate();
        tx.commit();
    }

    @Override
    public void close() {
        factory.close();
        entityManager.close();
    }
}
