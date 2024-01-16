package br.screenmatch.model;

public class Serie extends Title {

    private int season;
    private int episodesPerSeason;
    private boolean ativa;
    private int minutesPerEpisodes;

    public Serie(String name, int releaseYear) {
        super(name, releaseYear);
    }


    public int getSeason() {
        return season;
    }

    public int getDurationTime(){
        return season*episodesPerSeason*minutesPerEpisodes;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

      public void setMinutesPerEpisodes(int minutesPerEpisodes) {
        this.minutesPerEpisodes = minutesPerEpisodes;
    }


}
