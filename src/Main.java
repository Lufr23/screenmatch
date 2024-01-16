
import br.screenmatch.calculations.RecommendationFilter;
import br.screenmatch.calculations.TimeCalculator;
import br.screenmatch.model.Episode;
import br.screenmatch.model.Movie;
import br.screenmatch.model.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie lovieRosie = new Movie("Lovie Rosie", 2014);
        lovieRosie.setDurationTime(102);

        lovieRosie.evaluation(10);
        lovieRosie.evaluation(7);
        lovieRosie.evaluation(5);

        lovieRosie.averageHandle();
        lovieRosie.displaysFile();
        System.out.println("Duration time: "+ lovieRosie.getDurationTime()+"\n");

        Movie meBeforeYou = new Movie("Me before you",2016);
        meBeforeYou.setDurationTime(110);

        meBeforeYou.evaluation(10);
        meBeforeYou.evaluation(7);
        meBeforeYou.evaluation(5);

        meBeforeYou.averageHandle();
        meBeforeYou.displaysFile();
        System.out.println("Duration time: "+ meBeforeYou.getDurationTime()+"\n");

        Serie suits = new Serie("Suits",2011);
        suits.setEpisodesPerSeason(22);
        suits.setMinutesPerEpisodes(44);
        suits.setSeason(8);
        suits.setAtiva(true);

        suits.evaluation(10);
        suits.evaluation(8);
        suits.evaluation(9);

        suits.displaysFile();
        System.out.println("Duration to marathon Suits: "+ suits.getDurationTime()+"\n");

        TimeCalculator calculator = new TimeCalculator();
        calculator.includes(lovieRosie);
        calculator.includes(meBeforeYou);
        calculator.includes(suits);
        System.out.println("Total time to watch your entire list of favorite: " + calculator.getTotalTime()+"\n");

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(lovieRosie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSerie(suits);
        episode.setTotalViews(425);
        filter.filter(episode);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(lovieRosie);
        movieList.add(meBeforeYou);
        System.out.println("List size: " + movieList.size());
        System.out.println("First movie: "+ movieList.get(0).getName());
        System.out.println(movieList);
    }
}