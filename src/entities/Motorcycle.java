package entities;

public class Motorcycle extends Vehicle {
    private int engineCylinders;

    public Motorcycle(String plate, String brand, double price, int engineCylinders) {
        super(plate, brand, price);
        this.engineCylinders = engineCylinders;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Cilindradas: " + engineCylinders + " cc");
    }

    public void showData(boolean inHorsepower) {
        super.showData();

        if (inHorsepower) {
            double horsepower = engineCylinders * 0.015;
            System.out.println("Exibição Opcional - Cavalos de Potência: " + String.format("%.2f", horsepower) + " HP");
        } else {
            System.out.println("Exibição Opcional - Cilindradas: " + engineCylinders + " cc");
        }
    }
}
