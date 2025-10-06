package entities;

public class SavingsAccount extends Account {
    private double monthlyYieldRate; // in %

    public SavingsAccount(String number, String holder, double balance, double monthlyYieldRate) {
        super(number, holder, balance);
        this.monthlyYieldRate = monthlyYieldRate;
    }

    public double getMonthlyYieldRate() {
        return monthlyYieldRate;
    }

    public void setMonthlyYieldRate(double monthlyYieldRate) {
        this.monthlyYieldRate = monthlyYieldRate;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Taxa de Rendimento Mensal: " + String.format("%.2f", monthlyYieldRate) + "%");
    }

    public void showData(boolean inAnnualRate) {
        super.showData();

        if (inAnnualRate) {
            double approximateAnnualRate = monthlyYieldRate * 12;
            System.out.println("Exibição Opcional - Taxa Anual Aprox.: " + String.format("%.2f", approximateAnnualRate) + "%");
        } else {
            System.out.println("Exibição Opcional - Taxa Mensal: " + String.format("%.2f", monthlyYieldRate) + "%");
        }
    }
}
