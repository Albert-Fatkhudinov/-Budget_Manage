package edu.javaproject.budget.strategy;


import edu.javaproject.budget.domain.Purchase;
import edu.javaproject.budget.purchases.Purchases;
import edu.javaproject.budget.purchases.TypePurchase;
import edu.javaproject.budget.util.Util;

import java.io.IOException;
import java.util.Map;

public class CertainStrategy implements AnalyzeStrategy {

    Map<Purchase, TypePurchase> map = Purchases.newInstance().getMap();

    public static final String SORT_MENU = "Choose the type of purchase\n" +
            "1) Food\n" +
            "2) Clothes\n" +
            "3) Entertainment\n" +
            "4) Other";


    @Override
    public void sort() throws IOException {
        if (Purchases.newInstance().getMap().isEmpty()) {
            System.out.println("Purchase list is empty");
            Util.indent();
        } else {
            System.out.println(SORT_MENU);
            int numberMenu = Util.readInt();
            Util.indent();
            if (numberMenu == 1) {
                sortByType("FOOD", TypePurchase.FOOD);
            } else if (numberMenu == 2) {
                sortByType("CLOTHES", TypePurchase.CLOTHES);
            } else if (numberMenu == 3) {
                sortByType("ENTERTAINMENT", TypePurchase.ENTERTAINMENT);
            } else if (numberMenu == 4) {
                sortByType("OTHER", TypePurchase.OTHER);
            }
        }
    }

    private void sortByType(String type, TypePurchase typePurchase) {
        map.entrySet().stream().filter(k -> k.getValue().name().equals(type))
                .sorted(((o1, o2) -> o2.getKey().getValue().compareTo(o1.getKey().getValue())))
                .forEach(k -> System.out.println(k.getKey().toString()));

        System.out.println("Total sum: $" + Purchases.newInstance().sumByType(typePurchase));
        Util.indent();
    }
}
