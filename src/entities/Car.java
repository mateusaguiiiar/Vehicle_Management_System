package entities;

public class Car extends Vehicle {
    private int numDoors;

    public Car(String plate, String brand, double price, int numDoors) {
        super(plate, brand, price);
        this.numDoors = numDoors;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Número de Portas: " + numDoors);
    }

    public void showData(boolean detailDoors) {
        super.showData();

        if (detailDoors) {
            System.out.println("Detalhe Opcional - Número de Portas: " + numDoors);
        } else {
            System.out.println("Detalhe Opcional - Número de Portas Omitido.");
        }
    }
}