package test.manytomany;

import infra.DAO;
import model.query.ScoreMovie;

public class GetAverageMovies {
	
	public static void main(String[] args) {
		
		DAO<ScoreMovie> dao = new DAO<>(ScoreMovie.class);
		
		ScoreMovie scoreMovie = dao.selectByNativeQuery("averageMovies");
		
		System.out.println(scoreMovie.getAverage());
		
		dao.close();
		
	}

}
