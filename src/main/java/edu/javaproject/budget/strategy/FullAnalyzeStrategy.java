package edu.javaproject.budget.strategy;

import edu.javaproject.budget.domain.Purchase;
import edu.javaproject.budget.purchases.Purchases;
import edu.javaproject.budget.purchases.TypePurchase;
import edu.javaproject.budget.util.Util;

import java.util.Map;


public class FullAnalyzeStrategy implements AnalyzeStrategy {

    Map<Purchase, TypePurchase> map = Purchases.newInstance().getMap();

    @Override
    public void sort() {

        if (map.isEmpty()) {
            System.out.println("Purchase list is empty");
        } else {
            map.entrySet().stream()
                    .sorted((o1, o2) -> o2.getKey().getValue().compareTo(o1.getKey().getValue()))
                    .forEach(k -> System.out.println(k.getKey().toString()));
        }
        Util.indent();
    }
}
