Scripteket nem írtam,a postmanban teszteltem mindent(több entitással is)

REST servicek:

-Category:
JSON:
{
	"id": 1,
	"name": "action"
}
-POST: http://localhost:8080/web-jpa-hw-war/rest/categories
-GET: http://localhost:8080/web-jpa-hw-war/rest/categories/1
-PUT: http://localhost:8080/web-jpa-hw-war/rest/categories
-DELETE: http://localhost:8080/web-jpa-hw-war/rest/categories/1

-Actor:
JSON:
{
  "firstname": "John",
  "id": 1,
  "lastname": "Doe",
  "nationality": "America"
}
-POST: http://localhost:8080/web-jpa-hw-war/rest/actors
-GET: http://localhost:8080/web-jpa-hw-war/rest/actors/1
-PUT: http://localhost:8080/web-jpa-hw-war/rest/actors
-DELETE: http://localhost:8080/web-jpa-hw-war/rest/actors/1

-Film:
JSON:
{
	"id": 1,
	"title": "Django"
}
-POST: http://localhost:8080/web-jpa-hw-war/rest/films
-GET: http://localhost:8080/web-jpa-hw-war/rest/films/1
-PUT: http://localhost:8080/web-jpa-hw-war/rest/films
-DELETE: http://localhost:8080/web-jpa-hw-war/rest/films/1

-Trailer:
JSON:
{
	"id": 1,
	"url": "someurl.com",
	"title": "Django preview"
}
-POST: http://localhost:8080/web-jpa-hw-war/rest/trailers
-GET: http://localhost:8080/web-jpa-hw-war/rest/trailers/1
-PUT: http://localhost:8080/web-jpa-hw-war/rest/trailers
-DELETE: http://localhost:8080/web-jpa-hw-war/rest/trailers/1

-Adder (Minden GET):
-addCategoryToFilm: http://localhost:8080/web-jpa-hw-war/rest/adder/categorytofilm?filmId=1&actorId=1
-addTrailerToFilm: http://localhost:8080/web-jpa-hw-war/rest/adder/trailertofilm?filmId=1&trailerId=1
-addFilmtoActor: http://localhost:8080/web-jpa-hw-war/rest/adder/filmtoactor?filmId=1&actorId=1

-Query (Minden GET):
-getFilmsByTitle: http://localhost:8080/web-jpa-hw-war/rest/queries/filmsbytitle?title=Django
-getActorsByName: http://localhost:8080/web-jpa-hw-war/rest/queries/actorsbyname?firstname=John&lastname=Doe
-getActorsByNationality: http://localhost:8080/web-jpa-hw-war/rest/queries/actorsbynationality?nationality=America
-getTrailersbyFilm: http://localhost:8080/web-jpa-hw-war/rest/queries/trailersbyfilm?filmId=1