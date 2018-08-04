package domain;

public class Uitgaven {
    private String datum;
    private String naam;
    private String uitgaven = "0";

    public Uitgaven(String datum, String uitgaven , String naam) {
        this.datum = datum;
        this.naam = naam;
        this.uitgaven = uitgaven;
    }

    public String getDatum() {
        return datum;
    }

    public String getUitgaven() {
        return uitgaven;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setUitgaven(String uitgaven) {
        this.uitgaven = uitgaven;
    }
}
