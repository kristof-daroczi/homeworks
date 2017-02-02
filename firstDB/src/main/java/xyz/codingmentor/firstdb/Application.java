package xyz.codingmentor.firstdb;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.firstdb.api.AlbumDTO;
import xyz.codingmentor.firstdb.api.RepositoryException;
import xyz.codingmentor.firstdb.entity.GenreEnum;
import xyz.codingmentor.firstdb.service.AlbumCRUDService;
import xyz.codingmentor.firstdb.service.AlbumQueryService;

/**
 *
 * @author Krisz
 */
public class Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    @Inject
    private AlbumCRUDService albumCRUDService;
    @Inject
    private AlbumQueryService albumQueryService;

    public void execute() throws RepositoryException {

        AlbumDTO album1 = albumCRUDService.createAlbum("Metallica", "Black album");
        album1.setGenre(GenreEnum.ROCK);
        GregorianCalendar gregDate = new GregorianCalendar(1991, 7, 12);
        Date date = gregDate.getTime();
        album1.setPublishDate(date);
        albumCRUDService.updateAlbum(album1);

        AlbumDTO album3 = albumCRUDService.createAlbum("Megadeth", "Youthanasia");
        album3.setGenre(GenreEnum.METAL);
        GregorianCalendar gregDate3 = new GregorianCalendar(1995, 9, 31);
        Date date3 = gregDate3.getTime();
        album3.setPublishDate(date3);
        albumCRUDService.updateAlbum(album3);

        AlbumDTO album2 = albumCRUDService.createAlbum("Bon Jovi", "Crush");
        album2.setGenre(GenreEnum.ROCK);
        GregorianCalendar gregDate2 = new GregorianCalendar(2001, 5, 13);
        Date date2 = gregDate2.getTime();
        album2.setPublishDate(date2);
        albumCRUDService.updateAlbum(album2);

        LOGGER.log(Level.INFO, albumCRUDService.findAlbum("Bon Jovi", "Crush").toString());

        LOGGER.log(Level.INFO, albumQueryService.getAlbumByName("Black album").toString());

        List<AlbumDTO> result = albumQueryService.getAlbumsByCompositor("Bon Jovi");
        printResultList(result);
        albumCRUDService.deleteAlbum("Bon Jovi", "Crush");

        GregorianCalendar gregBeginDate = new GregorianCalendar(1990, 7, 12);
        Date beginDate = gregBeginDate.getTime();
        GregorianCalendar gregEndDate = new GregorianCalendar(1996, 7, 12);
        Date endDate = gregEndDate.getTime();
        List<AlbumDTO> result2 = albumQueryService.getAlbumsReleasedBetween(beginDate, endDate);
        printResultList(result2);

        albumQueryService.updateAlbumsGenreWhereCompositorStartsWithLetter("M");
        albumQueryService.deleteAllAlbumsWhereCompositorIsNotLike("Metallica");

    }

    private static void printResultList(List<AlbumDTO> albums) {
        for (AlbumDTO album : albums) {
            LOGGER.log(Level.INFO, album.toString());
        }
    }
}
