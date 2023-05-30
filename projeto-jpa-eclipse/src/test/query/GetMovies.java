package test.query;

import java.util.List;

import infra.DAO;
import model.manytomany.Actor;
import model.manytomany.Movie;

public class GetMovies {
	
	public static void main(String[] args) {
		
		DAO<Movie> dao = new DAO<>(Movie.class);
		
		List<Movie> movies = dao.selectByQuery("moviesWithScoreGreaterThan", "score", 5.0);
		
		for(Movie movie: movies) {
			System.out.println(movie.getName() + " => " + movie.getScore());
			
			for(Actor actor: movie.getActors()) {
				System.out.println(actor.getName());
			}
		}
		
	}

}
