package UI;

import java.util.Scanner;

public record Reader() {

    private static int pplNum;
    private static int skiNum;
    private static String wykaz;
    private static String znizki;
    private static String preferencje;


    public static int getPplNum() {
        return pplNum;
    }

    public static String getWykaz() {
        return wykaz;
    }

    public static String getZnizki() {
        return znizki;
    }

    public static String getPreferencje() {
        return preferencje;
    }

    public static void setWykaz(String wykaz) {
        Reader.wykaz = wykaz;
    }

    public static void setZnizki(String znizki) {
        Reader.znizki = znizki;
    }

    public static void setPreferencje(String preferencje) {
        Reader.preferencje = preferencje;
    }

    public static void setPplNum(int pplNum) {
        Reader.pplNum = pplNum;
    }

    public static void setSkiNum(int skiNum) {
        Reader.skiNum = skiNum;
    }

    public static int getSkiNum() {
        return skiNum;
    }
}
