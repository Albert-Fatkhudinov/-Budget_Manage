package edu.javaproject.budget.load;

import edu.javaproject.budget.domain.Balance;
import edu.javaproject.budget.domain.Purchase;
import edu.javaproject.budget.purchases.Purchases;
import edu.javaproject.budget.purchases.TypePurchase;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class LoadObject {


    public void load(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Map<Purchase, TypePurchase> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String[] strings = reader.readLine().split("\\t");
            Balance.newInstance().setBalance(new BigDecimal(strings[0]));

            for (int i = 1; i < strings.length; i += 3) {
                map.put(new Purchase(strings[i + 1], new BigDecimal(strings[i + 2])), typePurchase(strings[i]));
            }

            Purchases.newInstance().setMap(map);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private TypePurchase typePurchase(String string) {
        TypePurchase type = null;
        if (string.equals(TypePurchase.CLOTHES.name())) {
            type = TypePurchase.CLOTHES;
        } else if (string.equals(TypePurchase.ENTERTAINMENT.name())) {
            type = TypePurchase.ENTERTAINMENT;
        } else if (string.equals(TypePurchase.FOOD.name())) {
            type = TypePurchase.FOOD;
        } else if (string.equals(TypePurchase.OTHER.name())) {
            type = TypePurchase.OTHER;
        }
        return type;
    }
}
