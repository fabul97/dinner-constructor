package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private Random random;
    private HashMap<String, ArrayList<String>> menu;
    private HashMap<String, ArrayList<String>> combos;


    DinnerConstructor() {
        random = new Random();
        menu = new HashMap<>();
        combos = new HashMap<>();
    }

    void addDish(String dishType, String dishName) {
        if (dishType.isEmpty() || dishName.isEmpty()) {
            System.out.println("Пустой ввод. Попробуйте снова.");
        } else {
            if (checkType(dishType)) {
                menu.get(dishType).add(dishName);
            } else {
                ArrayList<String> dish = new ArrayList<>();
                dish.add(dishName);
                menu.put(dishType, dish);
            }
        }
    }

    HashMap<String, ArrayList<String>> makeCombo(int comboQuantity, String drink, String firstDish, String secondDish) {
        if (!(checkType(drink) && checkType(firstDish) && checkType(secondDish))) {

        }

        return combos;
    }



    boolean checkType(String dishType) {
        return menu.containsKey(dishType);
    }

    void printMenu() {
        System.out.println(menu);
    }
}
