package edu.javaproject.budget.controller;

import edu.javaproject.budget.domain.Balance;
import edu.javaproject.budget.load.LoadObject;
import edu.javaproject.budget.purchases.Purchases;
import edu.javaproject.budget.save.SaveObjects;
import edu.javaproject.budget.strategy.Analyze;
import edu.javaproject.budget.strategy.CertainStrategy;
import edu.javaproject.budget.strategy.FullAnalyzeStrategy;
import edu.javaproject.budget.strategy.SortByTypeStrategy;
import edu.javaproject.budget.util.Util;

import java.io.FileNotFoundException;
import java.io.IOException;

public class User {

    private final Balance balance = Balance.newInstance();
    private final Purchases purchases = Purchases.newInstance();

    public static final String sortMenu = "How do you want to sort?\n" +
            "1) Sort all purchases\n" +
            "2) Sort by type\n" +
            "3) Sort certain type\n" +
            "4) Back";

    public void addBalance() throws IOException {
        System.out.println("Enter income:");
        balance.addBalance();
        System.out.println("Income was added!\n");
    }

    public void addPurchases() throws IOException {
        purchases.addCategory();
    }

    public void showList() throws IOException {
        purchases.showList();
    }

    public void getBalance() {
        System.out.println("Balance: $" + Balance.newInstance().getBalance());
        Util.indent();
    }

    public void save() throws IOException {
        SaveObjects saveObjects = new SaveObjects();
        saveObjects.save("purchases.txt");
        System.out.println("Purchases were saved!");
        Util.indent();
    }

    public void load() throws FileNotFoundException {
        LoadObject loadObject = new LoadObject();
        loadObject.load("purchases.txt");
        System.out.println("Purchases were loaded!");
        Util.indent();
    }

    public void analyze() throws IOException {
        int numberMenu;
        Analyze analyze = null;
        while (true) {
            System.out.println(sortMenu);
            numberMenu = Util.readInt();
            Util.indent();
            if (numberMenu == 1) {
                analyze = new Analyze(new FullAnalyzeStrategy());
            } else if (numberMenu == 2) {
                analyze = new Analyze(new SortByTypeStrategy());
            } else if (numberMenu == 3) {
                analyze = new Analyze(new CertainStrategy());
            } else if (numberMenu == 4) {
                break;
            }


            if (analyze == null) {
                break;
            } else {
                analyze.show();
            }
        }
    }
}
