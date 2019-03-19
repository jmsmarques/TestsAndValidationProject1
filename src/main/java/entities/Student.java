package entities;

public class Student {
    private String name;
    private String address;
    private int warnings;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
        warnings = 0;
    }

    public void addWarning() {
        warnings++;
    }

    public void resetWarnings() {
        warnings = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}