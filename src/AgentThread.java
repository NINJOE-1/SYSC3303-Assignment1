// Joseph Vretenar 101234613
// SYSC 3303 Assignment 1
// Due: Jan 27th 2024

// import random and timeunit
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AgentThread extends Thread {
    private final SandwichTable sandwichTable;

    public AgentThread(SandwichTable sandwichTable) {
        this.sandwichTable = sandwichTable;
    }

    @Override
    public void run() {
        Random random = new Random(); // set up random number

        try {
            // check if maxSandwiches has been reached
            while (sandwichTable.getSandwichesMade() < sandwichTable.maxSandwiches) {
                sandwichTable.placeIngredients(random.nextInt(3)); // place 2 random ingredients
                TimeUnit.SECONDS.sleep(1);  // Simulating time to place ingredients on the table
            }
        } catch (InterruptedException e) {
            // Restore interrupted status
            Thread.currentThread().interrupt();
        }
    }
}