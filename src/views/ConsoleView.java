package views;

import com.base.Store;
import controller.Controller;

import java.util.Scanner;

public class ConsoleView {
    Store currentStore;
    Controller controller;

    public ConsoleView(Store currentStore, Controller controller) {
        this.currentStore = currentStore;
        this.controller = controller;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("What do you wanna do next? Sale/Return/Exit");
            String response = scanner.nextLine().toLowerCase();

            if(response.equals("sale")){
                controller.processSale(currentStore);
            }
            else if(response.equals("return")){
                controller.handleReturns(currentStore);
            }
            else if(response.equals("exit")){
                System.out.println("Closing System...");
                break;
            }
        }
    }
}
