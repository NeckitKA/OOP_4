package Menu;
import Zoo.Zoo;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    // TODO: загружая данные из файла для пункта 3
    // TODO: добавить выгрузку в файл
    // TODO: осталось в основном доделать работу с пользователем
    private static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Показать животных");
        System.out.println("2. Показать животное по имени");
        System.out.println("3. Добавить животное");
        System.out.println("4. Изменить информацию о животном");
        System.out.println("5. Удалить животное из списка");
        System.out.println("6. Другие действия с животным");
        System.out.println("7. Выход");
    }
    private static int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка ввода! Пожалуйста, введите целое число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void handleMainChoice() {
        while (true) {
            showMenu();
            int choice = getValidIntegerInput();
            scanner.nextLine();

            switch (choice) {
                case 1 -> ;
                case 2 -> ;
                case 3 -> ;
                case 4 -> ;
                case 5 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
