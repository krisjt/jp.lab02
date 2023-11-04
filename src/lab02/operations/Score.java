package lab02.operations;

import lab02.data.Kind;

import java.util.ArrayList;
import java.util.List;

import static UI.Reader.getPplNum;
import static lab02.operations.ListInitialization.*;

public class Score {

    private static List<Double> scoreList = new ArrayList<>();
    private static List<List<Result>> listOfMatches = new ArrayList<>();
    private static int notServed;

    public static void finalResult(int numOfRepetitions){
            for(int i = 0; i < numOfRepetitions; i++){
                match();
            }
    }
    public static void match(){

        shuffleSkiList(getSkiList());
        shufflePreferenceList(getPreferenceList());

        List<Result> memo = new ArrayList<>();
        double totalScore = 0;

        int range;
        if(getSkiList().size() < getPplNum())range = getSkiList().size();
        else range = getPplNum();

        calculateForEach(Kind.C, memo);
        calculateForEach(Kind.J, memo);
        calculateForEach(Kind.A, memo);

//        for (int i = 0; i < range; i++) {
//
//                int preferredLength = getPreferenceList().get(i).lskis.getLength();
//                int skiLength = getSkiList().get(i).getLength();
//
//                Kind kind = getPreferenceList().get(i).person.getKind();
//                int id = getPreferenceList().get(i).person.getId();
//
//                String preferredType = getPreferenceList().get(i).lskis.getType();
//                String skiType = getSkiList().get(i).getType();
//
//                double score = calculateResult(preferredLength, skiLength, kind, preferredType, skiType);
//
//            memo.add(new Result(id, preferredType, preferredLength, skiType, skiLength, score));
//
//        }

        for (int i = 0; i < range; i++) {
                totalScore += memo.get(i).getScore();
        }

//        System.out.println("total = ");

        if(getSkiList().size() < getPreferenceList().size()) notServed = getPplNum() - getSkiList().size();
        totalScore = totalScore + (notServed * 0.1);
        listOfMatches.add(memo);
        scoreList.add(totalScore);
//        System.out.println(totalScore);
    }



    private static double calculateResult(int preferredLength, int skiLength, Kind kind, String preferredType, String skiType){
        double lengthScore = (Math.abs(preferredLength - skiLength))*0.01;
        int discount = ListInitialization.getDiscountList().get(kind);
        double penalty;

        if(preferredType.equals(skiType))penalty = 1;
        else penalty = 1.5;

        return penalty*lengthScore*(100-discount)/100;
    }

    public static List<Double> getScoreList() {
        return scoreList;
    }

    private static void calculateForEach(Kind kind, List<Result> memo){
        int range;
        if(getSkiList().size() < getPplNum())range = getSkiList().size();
        else range = getPplNum();

        for (int i = 0; i < range; i++) {

            Kind kind1 = getPreferenceList().get(i).person.getKind();

            if(kind == kind1) {
                int preferredLength = getPreferenceList().get(i).ski.getLength();
                int skiLength = getSkiList().get(i).getLength();

                int id = getPreferenceList().get(i).person.getId();

                String preferredType = getPreferenceList().get(i).ski.getType();
                String skiType = getSkiList().get(i).getType();

                double score = calculateResult(preferredLength, skiLength, kind, preferredType, skiType);

                memo.add(new Result(id, preferredType, preferredLength, skiType, skiLength, score));
            }

        }
    }

    public static List<List<Result>> getListOfMatches() {
        return listOfMatches;
    }

    public static int getNotServed() {
        return notServed;
    }
}
