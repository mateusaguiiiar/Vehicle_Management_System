package entities;

public class InvestmentAccount extends Account {
    private double administrationFee;

    public InvestmentAccount(String number, String holder, double balance, double administrationFee) {
        super(number, holder, balance);
        this.administrationFee = administrationFee;
    }

    public double getAdministrationFee() {
        return administrationFee;
    }

    public void setAdministrationFee(double administrationFee) {
        this.administrationFee = administrationFee;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Taxa de Administração: " + String.format("%.2f", administrationFee) + "%");
    }

    public void showData(boolean considerFee) {
        if (considerFee) {
            double monthlyProjection = 1.0;
            double projectedBalance = getBalance() * (1 + (monthlyProjection / 100.0));

            double feeValue = projectedBalance * (administrationFee / 100.0);
            double netBalance = projectedBalance - feeValue;

            super.showData();
            System.out.println("Taxa de Administração: " + String.format("%.2f", administrationFee) + "%");
            System.out.println("--- Projeção Líquida (Projeção 1% - Taxa Adm) ---");
            System.out.println("Saldo Projetado Bruto: R$ " + String.format("%.2f", projectedBalance));
            System.out.println("Valor da Taxa de Administração: R$ " + String.format("%.2f", feeValue));
            System.out.println("** Saldo Líquido Estimado: R$ " + String.format("%.2f", netBalance) + " **");
        } else {
            super.showData();
        }
    }
}