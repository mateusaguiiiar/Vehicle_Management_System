package entities;

public class Account {
    private String number;
    private String holder;
    private double balance;

    public Account(String number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void showData() {
        System.out.println("--- Dados da Conta ---");
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Número: " + number);
        System.out.println("Titular: " + holder);
        System.out.println("Saldo: R$ " + String.format("%.2f", balance));
    }

    public void showData(double monthlyProjection) {
        showData();

        double projectedBalance = balance * (1 + (monthlyProjection / 100.0));

        System.out.println("--- Projeção de Saldo ---");
        System.out.println("Projeção Mensal: " + String.format("%.2f", monthlyProjection) + "%");
        System.out.println("Saldo Projetado: R$ " + String.format("%.2f", projectedBalance));
    }
}
