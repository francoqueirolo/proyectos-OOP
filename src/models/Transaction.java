package models;

import java.util.Date;

public abstract class Transaction {

    private Date date;
    private double amount;
    private String description;

    public Transaction() {}

    public Transaction(double amount, String description) {
        this.date = new Date(); // Asignar la fecha actual
        this.amount = amount;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
    * Metodo abstracto para calcular el impacto de la transaccion en el saldo.
    * Ilustrar el polimorfismo porque cada subclase va a implementarlo de forma diferente
     */
    public abstract double getImpactOnTotalAmount();

    /**
     * Metodo para obtener una representación en string de la transacción.
     * Sobrescrito de Object para personalización, demostrando herencia implícita.
     */
    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
