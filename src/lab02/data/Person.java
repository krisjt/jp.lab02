package lab02.data;

public class Person {
    private int id;
    private Kind kind;

    public Person(int id, Kind kind) {
        this.id = id;
        this.kind = kind;
    }

    public int getId() {
        return id;
    }
    public Kind getKind() {
        return kind;
    }


}
