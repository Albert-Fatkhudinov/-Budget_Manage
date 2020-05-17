package edu.javaproject.budget.save;

import edu.javaproject.budget.domain.Balance;
import edu.javaproject.budget.domain.Purchase;
import edu.javaproject.budget.purchases.Purchases;
import edu.javaproject.budget.purchases.TypePurchase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SaveObjects {

    public SaveObjects() throws IOException {
    }

    public void save(String nameFile) throws IOException {
        File file = new File(nameFile);
        Map<Purchase, TypePurchase> map = Purchases.newInstance().getMap();

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
            bf.write(Balance.newInstance().getBalance().toString() + "\t");
            map.forEach((k, v) -> {
                try {
                    bf.write(v.toString() + "\t");
                    bf.write(k.getName() + "\t" + k.getValue() + "\t");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            });
            bf.flush();
        }
    }
}
