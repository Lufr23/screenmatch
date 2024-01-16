package br.screenmatch.model;

import br.screenmatch.calculations.Classifications;

public class Movie extends Title implements Classifications {
   private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) averageHandle()/2;
    }
    @Override
    public String toString(){
        return "Filme: " + this.getName() + "("+this.getReleaseYear()+")";

    }
}
