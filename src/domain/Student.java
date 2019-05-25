package domain;

public class Student {
    String naam , vak ,datum;
    String uur;

    public Student(String naam, String vak, String datum, String uur) {
        this.naam = naam;
        this.vak = vak;
        this.datum = datum;
        this.uur = uur;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVak() {
        return vak;
    }

    public void setVak(String vak) {
        this.vak = vak;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getUur() {
        return uur;
    }

    public void setUur(String uur) {
        this.uur = uur;
    }
}
