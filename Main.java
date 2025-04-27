package package2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Market market = new Market();
        Portfolio portfolio = new Portfolio(10000.0); // Starting balance = 10,000

        System.out.println("Welcome to the Stock Trading Platform!");

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. View Market Stocks");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    market.showMarket();
                    break;
                case 2:
                    System.out.print("Enter stock name to buy: ");
                    String buyName = scanner.nextLine();
                    System.out.print("Enter quantity to buy: ");
                    int buyQty = scanner.nextInt();

                    Stock buyStock = market.getStockByName(buyName);
                    if (buyStock != null) {
                        portfolio.buyStock(buyStock.name, buyStock.price, buyQty);
                    } else {
                        System.out.println("Stock not found in market!");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock name to sell: ");
                    String sellName = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQty = scanner.nextInt();

                    Stock sellStock = market.getStockByName(sellName);
                    if (sellStock != null) {
                        portfolio.sellStock(sellStock.name, sellStock.price, sellQty);
                    } else {
                        System.out.println("Stock not found in market!");
                    }
                    break;
                case 4:
                    portfolio.showPortfolio();
                    break;
                case 5:
                    System.out.println("Thank you for using the platform! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}