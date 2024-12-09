package Zoo;

import Zoo.Creatures.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Zoo zoo = new Zoo();

    private static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Показать животных");
        System.out.println("2. Добавить животное");
        System.out.println("3. Изменить информацию о животном");
        System.out.println("4. Удалить животное из списка");
        System.out.println("5. Другие действия с животным");
        System.out.println("6. Выход");
    }

    private static int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка ввода! Пожалуйста, введите целое число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static float getValidFloatInput() {
        while (!scanner.hasNextFloat()) {
            System.out.println("Ошибка ввода! Пожалуйста, введите вещественное число.");
            scanner.next();
        }
        return scanner.nextFloat();
    }

    private static boolean getValidBooleanInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();

                if (input == 0 || input == 1) {
                    return input == 1;
                } else {
                    System.out.println("Ошибка ввода! Пожалуйста, введите 1 или 0.");
                }
            } else {
                System.out.println("Ошибка ввода! Пожалуйста, введите 1 или 0.");
                scanner.next();
            }
        }
    }

    // TODO: выгрузка конфига в файл
    private static void showAnimals() {
        while (true) {
            System.out.println("1. Показать всех животных");
            System.out.println("2. Показать животных по типу");
            System.out.println("3. Показать животное по имени");
            System.out.println("4. Выгрузить конфигурацию в файл");
            System.out.println("5. Возврат в главное меню.");
            int choice = getValidIntegerInput();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println(zoo.showAllAnimals(1));
                }
                case 2 -> {
                    boolean menu = true;
                    while (menu) {
                        System.out.println("1. Показать птиц");
                        System.out.println("2. Показать млекопитающих");
                        System.out.println("3. Показать парнокопытных");
                        System.out.println("4. Вернуться");
                        int choiceType = getValidIntegerInput();
                        scanner.nextLine();
                        switch (choiceType) {
                            case 1 -> System.out.println(zoo.showAllAnimals(2));
                            case 2 -> System.out.println(zoo.showAllAnimals(3));
                            case 3 -> System.out.println(zoo.showAllAnimals(4));
                            case 4 -> {
                                menu = false;
                            }
                            default -> System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                    }
                }
                case 3 -> {
                    boolean menu = true;
                    while (menu) {
                        System.out.println("Оставьте строку пустой для выхода из этого меню");
                        System.out.println("Введите имя животного: ");
                        String sentence = scanner.nextLine();
                        if (sentence.isEmpty()) {
                            System.out.println("Поле оставлено пустым. Выход из меню.");
                            menu = false;
                        } else {
                            System.out.println(zoo.findAnimalInfo(zoo.findAnimalByName(sentence)));
                            menu = false;
                        }
                    }
                    ;
                }
                case 4 -> {
                    saveConfig();
                    return;
                }
                case 5 -> {
                    System.out.println("Возврат в главное меню.");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

    }

    // TODO: загрузка конфига из файла
    private static void addAnimal() {
        while (true) {
            System.out.println("1. Добавить животное");
            System.out.println("2. Загрузить конфигурацию из файла");
            System.out.println("3. Возврат в главное меню.");
            int choice = getValidIntegerInput();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    boolean menu = true;
                    while (menu) {
                        System.out.println("Выберите вид животного:");
                        System.out.println("1. Птица");
                        System.out.println("2. Млекопитающее");
                        System.out.println("3. Парнокопытное");
                        System.out.println("4. Вернуться");
                        int choiceType = getValidIntegerInput();
                        scanner.nextLine();
                        String name = "", type = "", habitat = "", livingSpace = "";
                        int age = 0;
                        boolean gender = true;
                        float weight = 0;
                        if (choiceType == 1 || choiceType == 2 || choiceType == 3) {
                            boolean pass = false;
                            while (name.isEmpty()) {
                                System.out.print("Введите имя: ");
                                name = scanner.nextLine();
                                if (zoo.findAnimalByName(name) != null) {
                                    System.out.print("Имя занято\n");
                                    pass = true;
                                }
                            }
                            if (pass) {
                                continue;
                            }
                            while (type.isEmpty()) {
                                System.out.print("Введите тип: ");
                                type = scanner.nextLine();
                            }
                            while (habitat.isEmpty()) {
                                System.out.print("Введите место обитания: ");
                                habitat = scanner.nextLine();
                            }
                            while (livingSpace.isEmpty()) {
                                System.out.print("Введите место проживания: ");
                                livingSpace = scanner.nextLine();
                            }
                            System.out.print("Введите возраст: ");
                            age = getValidIntegerInput();
                            System.out.print("Введите пол (1 - мужской, 0 - женский или ): ");
                            gender = getValidBooleanInput();
                            System.out.print("Введите вес: ");
                            weight = getValidFloatInput();
                        }
                        switch (choiceType) {
                            case 1 -> {
                                System.out.print("Может ли летать? (1/0): ");
                                scanner.nextLine();
                                boolean canFly = getValidBooleanInput();
                                System.out.print("Размах крыльев: ");
                                float wingSpan = getValidFloatInput();
                                System.out.print("Откладывает ли яйца? (1/0): ");
                                boolean eggLaying = getValidBooleanInput();
                                scanner.nextLine();
                                String beakType = "";
                                while (beakType.isEmpty()) {
                                    System.out.print("Тип клюва: ");
                                    beakType = scanner.nextLine();
                                }
                                Bird bird = new Bird(name, type, habitat, livingSpace, age, gender, weight, canFly, wingSpan, eggLaying, beakType);
                                System.out.println(zoo.addAnimal(bird));
                            }
                            case 2 -> {
                                String hairType = "";
                                scanner.nextLine();
                                while (hairType.isEmpty()) {
                                    System.out.print("Тип шерсти: ");
                                    hairType = scanner.nextLine();
                                }
                                System.out.print("Производит ли молоко? (1/0): ");
                                boolean milkProduction = getValidBooleanInput();
                                System.out.print("Температура тела: ");
                                float bodyTemperature = getValidFloatInput();
                                Mammal mammal = new Mammal(name, type, habitat, livingSpace, age, gender, weight, hairType, milkProduction, bodyTemperature);
                                System.out.println(zoo.addAnimal(mammal));
                            }
                            case 3 -> {
                                String hairType = "";
                                scanner.nextLine();
                                while (hairType.isEmpty()) {
                                    System.out.print("Тип шерсти: ");
                                    hairType = scanner.nextLine();
                                }
                                System.out.print("Производит ли молоко? (1/0): ");
                                boolean milkProduction = getValidBooleanInput();
                                System.out.print("Температура тела: ");
                                float bodyTemperature = getValidFloatInput();
                                System.out.print("Длина копыта: ");
                                float hoofLength = getValidFloatInput();
                                System.out.print("Ширина копыта: ");
                                float hoofWidth = getValidFloatInput();
                                Artiodactyl arti = new Artiodactyl(name, type, habitat, livingSpace, age, gender, weight, hairType, milkProduction, bodyTemperature, hoofLength, hoofWidth);
                                System.out.println(zoo.addAnimal(arti));
                            }
                            case 4 -> {
                                menu = false;
                            }
                            default -> System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                    }
                }
                case 2 -> readConfig();
                case 3 -> {
                    System.out.println("Возврат в главное меню.");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void updateAnimalInfo() {
        while (true) {
            System.out.println("Оставьте строку пустой для выхода из этого меню");
            System.out.println("Введите имя животного: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Поле оставлено пустым. Выход из меню.");
                break;
            } else {
                Animal animal = zoo.findAnimalByName(name);
                if (animal!=null) {
                    while (true) {
                        System.out.println("1. Изменить место проживания");
                        System.out.println("2. Изменить возраст");
                        System.out.println("3. Изменить вес");

                        if (animal instanceof Bird) {
                            System.out.println("4. Изменить размах крыльев");
                            System.out.println("5. Возврат в главное меню.");

                        } else if (animal instanceof Artiodactyl) {
                            System.out.println("4. Изменить длину копыта");
                            System.out.println("5. Изменить ширину копыта");
                            System.out.println("6. Возврат в главное меню.");
                        } else if (animal instanceof Mammal && !(animal instanceof Artiodactyl)) {
                            System.out.println("Изменять нечего.");
                            System.out.println("Возврат в главное меню.");
                            return;
                        }
                        int choice = getValidIntegerInput();
                        scanner.nextLine();
                        switch (choice) {
                            case 1 -> {
                                String newValue = "";
                                while (newValue.isEmpty()) {
                                    System.out.print("Новое значение: ");
                                    newValue = scanner.nextLine();
                                }
                                System.out.println(zoo.updateAnimalInfo(name,1,newValue));
                            }
                            case 2 -> {
                                System.out.print("Новое значение: ");
                                int newValue = getValidIntegerInput();
                                System.out.println(zoo.updateAnimalInfo(name,2,newValue));
                            }
                            case 3 -> {
                                System.out.print("Новое значение: ");
                                float newValue = getValidFloatInput();
                                System.out.println(zoo.updateAnimalInfo(name,3,newValue));
                            }
                            case 4 -> {
                                if (animal instanceof Bird) {
                                    System.out.print("Новое значение: ");
                                    float newValue = getValidFloatInput();
                                    System.out.println(zoo.updateAnimalInfo(name,4,newValue));

                                } else if (animal instanceof Artiodactyl) {
                                    System.out.print("Новое значение: ");
                                    float newValue = getValidFloatInput();
                                    System.out.println(zoo.updateAnimalInfo(name,5,newValue));
                                }
                            }
                            case 5 -> {
                                if (animal instanceof Bird) {
                                    System.out.println("Возврат в главное меню.");
                                    return;
                                }
                                else if (animal instanceof Artiodactyl) {
                                    System.out.print("Новое значение: ");
                                    float newValue = getValidFloatInput();
                                    System.out.println(zoo.updateAnimalInfo(name,6,newValue));
                                }
                            }
                            case 6 -> {
                                if (animal instanceof Artiodactyl) {
                                    System.out.println("Возврат в главное меню.");
                                    return;
                                }
                                else {
                                    System.out.println("Неверный выбор. Попробуйте снова.");
                                }
                            }
                            default -> System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                    }
                }
                else {
                    System.out.println("Животное не найдено.");
                }
            }
        }
    }

    private static void removeAnimal() {
        System.out.println("Оставьте строку пустой для выхода из этого меню");
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Поле оставлено пустым. Выход из меню.");
        } else {
            System.out.println(zoo.removeAnimal(name));
        }
    }

    private static void interactWithAnimal() {
        System.out.println("Оставьте строку пустой для выхода из этого меню");
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Поле оставлено пустым. Выход из меню.");
        } else {
            Animal animal = zoo.findAnimalByName(name);
            if (animal!=null) {
                while (true) {
                    System.out.println("1. Погладить");
                    System.out.println("2. Покормить");
                    System.out.println("3. Сделать фото");
                    System.out.println("4. Позаботиться");
                    System.out.println("5. Возврат в главное меню.");
                    int choice = getValidIntegerInput();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 -> System.out.println(zoo.interactWithAnimal(1, animal));
                        case 2 -> System.out.println(zoo.interactWithAnimal(2, animal));
                        case 3 -> System.out.println(zoo.interactWithAnimal(3, animal));
                        case 4 -> System.out.println(zoo.interactWithAnimal(4, animal));
                        case 5 -> {
                            System.out.println("Возврат в главное меню.");
                            return;
                        }
                        default -> System.out.println("Неверный выбор. Попробуйте снова.");
                    }
                }
            } else {
                System.out.println("Животное не найдено.");
            }
        }
    }

    public static String handleMainChoice() {
        while (true) {
            showMenu();
            int choice = getValidIntegerInput();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAnimals();
                case 2 -> addAnimal();
                case 3 -> updateAnimalInfo();
                case 4 -> removeAnimal();
                case 5 -> interactWithAnimal();
                case 6 -> {
                    System.out.println("Выход из программы.");
                    return null;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void saveConfig() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("zoo_config.txt"))) {
            for (Animal animal : zoo.animals) {
                StringBuilder config = new StringBuilder();
                config.append("Class: ").append(animal.getClass().getSimpleName()).append("; ");
                Class<?> clazz = animal.getClass();

                while (clazz != null) {
                    for (Method method : clazz.getDeclaredMethods()) {
                        if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                            try {
                                String fieldName = method.getName().substring(3);
                                Object value = method.invoke(animal);
                                config.append(fieldName).append(": ").append(value).append("; ");
                            } catch (Exception ignored) {
                            }
                        }
                    }
                    clazz = clazz.getSuperclass();
                }

                if (config.charAt(config.length() - 2) == ';') {
                    config.setLength(config.length() - 2);
                }

                writer.write(config.toString());
                writer.newLine();
            }
            System.out.println("Конфигурация сохранена в файл zoo_config.txt");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении конфигурации: " + e.getMessage());
        }
    }
    private static void readConfig() {
        try (BufferedReader reader = new BufferedReader(new FileReader("zoo_config.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("; ");
                String className = parts[0].split(": ")[1];
                Map<String, String> fields = new HashMap<>();
                for (int i = 1; i < parts.length; i++) {
                    String[] keyValue = parts[i].split(": ");
                    fields.put(keyValue[0], keyValue[1]);
                }

                Animal animal = null;
                switch (className) {
                    case "Bird":
                        animal = new Bird(
                                fields.get("Name"),
                                fields.get("Type"),
                                fields.get("Habitat"),
                                fields.get("LivingSpace"),
                                Integer.parseInt(fields.get("Age")),
                                Boolean.parseBoolean(fields.get("Gender")),
                                Float.parseFloat(fields.get("Weight")),
                                Boolean.parseBoolean(fields.get("CanFly")),
                                Float.parseFloat(fields.get("WingSpan")),
                                Boolean.parseBoolean(fields.get("EggLaying")),
                                fields.get("BeakType")
                        );
                        break;
                    case "Mammal":
                        animal = new Mammal(
                                fields.get("Name"),
                                fields.get("Type"),
                                fields.get("Habitat"),
                                fields.get("LivingSpace"),
                                Integer.parseInt(fields.get("Age")),
                                Boolean.parseBoolean(fields.get("Gender")),
                                Float.parseFloat(fields.get("Weight")),
                                fields.get("HairType"),
                                Boolean.parseBoolean(fields.get("MilkProduction")),
                                Float.parseFloat(fields.get("BodyTemperature"))
                        );
                        break;
                    case "Artiodactyl":
                        animal = new Artiodactyl(
                                fields.get("Name"),
                                fields.get("Type"),
                                fields.get("Habitat"),
                                fields.get("LivingSpace"),
                                Integer.parseInt(fields.get("Age")),
                                Boolean.parseBoolean(fields.get("Gender")),
                                Float.parseFloat(fields.get("Weight")),
                                fields.get("HairType"),
                                Boolean.parseBoolean(fields.get("MilkProduction")),
                                Float.parseFloat(fields.get("BodyTemperature")),
                                Float.parseFloat(fields.get("HoofLength")),
                                Float.parseFloat(fields.get("HoofWidth"))
                        );
                        break;
                    default:
                        System.err.println("Неизвестный класс: " + className);
                }

                if (animal != null) {
                    zoo.addAnimal(animal);
                }
            }
            System.out.println("Конфигурация загружена из файла zoo_config.txt");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении конфигурации: " + e.getMessage());
        }
        catch (NullPointerException e) {
            System.err.println("Ошибка при чтении конфигурации: " + e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка при чтении конфигурации: " + e.getMessage());
        }
    }
}
