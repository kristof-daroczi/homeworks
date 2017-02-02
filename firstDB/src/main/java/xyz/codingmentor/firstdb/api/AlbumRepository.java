package xyz.codingmentor.firstdb.api;

/**
 *
 * @author Krisz
 */
public interface AlbumRepository {

    AlbumDTO createAlbum(String compositor, String albumName) throws RepositoryException;

    AlbumDTO findAlbum(String compositor, String albumName) throws RepositoryException;

    void updateAlbum(AlbumDTO album) throws RepositoryException;

    void deleteAlbum(String compositor, String albumName) throws RepositoryException;
    
    void close();

}
