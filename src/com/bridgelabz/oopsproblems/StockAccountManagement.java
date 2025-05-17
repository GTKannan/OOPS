package com.bridgelabz.oopsproblems;

import java.util.ArrayList;
import java.util.Scanner;

// Class to represent individual stock
class Stock {
    String name;
    int numberOfShares;
    double sharePrice;

    public Stock(String name, int numberOfShares, double sharePrice) {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    // Method to calculate total value of this stock
    public double getStockValue() {
        return numberOfShares * sharePrice;
    }

    public void displayStockReport() {
        System.out.println("Stock Name: " + name);
        System.out.println("Number of Shares: " + numberOfShares);
        System.out.println("Share Price: ₹" + sharePrice);
        System.out.println("Total Stock Value: ₹" + getStockValue());
        System.out.println("------------------------------------");
    }
}

// Class to represent the stock portfolio
class StockPortfolio {
    ArrayList<Stock> stockList = new ArrayList<>();

    // Add a stock to the portfolio
    public void addStock(Stock stock) {
        stockList.add(stock);
    }

    // Display all stock reports and total portfolio value
    public void displayPortfolioReport() {
        double totalValue = 0;
        System.out.println("\n--- Stock Report ---");
        for (Stock stock : stockList) {
            stock.displayStockReport();
            totalValue += stock.getStockValue();
        }
        System.out.println("Total Portfolio Value: ₹" + totalValue);
    }
}

public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter number of stocks to add: ");
        int numberOfStocks = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfStocks; i++) {
            System.out.println("\nEnter details for Stock " + i + ":");

            System.out.print("Stock Name: ");
            String name = scanner.nextLine();

            System.out.print("Number of Shares: ");
            int shares = Integer.parseInt(scanner.nextLine());

            System.out.print("Share Price (₹): ");
            double price = Double.parseDouble(scanner.nextLine());

            Stock stock = new Stock(name, shares, price);
            portfolio.addStock(stock);
        }

        // Display the complete report
        portfolio.displayPortfolioReport();
    }
}
