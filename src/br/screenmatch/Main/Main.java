package br.screenmatch.Main;

import br.screenmatch.Calculations.RecommendationFilter;
import br.screenmatch.Calculations.TimeCalculator;
import br.screenmatch.Model.Episode;
import br.screenmatch.Model.Movie;
import br.screenmatch.Model.Serie;
import br.screenmatch.Model.Title;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Movie lovieRosie = new Movie("Lovie Rosie", 2014);
        lovieRosie.setDurationTime(102);

        lovieRosie.evaluation(10);
        lovieRosie.evaluation(7);
        lovieRosie.evaluation(5);

        lovieRosie.averageHandle();
        lovieRosie.displaysFile();
        System.out.println("Duration time: " + lovieRosie.getDurationTime() + "\n");

        Movie meBeforeYou = new Movie("Me before you", 2016);
        meBeforeYou.setDurationTime(110);

        meBeforeYou.evaluation(10);
        meBeforeYou.evaluation(7);
        meBeforeYou.evaluation(5);

        meBeforeYou.averageHandle();
        meBeforeYou.displaysFile();
        System.out.println("Duration time: " + meBeforeYou.getDurationTime() + "\n");

        Serie suits = new Serie("Suits", 2011);
        suits.setEpisodesPerSeason(22);
        suits.setMinutesPerEpisodes(44);
        suits.setSeason(8);
        suits.setAtiva(true);

        suits.evaluation(10);
        suits.evaluation(8);
        suits.evaluation(9);

        suits.displaysFile();
        System.out.println("Duration to marathon Suits: " + suits.getDurationTime() + "\n");

        TimeCalculator calculator = new TimeCalculator();
        calculator.includes(lovieRosie);
        calculator.includes(meBeforeYou);
        calculator.includes(suits);
        System.out.println("Total time to watch your entire list of favorite: " + calculator.getTotalTime() + "\n");

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(lovieRosie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSerie(suits);
        episode.setTotalViews(425);
       // filter.filter(episode);

        ArrayList<Title> titleList = new ArrayList<>();
        titleList.add(suits);
        titleList.add(lovieRosie);
        titleList.add(meBeforeYou);
        System.out.println("List size: " + titleList.size());
        System.out.println("First movie: " + titleList.get(0).getName() + "\n");

        for (Title item : titleList) {
            System.out.println(item);
            if (item instanceof Movie movie && movie.getClassification()>2) {
                System.out.println("Classification: " + movie.getClassification());
            }
        }

        System.out.println("After the ordenation");
        Collections.sort(titleList);
        System.out.println(titleList);
    }
}