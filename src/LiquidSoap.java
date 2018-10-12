import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiquidSoap {
    private String brand, intendedUse;
    private int volume;
    private Image image;

    public LiquidSoap(String brand, String intendedUse, int volume, Image image) {
        setBrand(brand);
        setIntendedUse(intendedUse);
        setVolume(volume);
        setImage(image);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (!brand.isEmpty())
            this.brand = brand;
        else
            throw new IllegalArgumentException("brand cannot be empty");
    }

    public String getIntendedUse() {
        return intendedUse;
    }

    public void setIntendedUse(String intendedUse) {
        List<String> validUses = Arrays.asList("Hand","Floor","Dish");

        if (validUses.contains(intendedUse))
            this.intendedUse = intendedUse;
        else
            throw new IllegalArgumentException("Intended use must be Hand, Floor or Dish");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume > 0 && volume <= 10000)
            this.volume = volume;
        else
            throw new IllegalArgumentException("volume must be 0-10000");
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return String.format("%-10s (%d ml)", brand, volume);
    }
}


