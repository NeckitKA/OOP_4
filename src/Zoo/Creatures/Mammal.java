package Zoo.Creatures;

public class Mammal extends Animal {
    private final String hairType;
    private final boolean milkProduction;
    private final float bodyTemperature;

    public Mammal(String name, String type, String habitat, String livingSpace, int age,
                  boolean gender, float weight, String hairType, boolean milkProduction, float bodyTemperature) {
        super(name, type, habitat, livingSpace, age, gender, weight);
        this.hairType = hairType;
        this.milkProduction = milkProduction;
        this.bodyTemperature = bodyTemperature;
    }

    public String getHairType() {
        return hairType;
    }

    public boolean getMilkProduction() {
        return milkProduction;
    }

    public float getBodyTemperature() {
        return bodyTemperature;
    }

    @Override
    public String takeCare() {
        return "Шерсть подстрижена";
    }
}
