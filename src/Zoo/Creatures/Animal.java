package Zoo.Creatures;

abstract public class Animal {
    private final String name;
    private final String type;
    private final String habitat;
    private String livingSpace;
    private int age;
    private final boolean gender;
    private float weight;
//    TODO: можно добавить логику детей и родителей
    public Animal(String name, String type, String habitat, String livingSpace, int age, boolean gender, float weight) {
        this.name = name;
        this.type = type;
        this.habitat = habitat;
        this.livingSpace = livingSpace;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getLivingSpace() {
        return livingSpace;
    }

    public int getAge() {
        return age;
    }

    public boolean getGender() {
        return gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setLivingSpace(String livingSpace) {
        this.livingSpace = livingSpace;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String pat(Animal animal) {
        return "Животное радо :)";
    }
    public String feed(Animal animal) {
        return animal.getName() + " теперь сыт(а) :)";
    }
    public String photo() {
        return "Фото сделано :)";
    }
    public abstract String takeCare();
}
