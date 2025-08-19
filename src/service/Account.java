package service;

import models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getBalance() {
        double total = 0;
        for (Transaction t : transactions) {
            total += t.getImpactOnTotalAmount();
        }
        return total;
    }

    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        for (Transaction t : transactions) {
            report.add(t.toString());
        }
        return report;
    }
}
