package Zoo.Creatures;

public class Artiodactyl extends Mammal {
    private float hoofLength;
    private float hoofWidth;


    public Artiodactyl(String name, String type, String habitat, String livingSpace, int age, boolean gender,
                       float weight, String hairType, boolean milkProduction, float bodyTemperature,
                       float hoofLength, float hoofWidth) {
        super(name, type, habitat, livingSpace, age, gender, weight, hairType, milkProduction, bodyTemperature);
        this.hoofWidth = hoofWidth;
        this.hoofLength = hoofLength;
    }


    public float getHoofLength() {
        return hoofLength;
    }

    public float getHoofWidth() {
        return hoofWidth;
    }

    public void setHoofLength(float hoofLength) {
        this.hoofLength = hoofLength;
    }

    public void setHoofWidth(float hoofWidth) {
        this.hoofWidth = hoofWidth;
    }
}
