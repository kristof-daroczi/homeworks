package xyz.codingmentor.firstdb.service;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.firstdb.api.AlbumDTO;
import xyz.codingmentor.firstdb.api.AlbumRepository;
import xyz.codingmentor.firstdb.api.RepositoryException;

/**
 *
 * @author Krisz
 */
@Stateless
public class AlbumCRUDService {

    @Inject
    private AlbumRepository albumrepository;

    public AlbumCRUDService() {
        //empty on purpose
    }

    public AlbumDTO createAlbum(String compositor, String albumName) throws RepositoryException {
        return albumrepository.createAlbum(compositor, albumName);
    }

    public AlbumDTO findAlbum(String compositor, String albumName) throws RepositoryException {
        return albumrepository.findAlbum(compositor, albumName);
    }

    public void updateAlbum(AlbumDTO album) throws RepositoryException {
        albumrepository.updateAlbum(album);
    }

    public void deleteAlbum(String compositor, String albumName) throws RepositoryException {
        albumrepository.deleteAlbum(compositor, albumName);
    }

    @PreDestroy
    private void preDestroy() {
        albumrepository.close();
    }
}
