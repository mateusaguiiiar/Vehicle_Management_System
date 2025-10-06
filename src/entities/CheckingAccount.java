package entities;

public class CheckingAccount extends Account {
    private double specialCheckLimit;

    public CheckingAccount(String number, String holder, double balance, double specialCheckLimit) {
        super(number, holder, balance);
        this.specialCheckLimit = specialCheckLimit;
    }

    public double getSpecialCheckLimit() {
        return specialCheckLimit;
    }

    public void setSpecialCheckLimit(double specialCheckLimit) {
        this.specialCheckLimit = specialCheckLimit;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Limite Cheque Especial: R$ " + String.format("%.2f", specialCheckLimit));
    }

    public void showData(boolean detailLimit) {
        if (detailLimit) {
            super.showData();
            System.out.println("Limite Cheque Especial: R$ " + String.format("%.2f", specialCheckLimit));

            double totalAvailableBalance = getBalance() + specialCheckLimit;
            System.out.println("** Saldo Disponível Total: R$ " + String.format("%.2f", totalAvailableBalance) + " **");
        } else {
            super.showData();
        }
    }
}
