package package2;
public class Portfolio {
    String[] stockNames;
    int[] stockQuantities;
    double balance;
    int count;

    Portfolio(double startingBalance) {
        stockNames = new String[100]; // maximum 100 stocks
        stockQuantities = new int[100];
        balance = startingBalance;
        count = 0;
    }

    // Method to buy stocks
    void buyStock(String name, double price, int quantity) {
        double totalCost = price * quantity;

        if (balance >= totalCost) {
            int index = findStock(name);
            if (index == -1) { // New stock
                stockNames[count] = name;
                stockQuantities[count] = quantity;
                count++;
            } else { // Already have this stock
                stockQuantities[index] += quantity;
            }
            balance -= totalCost;
            System.out.println("Successfully bought " + quantity + " shares of " + name);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Method to sell stocks
    void sellStock(String name, double price, int quantity) {
        int index = findStock(name);

        if (index != -1 && stockQuantities[index] >= quantity) {
            stockQuantities[index] -= quantity;
            double totalSell = price * quantity;
            balance += totalSell;
            System.out.println("Successfully sold " + quantity + " shares of " + name);
        } else {
            System.out.println("You don't have enough shares to sell!");
        }
    }

    // Method to find stock index
    int findStock(String name) {
        for (int i = 0; i < count; i++) {
            if (stockNames[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // Show portfolio
    void showPortfolio() {
        System.out.println("\n------ Your Portfolio ------");
        if (count == 0) {
            System.out.println("No stocks owned.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(stockNames[i] + ": " + stockQuantities[i] + " shares");
            }
        }
        System.out.println("Available Balance: $" + balance);
        System.out.println("-----------------------------\n");
    }
}