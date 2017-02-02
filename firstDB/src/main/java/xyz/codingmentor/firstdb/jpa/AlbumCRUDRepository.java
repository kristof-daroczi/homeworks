package xyz.codingmentor.firstdb.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import xyz.codingmentor.firstdb.api.AlbumDTO;
import xyz.codingmentor.firstdb.api.AlbumRepository;
import xyz.codingmentor.firstdb.api.RepositoryException;
import xyz.codingmentor.firstdb.entity.AlbumEntity;
import xyz.codingmentor.firstdb.entity.AlbumId;

/**
 *
 * @author Krisz
 */
@Stateless
public class AlbumCRUDRepository implements AlbumRepository {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;

    public AlbumCRUDRepository() {
        factory = Persistence.createEntityManagerFactory("homeworkPU");
        entityManager = factory.createEntityManager();
    }

    @Override
    public AlbumDTO createAlbum(String compositor, String albumName) throws RepositoryException {
        AlbumId id = new AlbumId(compositor, albumName);
        AlbumEntity album = new AlbumEntity();
        album.setId(id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(album);
        tx.commit();
        return buildAlbumDTO(album);
    }

    @Override
    public AlbumDTO findAlbum(String compositor, String albumName) throws RepositoryException {
        AlbumId id = new AlbumId(compositor, albumName);
        AlbumEntity album = new AlbumEntity();
        album.setId(id);
        AlbumEntity searchResult = entityManager.find(AlbumEntity.class, album.getId());
        if (searchResult != null) {
            return buildAlbumDTO(searchResult);
        }
        return null;
    }

    @Override
    public void updateAlbum(AlbumDTO album) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        AlbumEntity searchEntity = entityManager.find(AlbumEntity.class, album.getId());
        searchEntity.setGenre(album.getGenre());
        searchEntity.setPublishDate(album.getPublishDate());
        searchEntity.setId(album.getId());
        entityManager.merge(searchEntity);
        tx.commit();
    }

    @Override
    public void deleteAlbum(String compositor, String albumName) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        AlbumId id = new AlbumId(compositor, albumName);
        AlbumEntity album = new AlbumEntity();
        album.setId(id);
        AlbumEntity searchResult = entityManager.find(AlbumEntity.class, album.getId());
        if (searchResult != null) {
            entityManager.remove(searchResult);
        }
        tx.commit();
    }

    @Override
    public void close() {
        factory.close();
        entityManager.close();
    }

    private static AlbumDTO buildAlbumDTO(AlbumEntity album) {
        AlbumDTO dto = new AlbumDTO();
        dto.setGenre(album.getGenre());
        dto.setPublishDate(album.getPublishDate());
        dto.setId(album.getId());
        return dto;
    }

}
