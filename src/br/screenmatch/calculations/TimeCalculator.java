package br.screenmatch.calculations;

import br.screenmatch.model.Movie;


public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }


    public void includesMovie(Movie movie){
        totalTime += movie.getDurationTime();
    }
}
