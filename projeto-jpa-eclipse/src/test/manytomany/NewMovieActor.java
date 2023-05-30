package test.manytomany;

import infra.DAO;
import model.manytomany.Actor;
import model.manytomany.Movie;

public class NewMovieActor {
	
	public static void main(String[] args) {
		
		Movie movieA = new Movie("Movie A", 5.8);
		Movie movieB = new Movie("Movie A", 6.7);
		
		Actor actorA = new Actor("João das Neves");
		Actor actorB = new Actor("José Tempestade");
		
		movieA.addActor(actorA);
		movieA.addActor(actorB);
		
		movieB.addActor(actorA);
		
		DAO<Movie> dao = new DAO<Movie>();
		dao.insertWithTransacty(movieA);
		
	}

}
