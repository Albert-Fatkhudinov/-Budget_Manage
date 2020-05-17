package edu.javaproject.budget.purchases;

import edu.javaproject.budget.util.Util;
import edu.javaproject.budget.domain.Balance;
import edu.javaproject.budget.domain.Purchase;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Purchases {

    private Map<Purchase, TypePurchase> map = new HashMap<>();
    private static Purchases instance;
    private Balance balance = Balance.newInstance();

    public static final String MENU_ADD_PURCHASE = "Choose the type of purchase\n" +
            "1) Food\n" +
            "2) Clothes\n" +
            "3) Entertainment\n" +
            "4) Other\n" +
            "5) Back\n";

    public static final String MENU_SHOW_PURCHASE = "Choose the type of purchase\n" +
            "1) Food\n" +
            "2) Clothes\n" +
            "3) Entertainment\n" +
            "4) Other\n" +
            "5) All\n" +
            "6) Back";

    private Purchases() {

    }

    public static Purchases newInstance() {
        if (instance == null) {
            instance = new Purchases();
        }
        return instance;
    }

    public void showList() throws IOException {

        if (map.isEmpty()) {
            System.out.println("Purchase list is empty");
        } else {
            int numberMenu;
            while (true) {
                System.out.println(MENU_SHOW_PURCHASE);
                numberMenu = Util.readInt();
                if (numberMenu == 6) {
                    break;
                } else if (numberMenu == 1) {
                    Util.indent();
                    System.out.println("Food:");
                    category(TypePurchase.FOOD);

                } else if (numberMenu == 2) {
                    Util.indent();
                    System.out.println("Clothes:");
                    category(TypePurchase.CLOTHES);

                } else if (numberMenu == 3) {
                    Util.indent();
                    System.out.println("Entertainment:");
                    category(TypePurchase.ENTERTAINMENT);

                } else if (numberMenu == 4) {
                    Util.indent();
                    System.out.println("Other:");
                    category(TypePurchase.OTHER);
                } else if (numberMenu == 5) {
                    Util.indent();
                    System.out.println("All:");
                    map.forEach((k, v) -> System.out.println(k.toString()));
                    System.out.println("Total sum: " + totalSum());
                    Util.indent();
                }
            }
        }
        Util.indent();
    }

    private void category(TypePurchase type) {
        showCategory(type);
        System.out.println("Total sum: $" + sumByType(type));
        Util.indent();
    }

    private void showCategory(TypePurchase type) {
        map.entrySet().stream()
                .filter(v -> v.getValue() == type)
                .forEach(k -> System.out.println(k.getKey().toString()));
    }

    public BigDecimal sumByType(TypePurchase type) {
        return map.entrySet().stream()
                .filter(v -> v.getValue() == type)
                .map(v -> v.getKey().getValue())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal totalSum() {
        return map.keySet().stream()
                .map(Purchase::getValue)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void addCategory() throws IOException {

        int numberMenu;

        while (true) {
            System.out.println(MENU_ADD_PURCHASE);
            numberMenu = Util.readInt();
            if (numberMenu == 5) {
                break;
            } else if (numberMenu == 1) {
                addPurchase(TypePurchase.FOOD);
            } else if (numberMenu == 2) {
                addPurchase(TypePurchase.CLOTHES);
            } else if (numberMenu == 3) {
                addPurchase(TypePurchase.ENTERTAINMENT);
            } else if (numberMenu == 4) {
                addPurchase(TypePurchase.OTHER);
            }
        }
    }

    private void addPurchase(TypePurchase type) throws IOException {

        System.out.println("Enter purchase name:");
        String namePurchase = Util.readString();

        System.out.println("Enter its price:");
        BigDecimal value = new BigDecimal(Util.readString()).setScale(2);

        map.put(new Purchase(namePurchase, value), type);
        Balance.newInstance().setBalance(balance.getBalance().subtract(value));
        System.out.println("Purchase was added!");
        Util.indent();
    }

    public Map<Purchase, TypePurchase> getMap() {
        return map;
    }

    public void setMap(Map<Purchase, TypePurchase> map) {
        this.map = map;
    }
}
