package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDish(dishType, dishName);
        // добавьте новое блюдо
        dc.printMenu();    // тесты
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");

        String nextItem = scanner.nextLine();
        if (nextItem.isEmpty()) {
            System.out.println("Вы ввели пустой тип. Попробуйте снова в следующий раз.\n");
            return;
        }
        ArrayList<String> dishTypes = new ArrayList<>();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (!dc.getMenuTypeList().contains(nextItem)) {
                System.out.println("Вы вели несуществующий тип. Попробуйте снова.");
                nextItem = scanner.nextLine();
                continue;
            }
            dishTypes.add(nextItem);
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        dc.makeCombo(numberOfCombos, dishTypes);

        for (int i = 0; i < dc.getCombos().size(); i++) {
            System.out.println("Комбо " + (i + 1) + '\n' + dc.getCombos().get(i));
        }
        dc.clearCombos();
    }
}
