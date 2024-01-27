# SYSC 3303 Assignment 1
## The sandwich making chefs problem

The Sandwich Making Chefs Problem. (This problem was first published as the cigarette smokers
problem by S. Patil in 1971, and is one of several classic process coordination problems that are used
to evaluate facilities for synchronizing concurrent threads and processes.)

Consider a system with three chef threads and one agent thread. Each chef continuously makes a
sandwich and then eats it. But to make and eat a sandwich, the chef needs three ingredients: bread,
peanut butter, and jam. One of the chef threads has an infinite supply of bread, another has peanut
butter, and the third has jam. The agent has an infinite supply of all three ingredients. The agent
randomly selects two of the ingredients and places them on a table. The chef who has the remaining
ingredient then makes and eats a sandwich, signalling the agent on completion. The agent then puts
out another two of the three ingredients, and the cycle repeats.

## Files
### [Main.java](src/Main.java)
This is the main class, it orchestrates the simulation. 
It initializes the `SandwichTable`, `ChefThread`, and `AgentThread` instances, starts the threads, and monitors their execution.

### [SandwichTable.java](src/SandwichTable.java)
A class representing the shared sandwich table. 
It contains methods for chefs to make sandwiches and agents to place ingredients.

### [AgentThread.java](src/AgentThread.java)
A thread class representing a chef. 
It makes and eats sandwiches based on the available ingredients on the sandwich table.

### [ChefThread.java](src/ChefThread.java)
A thread class representing an agent. 
It randomly places two ingredients on the sandwich table.

## Setup Instructions
1. Make sure java is installed on your system
2. Compile the Java files either using an IDE or through command lines
3. Run the simulation from the [Main file](src/Main.java)

To edit the max number of sandwiches produced and consumed, the value *maxSandwiches* in the brackets on line 12 in [Main.java](src/Main.java) 
can be set to any number wanted, by default it is set to 20.

`SandwichTable sandwichTable = new SandwichTable( maxSandwiches );`

## Expected Output
The program will simulate the sandwich making chefs problem until it has simulated 20 sandwiches by default.
This means that it will have the Agent constantly putting two of three ingredients on a table for the chefs to take.
When a chef sees the two ingredients it will check if it needs them to make a sandwich,
if it does, it will take the ingredients and make a sandwich.
The process will be printed out on the console in this configuration:

`Agent placing Bread and Peanut Butter on the table.`

`Chef making and eating a sandwich with Jam.`

## Logging
The program uses the `java.util.logging.Logger` for logging unexpected errors or events. 
Log messages are displayed in the console.