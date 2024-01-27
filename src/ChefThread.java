// Joseph Vretenar 101234613
// SYSC 3303 Assignment 1
// Due: Jan 27th 2024

import java.util.concurrent.TimeUnit;

public class ChefThread extends Thread {
    private final String ingredient;
    private final SandwichTable sandwichTable;

    public ChefThread(String ingredient, SandwichTable sandwichTable) {
        this.ingredient = ingredient;
        this.sandwichTable = sandwichTable;
    }

    @Override
    public void run() {
        try {
            // check if maxSandwiches has been reached
            while (sandwichTable.getSandwichesMade() < sandwichTable.maxSandwiches) {
                sandwichTable.makeSandwich(ingredient); // make a sandwich
                TimeUnit.SECONDS.sleep(1);  // Simulating time to make and eat a sandwich
            }
        } catch (InterruptedException e) {
            // Restore interrupted status
            Thread.currentThread().interrupt();
        }
    }
}