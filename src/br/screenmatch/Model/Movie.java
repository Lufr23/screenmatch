package br.screenmatch.Model;

import br.screenmatch.Calculations.Classifications;

public class Movie extends Title implements Classifications {
   private String director;

    public Movie(String name, int releaseYear) {
        super(name, releaseYear);
    }

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
