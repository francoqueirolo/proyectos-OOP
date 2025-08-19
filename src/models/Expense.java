package models;

public class Expense extends Transaction {

    public Expense(double amount, String description) {
        super(amount, description);
    }

    @Override
    public double getImpactOnTotalAmount() {
        return -getAmount();
    }

    @Override
    public String toString() {
        return "Gasto - " + super.toString();
    }
}
