package package2;
public class Market {
    Stock[] stocks;

    Market() {
        stocks = new Stock[5];
        stocks[0] = new Stock("Apple", 150.0);
        stocks[1] = new Stock("Google", 2800.0);
        stocks[2] = new Stock("Amazon", 3400.0);
        stocks[3] = new Stock("Tesla", 700.0);
        stocks[4] = new Stock("Microsoft", 300.0);
    }

    // Show available stocks
    void showMarket() {
        System.out.println("\n------ Market Stocks ------");
        for (Stock stock : stocks) {
            System.out.println(stock.name + " - $" + stock.price);
        }
        System.out.println("----------------------------\n");
    }

    // Find stock by name
    Stock getStockByName(String name) {
        for (Stock stock : stocks) {
            if (stock.name.equalsIgnoreCase(name)) {
                return stock;
            }
        }
        return null;
    }
}
