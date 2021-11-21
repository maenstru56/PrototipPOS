package controller;

import com.base.Store;

import java.util.Scanner;

public class Controller {
    public void processSale(Store currentStore) {
        System.out.println("Welcome to " + currentStore.getName() + " , scan the products on the line please!");

        Scanner scanner = new Scanner(System.in);

        currentStore.getRegister().makeNewSale();

        boolean saleFinished = currentStore.getRegister().getCurrentSale().isComplete();

        while(!saleFinished){
            System.out.print("Enter next ID: ");
            int itemId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("How many?: ");
            int itemQuantity = scanner.nextInt();
            scanner.nextLine();

            currentStore.getRegister().enterItem(itemId, itemQuantity);

            System.out.println("Is sale finished? Y/N");
            String response = scanner.nextLine().toLowerCase();

            if(response.equals("y")){
                currentStore.getRegister().endSale();
                saleFinished = currentStore.getRegister().getCurrentSale().isComplete();
            }
        }

        double total = currentStore.getRegister().getCurrentSale().getTotal();

        System.out.println("Total: " + total);

        System.out.println("Payment type? Cash/Credit");
        String response = scanner.nextLine().toLowerCase();

        while(!(response.equals("cash") || response.equals("credit"))){
            System.out.println("Payment not available! Only cash/credit!");

            response = scanner.nextLine().toLowerCase();
        }

        if(response.equals("cash")){
            double moneyGiven = -1;

            System.out.println("Money given: ");
            while(moneyGiven < total){
                moneyGiven = scanner.nextDouble();
                scanner.nextLine();

                if(moneyGiven < total){
                    System.out.println("(┛ಠ_ಠ)┛彡┻━┻");
                    System.out.println("（･∀･)つ⑩ Gimme more money!");
                }
            }

            currentStore.getRegister().makePayment("cash", moneyGiven);

            double change = currentStore.getRegister().getCurrentSale().getBalance();

            if(change > 0) {
                System.out.println("The change is: " + change);
            }
        }
        else if(response.equals("credit")){
            currentStore.getRegister().makePayment("credit", currentStore.getRegister().getCurrentSale().getTotal());
        }

        System.out.println("Thanks for choosing the Communist Week at LIDL!");
    }

    public void handleReturns(Store currentStore) {
        System.out.println("Welcome to " + currentStore.getName() + " , what is returned?");

        Scanner scanner = new Scanner(System.in);

        currentStore.getRegister().makeNewSale();

        boolean returnFinished = currentStore.getRegister().getCurrentSale().isComplete();

        while(!returnFinished){
            System.out.print("Enter next ID: ");
            int itemId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("How many?: ");
            int itemQuantity = scanner.nextInt();
            scanner.nextLine();

            currentStore.getRegister().enterItem(itemId, -itemQuantity);

            System.out.println("Is return finished? Y/N");
            String response = scanner.nextLine().toLowerCase();

            if(response.equals("y")){
                currentStore.getRegister().endSale();
                returnFinished = currentStore.getRegister().getCurrentSale().isComplete();
            }
        }

        double total = currentStore.getRegister().getCurrentSale().getTotal();

        System.out.println("Total to return: " + -total);

        currentStore.getRegister().makePayment("cash", currentStore.getRegister().getCurrentSale().getTotal());

        System.out.println("Thanks for choosing the Communist Week at LIDL!");
    }
}
