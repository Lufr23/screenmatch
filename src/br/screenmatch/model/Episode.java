package br.screenmatch.model;

import br.screenmatch.calculations.Classifications;

public class Episode implements Classifications {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalViews;

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumber(int numero) {
        this.numero = numero;
    }

    public String getName() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }


    @Override
    public int getClassification() {
        if(totalViews>100){
            return 4;
        } else {
            return 2;
        }

    }
}
