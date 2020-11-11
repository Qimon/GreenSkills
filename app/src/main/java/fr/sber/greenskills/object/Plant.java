package fr.sber.greenskills.object;

public class Plant {

    private String name;
    private String type;
    private String origin;
    private String exposition;
    private String watering;

    public Plant(String name, String type, String origin, String exposition, String watering) {
        this.name = name;
        this.type = type;
        this.origin = origin;
        this.exposition = exposition;
        this.watering = watering;
    }

    public Plant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getExposition() {
        return exposition;
    }

    public void setExposition(String exposition) {
        this.exposition = exposition;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                ", exposition='" + exposition + '\'' +
                ", watering='" + watering + '\'' +
                '}';
    }
}
