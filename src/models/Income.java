package models;

public class Income extends Transaction{

    public Income(double amount, String description) {
        super(amount, description);
    }

    @Override
    public double getImpactOnTotalAmount() {
        return getAmount();
    }

    @Override
    public String toString() {
        return "Ingreso - " + super.toString();
    }
}
