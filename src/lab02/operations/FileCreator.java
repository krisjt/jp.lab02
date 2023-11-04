package lab02.operations;

import lab02.data.Kind;
import lab02.data.Person;
import lab02.data.Ski;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

import static UI.Reader.*;
import static lab02.data.Kind.*;

public class FileCreator {

    public static void discountCreation(){
        File file = new File(getZnizki());
        PrintWriter print;
        try {
            print = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        print.println("C,50");
        print.println("J,20");
        print.println("A,0");

        print.close();

    }
    public static void preferenceCreation() {
        File file = new File(getPreferencje());

        PrintWriter in;
        try {
            in = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0; i < getPplNum(); i++){
            Random generator = new Random();

            int kind = generator.nextInt(3);
            Kind b = switch (kind) {
                case 0 -> C;
                case 1 -> J;
                case 2 -> A;
                default -> null;
            };

            String skiType = null;
            int skiTypeGenerated = generator.nextInt(3);
            switch (skiTypeGenerated) {
                case 0 -> skiType = "carving";
                case 1 -> skiType = "slalom";
                case 2 -> skiType = "race";
            }

            int length = generator.nextInt(30)+150;

            Ski ski = new Ski(length, skiType);
            Person person = new Person(i+1, b);
            in.println(person.getId() + "," + person.getKind() + "," + ski.getLength() + ":" + ski.getType());
        }
        in.close();
    }
    public static void ownedSkiesCreation(){
        File file = new File(getWykaz());
        PrintWriter print;
        Random random = new Random();

        try {
            print = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int quantity;
        int length;
        for(int i = 0; i < getSkiNum(); i++){

            quantity = random.nextInt(getPplNum())+1;
            length = random.nextInt(30)+150;

            String skiType = null;
            int skiTypeGenerated = random.nextInt(3);
            switch (skiTypeGenerated) {
                case 0 -> skiType = "carving";
                case 1 -> skiType = "slalom";
                case 2 -> skiType = "race";
            }
            print.println(quantity + "," + skiType + ":" + length);
        }
        print.close();
    }
}
