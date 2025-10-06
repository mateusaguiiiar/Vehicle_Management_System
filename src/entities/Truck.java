package entities;

public class Truck extends Vehicle {
    private double cargoCapacity; // in tons

    public Truck(String plate, String brand, double price, double cargoCapacity) {
        super(plate, brand, price);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Capacidade de Carga: " + String.format("%.2f", cargoCapacity) + " toneladas");
    }

    public void showData(boolean inKilograms) {
        super.showData();

        if (inKilograms) {
            double capacityKg = cargoCapacity * 1000.0;
            System.out.println("Exibição Opcional - Capacidade de Carga: " + String.format("%.2f", capacityKg) + " kg");
        } else {
            System.out.println("Exibição Opcional - Capacidade de Carga: " + String.format("%.2f", cargoCapacity) + " toneladas");
        }
    }
}
