package Zoo;

import Zoo.Creatures.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Zoo {

    protected ArrayList<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public String addAnimal(Animal animal) {
        for (Animal existingAnimal : animals) {
            if (existingAnimal.getName().equalsIgnoreCase(animal.getName())) {
                return "Животное с именем " + animal.getName() + " уже существует.\n";
            }
        }
        animals.add(animal);
        return animal.getName() + " добавлен(а).\n";
    }

    public String removeAnimal(String name) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            animals.remove(animal);
            return animal.getName() + " удален(а).";
        } else {
            return "Животное не найдено.";
        }
    }

    public String updateAnimalInfo(String name, int fieldNumber, Object newValue) {
        Animal animal = findAnimalByName(name);
        if (animal == null) {
            return "Животное не найдено.";
        }

        switch (fieldNumber) {
            case 1 -> {
                if (newValue instanceof String) {
                    animal.setLivingSpace((String) newValue);
                    return "Место проживания обновлено.";
                }
                return "Некорректное значение для места проживания.";
            }
            case 2 -> {
                if (newValue instanceof Integer) {
                    animal.setAge((Integer) newValue);
                    return "Возраст обновлен.";
                }
                return "Некорректное значение для возраста.";
            }
            case 3 -> {
                if (newValue instanceof Float) {
                    animal.setWeight((Float) newValue);
                    return "Вес обновлен.";
                }
                return "Некорректное значение для веса.";
            }
            case 4 -> {
                if (animal instanceof Bird bird && newValue instanceof Float) {
                    bird.setWingSpan((Float) newValue);
                    return "Размах крыльев обновлен.";
                }
                return "Поле недоступно или некорректное значение.";
            }
            case 5 -> {
                if (animal instanceof Artiodactyl artiodactyl && newValue instanceof Float) {
                    artiodactyl.setHoofLength((Float) newValue);
                    return "Длина копыта обновлена.";
                }
                return "Поле недоступно или некорректное значение.";
            }
            case 6 -> {
                if (animal instanceof Artiodactyl artiodactyl && newValue instanceof Float) {
                    artiodactyl.setHoofWidth((Float) newValue);
                    return "Ширина копыта обновлена.";
                }
                return "Поле недоступно или некорректное значение.";
            }
            default -> {
                return "Неверный номер поля.";
            }
        }
    }

    public String showAllAnimals(int type) {
        if (animals.isEmpty()) {
            return "Зоопарк пуст.\n";
        } else {
            StringBuilder result = new StringBuilder();
            for (Animal animal : animals) {
                boolean shouldInclude = switch (type) {
                    case 1 -> true;
                    case 2 -> animal instanceof Bird;
                    case 3 -> animal instanceof Mammal;
                    case 4 -> animal instanceof Artiodactyl;
                    default -> false;
                };

                if (shouldInclude) {
                    Animal foundAnimal = findAnimalByName(animal.getName());
                    if (foundAnimal != null) {
                        result.append(findAnimalInfo(foundAnimal)).append("\n");
                    }
                }
            }
            return result.length() > 0 ? result.toString() :
                    "Животные не найдены или неправильный выбор.";
        }
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public String findAnimalInfo(Animal animal) {
        if (animal == null) {
            return "Животное не найдено.\n";
        }
        StringBuilder result = new StringBuilder();
        Class<?> clazz = animal.getClass();
        while (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                    try {
                        Object value = method.invoke(animal);
                        String fieldName = method.getName().substring(3);
                        result.append(fieldName).append(": ").append(value).append("\n");
                    } catch (Exception e) {
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
        return result.toString()
                .replace("Class: class Zoo.Creatures.Bird", "Class: Bird")
                .replace("Class: class Zoo.Creatures.Mammal", "Class: Mammal")
                .replace("Class: class Zoo.Creatures.Artiodactyl", "Class: Artiodactyl");
    }

    public String interactWithAnimal(int choice, Animal animal) {
        switch (choice) {
            case 1:
                return animal.pat();
            case 2:
                return animal.feed();
            case 3:
                return Animal.photo();
            case 4:
                return animal.takeCare();
            default:
                return "Неверный выбор. Попробуйте снова.";
        }
    }
}