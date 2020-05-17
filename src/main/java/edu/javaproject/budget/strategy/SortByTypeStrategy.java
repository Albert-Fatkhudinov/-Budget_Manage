package edu.javaproject.budget.strategy;

import edu.javaproject.budget.purchases.Purchases;
import edu.javaproject.budget.purchases.TypePurchase;
import edu.javaproject.budget.util.Util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SortByTypeStrategy implements AnalyzeStrategy {

    Map<TypePurchase, BigDecimal> map = new HashMap<>();

    @Override
    public void sort() {
        if (map.isEmpty()) {
            System.out.println("Purchase list is empty");
        } else {
            Purchases purchases = Purchases.newInstance();
            System.out.println("Types:");
            map.put(TypePurchase.FOOD, purchases.sumByType(TypePurchase.FOOD));
            map.put(TypePurchase.CLOTHES, purchases.sumByType(TypePurchase.CLOTHES));
            map.put(TypePurchase.ENTERTAINMENT, purchases.sumByType(TypePurchase.ENTERTAINMENT));
            map.put(TypePurchase.OTHER, purchases.sumByType(TypePurchase.OTHER));

            map.entrySet().stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                    .forEach(k -> System.out.println(k.getKey().name() + " - $" + k.getValue()));

            System.out.println("Total sum: $" + purchases.totalSum());
        }
        Util.indent();
    }
}
