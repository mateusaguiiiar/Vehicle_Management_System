package application;
import entities.Vehicle;
import entities.Car;
import entities.Motorcycle;
import entities.Truck;
import entities.Account;
import entities.CheckingAccount;
import entities.SavingsAccount;
import entities.InvestmentAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Vehicle> registeredVehicles = new ArrayList<>();
    private static final List<Account> registeredAccounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int mainOption = -1;

        do {
            System.out.println("\n==================================");
            System.out.println("MENU PRINCIPAL - Atividade Avaliativa");
            System.out.println("==================================");
            System.out.println("1. Sistema de Gestão de Veículos");
            System.out.println("2. Sistema de Gestão Bancária");
            System.out.println("0. Encerrar o Programa");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                mainOption = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (mainOption) {
                case 1:
                    vehicleManagementMenu();
                    break;
                case 2:
                    bankManagementMenu();
                    break;
                case 0:
                    System.out.println("\nPrograma encerrado. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (mainOption != 0);

        scanner.close();
    }

    private static void vehicleManagementMenu() {
        int vehicleOption;
        do {
            System.out.println("\n--- Gestão de Veículos ---");
            System.out.println("1. Cadastrar Carro");
            System.out.println("2. Cadastrar Moto");
            System.out.println("3. Cadastrar Caminhão");
            System.out.println("4. Listar Todos os Veículos (e testar métodos)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                vehicleOption = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                vehicleOption = -1;
                continue;
            }

            switch (vehicleOption) {
                case 1:
                    registerCar();
                    break;
                case 2:
                    registerMotorcycle();
                    break;
                case 3:
                    registerTruck();
                    break;
                case 4:
                    listVehicles();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (vehicleOption != 0);
    }

    private static Vehicle readBasicVehicleData() {
        System.out.print("Placa: ");
        String plate = scanner.nextLine();
        System.out.print("Marca: ");
        String brand = scanner.nextLine();
        System.out.print("Preço: R$ ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        return new Vehicle(plate, brand, price);
    }

    private static void registerCar() {
        System.out.println("\n--- Cadastro de Carro ---");
        Vehicle temp = readBasicVehicleData();

        System.out.print("Número de Portas: ");
        int numDoors = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(temp.getPlate(), temp.getBrand(), temp.getPrice(), numDoors);
        registeredVehicles.add(car);
        System.out.println("Carro cadastrado com sucesso!");
    }

    private static void registerMotorcycle() {
        System.out.println("\n--- Cadastro de Moto ---");
        Vehicle temp = readBasicVehicleData();

        System.out.print("Cilindradas (cc): ");
        int engineCylinders = scanner.nextInt();
        scanner.nextLine();

        Motorcycle motorcycle = new Motorcycle(temp.getPlate(), temp.getBrand(), temp.getPrice(), engineCylinders);
        registeredVehicles.add(motorcycle);
        System.out.println("Moto cadastrada com sucesso!");
    }

    private static void registerTruck() {
        System.out.println("\n--- Cadastro de Caminhão ---");
        Vehicle temp = readBasicVehicleData();

        System.out.print("Capacidade de Carga (toneladas): ");
        double cargoCapacity = scanner.nextDouble();
        scanner.nextLine();

        Truck truck = new Truck(temp.getPlate(), temp.getBrand(), temp.getPrice(), cargoCapacity);
        registeredVehicles.add(truck);
        System.out.println("Caminhão cadastrado com sucesso!");
    }

    private static void listVehicles() {
        if (registeredVehicles.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.println("\n\n=============== LISTAGEM DE VEÍCULOS ===============");
        for (Vehicle v : registeredVehicles) {
            System.out.println("\n**************************************************");
            System.out.println("-> Chamada padrão (Sobrescrita):");
            v.showData();

            System.out.println("\n-> Chamada com Desconto (Sobrecarga de Vehicle):");
            v.showData(10.0);

            System.out.println("\n-> Chamada Opcional (Sobrecarga da Subclasse):");
            if (v instanceof Car) {
                ((Car) v).showData(true);
            } else if (v instanceof Motorcycle) {
                ((Motorcycle) v).showData(true);
            } else if (v instanceof Truck) {
                ((Truck) v).showData(true);
            }
        }
        System.out.println("\n=============== FIM DA LISTAGEM ===============");
    }

    private static void bankManagementMenu() {
        int accountOption;
        do {
            System.out.println("\n--- Gestão Bancária ---");
            System.out.println("1. Cadastrar Conta Corrente");
            System.out.println("2. Cadastrar Conta Poupança");
            System.out.println("3. Cadastrar Conta Investimento");
            System.out.println("4. Listar Todas as Contas (e testar métodos)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                accountOption = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                accountOption = -1;
                continue;
            }

            switch (accountOption) {
                case 1:
                    registerCheckingAccount();
                    break;
                case 2:
                    registerSavingsAccount();
                    break;
                case 3:
                    registerInvestmentAccount();
                    break;
                case 4:
                    listAccounts();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (accountOption != 0);
    }

    private static Account readBasicAccountData() {
        System.out.print("Número da Conta: ");
        String number = scanner.nextLine();
        System.out.print("Nome do Titular: ");
        String holder = scanner.nextLine();
        System.out.print("Saldo Inicial: R$ ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        return new Account(number, holder, balance);
    }

    private static void registerCheckingAccount() {
        System.out.println("\n--- Cadastro de Conta Corrente ---");
        Account temp = readBasicAccountData();

        System.out.print("Limite do Cheque Especial: R$ ");
        double limit = scanner.nextDouble();
        scanner.nextLine();

        CheckingAccount checkingAccount = new CheckingAccount(temp.getNumber(), temp.getHolder(), temp.getBalance(), limit);
        registeredAccounts.add(checkingAccount);
        System.out.println("Conta Corrente cadastrada com sucesso!");
    }

    private static void registerSavingsAccount() {
        System.out.println("\n--- Cadastro de Conta Poupança ---");
        Account temp = readBasicAccountData();

        System.out.print("Taxa de Rendimento Mensal (%): ");
        double rate = scanner.nextDouble();
        scanner.nextLine();

        SavingsAccount savingsAccount = new SavingsAccount(temp.getNumber(), temp.getHolder(), temp.getBalance(), rate);
        registeredAccounts.add(savingsAccount);
        System.out.println("Conta Poupança cadastrada com sucesso!");
    }

    private static void registerInvestmentAccount() {
        System.out.println("\n--- Cadastro de Conta Investimento ---");
        Account temp = readBasicAccountData();

        System.out.print("Taxa de Administração (%): ");
        double fee = scanner.nextDouble();
        scanner.nextLine();

        InvestmentAccount investmentAccount = new InvestmentAccount(temp.getNumber(), temp.getHolder(), temp.getBalance(), fee);
        registeredAccounts.add(investmentAccount);
        System.out.println("Conta Investimento cadastrada com sucesso!");
    }

    private static void listAccounts() {
        if (registeredAccounts.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("\n\n=============== LISTAGEM DE CONTAS ===============");
        for (Account c : registeredAccounts) {
            System.out.println("\n**************************************************");

            System.out.println("-> Chamada padrão (Sobrescrita):");
            c.showData();

            System.out.println("\n-> Chamada com Projeção (Sobrecarga de Account):");
            c.showData(0.5); // 0.5% Projection

            System.out.println("\n-> Chamada Opcional (Sobrecarga da Subclasse):");
            if (c instanceof CheckingAccount) {
                ((CheckingAccount) c).showData(true); // Detail limit
            } else if (c instanceof SavingsAccount) {
                ((SavingsAccount) c).showData(true); // Show annual rate
            } else if (c instanceof InvestmentAccount) {
                ((InvestmentAccount) c).showData(true); // Consider admin fee
            }
        }
        System.out.println("\n=============== FIM DA LISTAGEM ===============");
    }
}
