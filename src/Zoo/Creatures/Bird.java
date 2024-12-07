package Zoo.Creatures;

public class Bird extends Animal {

    private final boolean canFly;
    private float wingSpan;
    private final boolean eggLaying;
    private final String beakType;

    public Bird(String name, String type, String habitat, String livingSpace, int age, boolean gender,
                float weight, boolean canFly, float wingSpan, boolean eggLaying, String beakType) {
        super(name, type, habitat, livingSpace, age, gender, weight);
        this.canFly = canFly;
        this.wingSpan = wingSpan;
        this.eggLaying = eggLaying;
        this.beakType = beakType;
    }

    public boolean getCanFly() {
        return canFly;
    }

    public float getWingSpan() {
        return wingSpan;
    }

    public boolean getEggLaying() {
        return eggLaying;
    }

    public String getBeakType() {
        return beakType;
    }

    public void setWingSpan(float wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public String takeCare() {
        return "Перья почищены";
    }
}
