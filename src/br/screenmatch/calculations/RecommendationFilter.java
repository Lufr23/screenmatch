package br.screenmatch.calculations;

public class RecommendationFilter {
    private String recommendation;

    public void filter(Classifications classifications){
        if(classifications.getClassification()>4){
            System.out.println("This title is among the favorites");
        } else if (classifications.getClassification()>2) {
            System.out.println("This title is very highly rated");
        }else{
            System.out.println("Put this tilte on your favorites list");
        }
    }
}
