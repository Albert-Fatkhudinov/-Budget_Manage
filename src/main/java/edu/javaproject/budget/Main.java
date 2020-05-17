package edu.javaproject.budget;


import edu.javaproject.budget.controller.User;
import edu.javaproject.budget.util.Util;

import java.io.IOException;


public class Main {

    public static final String MAIN_MENU = "Choose your action:\n" +
            "1) Add income\n" +
            "2) Add purchase\n" +
            "3) Show list of purchases\n" +
            "4) Balance\n" +
            "5) Save\n" +
            "6) Load\n" +
            "7) Analyze (Sort)\n" +
            "0) Exit";

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        User user = new User();
        main.menu(user);
    }

    private void menu(User user) throws IOException {
        int numberMenu;
        while (true) {
            System.out.println(MAIN_MENU);

            numberMenu = Util.readInt();
            System.out.println();

            if (numberMenu == 0) {
                System.out.println("Bye!");
                break;
            } else if (numberMenu == 1) {
                user.addBalance();
            } else if (numberMenu == 2) {
                user.addPurchases();
            } else if (numberMenu == 3) {
                user.showList();
            } else if (numberMenu == 4) {
                user.getBalance();
            } else if (numberMenu == 5) {
                user.save();
            } else if (numberMenu == 6) {
                user.load();
            } else if (numberMenu == 7) {
                user.analyze();
            }
        }
    }
}
