package lab02.operations;


import static UI.Reader.getPplNum;
import static lab02.operations.ListInitialization.getSkiList;
import static lab02.operations.Score.getListOfMatches;

public class Solution {

    public static int range;

    public static int findMinimum(){

        double min = Double.MAX_VALUE;
        for(int i = 0; i < 1000; i++){
            if(Score.getScoreList().get(i) <= min){
                min = Score.getScoreList().get(i);
            }
        }

        int id = 0;
//        System.out.println("FINAL min = " + min);
        for(int i = 0; i < 1000; i++){
            if(Score.getScoreList().get(i) == min){
                id = i;
                break;
            }
        }
        return id;
    }

    public static void findSolution(int id){

        if(getSkiList().size() < getPplNum())range = getSkiList().size();
        else range = getPplNum();

//        System.out.println("Najlepszym dopasowaniem jest = ");
//        for(int i = 0; i < range; i++){
//            System.out.println("id = " + getListOfMatches().get(id).get(i).getId() + " o preferencjach = "
//                    + getListOfMatches().get(id).get(i).getPreferredType() + " "
//                    + getListOfMatches().get(id).get(i).getPreferredLength() + " z dopasowanymi nartami "
//                    + getListOfMatches().get(id).get(i).getSkiLength() + " "
//                    + getListOfMatches().get(id).get(i).getSkiType());
//        }
//        if(range == getSkiList().size()) System.out.println("Reszcie nie dopasowano nart, tj. " + Score.getNotServed() + " klientom");
    }

    public static void bestSkiMatch(){

        Score.finalResult(1000);
        findSolution(findMinimum());

    }

    public static int getRange() {
        return range;
    }
}
