package fr.sber.greenskills.object;

public class Flower extends Plant {

    private String season;

    public Flower(String name, String type, String origin, String exposition, String watering, String season) {
        super(name, type, origin, exposition, watering);
        this.season = season;
    }

    public Flower(String season) {
        this.season = season;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "season='" + season + '\'' +
                '}';
    }
}
