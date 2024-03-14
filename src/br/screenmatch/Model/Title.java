package br.screenmatch.Model;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private double sumEvaluation;
    private int totalEvaluation;
    private int durationTime;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(OmdbTitle myTitleOmdb) {
        this.name = myTitleOmdb.title();
        if(myTitleOmdb.year().length()>4){
            throw new ErrorConvertionExeception(" Cannot to convert the year because have more four caracters");
        }
        this.releaseYear = Integer.parseInt(myTitleOmdb.year());
        this.durationTime = Integer.valueOf(myTitleOmdb.runtime().substring(0, 3));
    }

    public void displaysFile() {
        System.out.println("Title: " + name);
        System.out.println("Release year: " + releaseYear);
        System.out.println("Evaluation: " + averageHandle());
        System.out.println("Total evaluations: " + getTotalEvaluation());
            }

    public int getTotalEvaluation() {
        return totalEvaluation;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

      public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }


    public void evaluation(int note) {
        sumEvaluation += note;
        totalEvaluation++;
    }

    public String getName() {
        return name;
    }

    public double averageHandle() {
        return sumEvaluation / totalEvaluation;
    }

    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

public String toString(){
    return "Title: " + name + "\n" +
            "Release Year: " + releaseYear + "\n" +
            "Duration Time: " + durationTime +"min";
}
}
