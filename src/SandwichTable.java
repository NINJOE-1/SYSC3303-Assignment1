// Joseph Vretenar 101234613
// SYSC 3303 Assignment 1
// Due: Jan 27th 2024

public class SandwichTable {
    private String ingredient1;
    private String ingredient2;
    private int sandwichesMade;
    public final int maxSandwiches;

    // set sandwiches made to 0 and max to the passed max value
    public SandwichTable(int maxSandwiches) {
        sandwichesMade = 0;
        this.maxSandwiches = maxSandwiches;
    }

    // make a sandwich will tell a chef to make a sandwich and eat it
    public synchronized void makeSandwich(String chefIngredient) throws InterruptedException {
        while (!hasIngredients(chefIngredient) && sandwichesMade < maxSandwiches) {
            wait();
        }

        if (sandwichesMade < maxSandwiches) {
            System.out.println("Chef making and eating a sandwich with " + chefIngredient + ".\n");
            clearTable();
            sandwichesMade++;
        }

        notifyAll();
    }

    // place ingredients will tell the agent to place the ingredients
    public synchronized void placeIngredients(int ingredientIndex) throws InterruptedException {
        while (hasIngredients() && sandwichesMade < maxSandwiches) {
            wait();
        }

        // 3 cases for the different chefs
        if (sandwichesMade < maxSandwiches) {
            switch (ingredientIndex) {
                case 0:
                    ingredient1 = "Bread";
                    ingredient2 = "Peanut Butter";
                    break;
                case 1:
                    ingredient1 = "Peanut Butter";
                    ingredient2 = "Jam";
                    break;
                case 2:
                    ingredient1 = "Jam";
                    ingredient2 = "Bread";
                    break;
            }

            System.out.println("Agent placing " + ingredient1 + " and " + ingredient2 + " on the table.");
        }

        notifyAll();
    }

    // check if the chef has the ingredients
    private synchronized boolean hasIngredients() {
        return ingredient1 != null && ingredient2 != null;
    }

    private synchronized boolean hasIngredients(String chefIngredient) {
        if (ingredient1 == null || ingredient2 == null) {
            return false;
        }

        // return the use case in either order
        return (chefIngredient.equals("Bread") && (ingredient1.equals("Jam") && ingredient2.equals("Peanut Butter") ||
                ingredient2.equals("Jam") && ingredient1.equals("Peanut Butter"))) ||
                (chefIngredient.equals("Peanut Butter") && (ingredient1.equals("Bread") && ingredient2.equals("Jam") ||
                        ingredient2.equals("Bread") && ingredient1.equals("Jam"))) ||
                (chefIngredient.equals("Jam") && (ingredient1.equals("Bread") && ingredient2.equals("Peanut Butter") ||
                        ingredient2.equals("Bread") && ingredient1.equals("Peanut Butter")));
    }

    // clear the table
    private synchronized void clearTable() {
        ingredient1 = null;
        ingredient2 = null;
    }

    // return the total sandwiches made so far
    public int getSandwichesMade() {
        return sandwichesMade;
    }
}