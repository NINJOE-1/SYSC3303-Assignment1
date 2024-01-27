// Joseph Vretenar 101234613
// SYSC 3303 Assignment 1
// Due: Jan 27th 2024

// import logging to record errors in the threads
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName()); // setup the logger
    public static void main(String[] args) {
        SandwichTable sandwichTable = new SandwichTable(20); // create sandwich table with maxSandwiches of 20
        ChefThread chefThread1 = new ChefThread("Bread", sandwichTable); // create a chef with infinite bread
        ChefThread chefThread2 = new ChefThread("Peanut Butter", sandwichTable); // create a chef with infinite peanut butter
        ChefThread chefThread3 = new ChefThread("Jam", sandwichTable); // create a chef with infinite jam
        AgentThread agentThread = new AgentThread(sandwichTable); // create an agent with infinite ingredients

        // start all the threads
        chefThread1.start();
        chefThread2.start();
        chefThread3.start();
        agentThread.start();

        try {
            // Wait for all threads to finish
            chefThread1.join();
            chefThread2.join();
            chefThread3.join();
            agentThread.join();
        } catch (InterruptedException e) {
            // if there is an error log it in the console
            logger.log(Level.SEVERE, "An unexpected error occurred while waiting for threads to finish", e);
        }

        // Check if 20 sandwiches are made and eaten
        if (sandwichTable.getSandwichesMade() == sandwichTable.maxSandwiches) {
            System.out.println("All sandwiches made and eaten. Exiting...");
        } else {
            logger.log(Level.SEVERE, "Unexpected termination. Number of sandwiches made: " + sandwichTable.getSandwichesMade());
        }
    }
}