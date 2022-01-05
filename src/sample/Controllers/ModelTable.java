package sample.Controllers;

public class ModelTable {
    private String name;
    private String surname;
    private String faculty;
    private String number;
    private String disease;
    private String time;

    public ModelTable() {
    }

    public ModelTable(String name, String surname, String faculty, String number, String disease, String time) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.number = number;
        this.disease = disease;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
