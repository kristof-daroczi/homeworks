package xyz.codingmentor.firstdb.api;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Krisz
 */
public interface AlbumQuery {

    AlbumDTO getAlbumByName(String name) throws RepositoryException;

    List<AlbumDTO> getAlbumsByCompositor(String compositor) throws RepositoryException;

    List<AlbumDTO> getAlbumsReleasedBetween(Date begin, Date end) throws RepositoryException;

    void updateAlbumsGenreWhereCompositorStartsWithLetter(String letter) throws RepositoryException;

    void deleteAllAlbumsWhereCompositorIsNotLike(String compositor) throws RepositoryException;

    void close();
}
