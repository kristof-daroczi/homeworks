package xyz.codingmentor.firstdb.service;

import java.util.Date;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.firstdb.api.AlbumDTO;
import xyz.codingmentor.firstdb.api.AlbumQuery;
import xyz.codingmentor.firstdb.api.RepositoryException;

/**
 *
 * @author Krisz
 */
@Stateless
public class AlbumQueryService {

    @Inject
    private AlbumQuery albumQuery;

    public AlbumQueryService() {
        //empty on purpose
    }

    public AlbumDTO getAlbumByName(String name) throws RepositoryException {
        return albumQuery.getAlbumByName(name);
    }

    public List<AlbumDTO> getAlbumsByCompositor(String compositor) throws RepositoryException {
        return albumQuery.getAlbumsByCompositor(compositor);
    }

    public List<AlbumDTO> getAlbumsReleasedBetween(Date begin, Date end) throws RepositoryException {
        return albumQuery.getAlbumsReleasedBetween(begin, end);
    }

    public void updateAlbumsGenreWhereCompositorStartsWithLetter(String letter) throws RepositoryException {
        albumQuery.updateAlbumsGenreWhereCompositorStartsWithLetter(letter);
    }

    public void deleteAllAlbumsWhereCompositorIsNotLike(String compositor) throws RepositoryException {
        albumQuery.deleteAllAlbumsWhereCompositorIsNotLike(compositor);
    }

    @PreDestroy
    private void preDestroy() {
        albumQuery.close();
    }
}
