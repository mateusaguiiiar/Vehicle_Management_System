package entities;

public class Vehicle {
    protected String plate;
    protected String brand;
    protected double price;

    public Vehicle(String plate, String brand, double price) {
        this.plate = plate;
        this.brand = brand;
        this.price = price;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void showData() {
        System.out.println("--- Dados do Veículo ---");
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Placa: " + plate);
        System.out.println("Marca: " + brand);
        System.out.println("Preço: R$ " + String.format("%.2f", price));
    }

    public void showData(double discountPercentage) {
        showData();

        if (discountPercentage > 0) {
            double discountValue = price * (discountPercentage / 100.0);
            double priceWithDiscount = price - discountValue;

            System.out.println("--- Desconto Aplicado ---");
            System.out.println("Desconto (" + String.format("%.2f", discountPercentage) + "%): R$ " + String.format("%.2f", discountValue));
            System.out.println("Preço Final com Desconto: R$ " + String.format("%.2f", priceWithDiscount));
        } else {
            System.out.println("Nenhum desconto aplicado.");
        }
    }
}
