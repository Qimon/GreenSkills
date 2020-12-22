package fr.ssml.template.core;

public class HighTechItem {

    // Attributes
    private String nam;
    private String mnemonic;
    private double price;

    public HighTechItem(String nam, String mnemonic, double price) {
        this.nam = nam;
        this.mnemonic = mnemonic;
        this.price = price;
    }

    public String getNam() {
        return nam;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
