package lab02.operations;

public class Result {
    private int id;
    private String preferredType;
    private int preferredLength;
    private String skiType;
    private int skiLength;

    private double score;

    public Result(int id, String preferredType, int preferredLength, String skiType, int skiLength, double score) {
        this.id = id;
        this.preferredType = preferredType;
        this.preferredLength = preferredLength;
        this.skiType = skiType;
        this.skiLength = skiLength;
        this.score = score;
    }


    public int getId() {
        return id;
    }

    public String getSkiType() {
        return skiType;
    }

    public int getSkiLength() {
        return skiLength;
    }

    public String getPreferredType() {
        return preferredType;
    }

    public int getPreferredLength() {
        return preferredLength;
    }

    public double getScore() {
        return score;
    }
}
