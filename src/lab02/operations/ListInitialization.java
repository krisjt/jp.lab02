package lab02.operations;

import lab02.data.Kind;
import lab02.data.Person;
import lab02.data.Preference;
import lab02.data.Ski;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static UI.Reader.*;
import static java.lang.Integer.parseInt;


public class ListInitialization {

    private static List<Preference> preferenceList = new ArrayList<>();
    private static Map<Kind,Integer> discountList = new HashMap<>();
    private static List<Ski> skiList = new ArrayList<>();


    public static void fillDiscountList(){
        List<String> discount;
        try {
            discount = Files.readAllLines(Paths.get(getZnizki()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] line;

        for(String o : discount) {

            line = (o.split(","));

            discountList.put(Kind.valueOf(line[0]),parseInt(line[1]));
        }
    }

    public static void fillPreferenceList(){

        List<String> preference; 
        try {
            preference = Files.readAllLines(Paths.get(getPreferencje()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] line;
        String[] line2;

        for(String o : preference) {
            line = (o.split(","));
            line2 = line[2].split(":");


        Preference preference1 = new Preference(new Ski(parseInt(line2[0]),line2[1]),
                    new Person(parseInt(line[0]), Kind.valueOf(line[1])));
        preferenceList.add(preference1);

        }
    }

    public static void fillOwnedSkiesList(){
        List<String> ownedSkies;
        try {
            ownedSkies = Files.readAllLines(Paths.get(getWykaz()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] line;
        String[] line2;

        for(String o : ownedSkies) {
            line = (o.split(","));
            line2 = line[1].split(":");

            for(int i = 0; i < parseInt(line[0]); i++){
                skiList.add(new Ski(parseInt(line2[1]), line2[0]));
            }
        }
    }

    public static void shufflePreferenceList(List<Preference> preferenceList) {
        Collections.shuffle(preferenceList);
        ListInitialization.preferenceList = preferenceList;
    }

    public static void shuffleSkiList(List<Ski> skiList) {
        Collections.shuffle(skiList);
        ListInitialization.skiList = skiList;
    }

    public static List<Ski> getSkiList() {
        return skiList;
    }
    public static List<Preference> getPreferenceList() {
        return preferenceList;
    }

    public static Map<Kind, Integer> getDiscountList() {
        return discountList;
    }
}
