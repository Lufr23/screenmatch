package br.screenmatch.calculations;

import br.screenmatch.model.Movie;
import br.screenmatch.model.Serie;
import br.screenmatch.model.Title;


public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }


    public void includes(Title title){
        totalTime += title.getDurationTime();
    }
}
