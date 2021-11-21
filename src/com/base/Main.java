package com.base;

import controller.Controller;
import views.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView(new Store("Lidl", "Str. Rusciorului", new ProductCatalog()), new Controller());

        view.start();
    }
}
