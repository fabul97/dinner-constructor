package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private final Random random;
    private final HashMap<String, ArrayList<String>> menu;
    private final ArrayList<ArrayList<String>> combos;


    DinnerConstructor() {
        random = new Random();
        menu = new HashMap<>();
        combos = new ArrayList<>();
    }

    void addDish(String dishType, String dishName) {
        if (dishType.isEmpty() || dishName.isEmpty()) {
            System.out.println("Пустой ввод. Попробуйте снова.");
        } else {
            if (checkType(dishType)) {
                menu.get(dishType).add(dishName);
            } else {
                ArrayList<String> dishes = new ArrayList<>();
                dishes.add(dishName);
                menu.put(dishType, dishes);
            }
        }
    }

    void makeCombo(int comboQuantity, ArrayList<String> comboTypes) {
        for (int i = 0; i < comboQuantity; i++) {
            ArrayList<String> combo = new ArrayList<>(comboTypes.size() - 1);
            for (String type : comboTypes) {
                combo.add(menu.get(type).get(random.nextInt(menu.get(type).size() - 1)));
            }
            combos.add(combo);
        }
    }

    ArrayList<String> getMenuTypeList() {
        return new ArrayList<>(menu.keySet());
    }

    ArrayList<ArrayList<String>> getCombos() {
        return combos;
    }

    void clearCombos() {
        combos.clear();
    }

    boolean checkType(String dishType) {
        return menu.containsKey(dishType);
    }

    void printMenu() {
        System.out.println(menu);
    }
}
