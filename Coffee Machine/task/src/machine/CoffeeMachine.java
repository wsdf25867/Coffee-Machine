package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int mlOfWater = 400;
    static int mlOfMilk = 540;
    static int gOfCoffee = 120;
    static int disposableCups = 9;
    static int money = 550;

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Write action (buy, fill, take, remaining, exit):\n");
            String action = scanner.nextLine();

            if ("buy".equals(action)) {
                buy();
            } else if ("fill".equals(action)) {
                fill();
            } else if ("take".equals(action)){
                take();
            } else if ("remaining".equals(action)) {
                remaining();
            } else if ("exit".equals(action)) {
                break;
            }
        }
    }

    private static void take() {
        System.out.printf("I gave you $%d\n",money);
        money = 0;
    }

    private static void fill() {
        System.out.printf("Write how many ml of water you want to add: \n");
        mlOfWater += scanner.nextInt();
        System.out.printf("Write how many ml of milk you want to add: \n");
        mlOfMilk += scanner.nextInt();
        System.out.printf("Write how many grams of coffee beans you want to add: \n");
        gOfCoffee += scanner.nextInt();
        System.out.printf("Write how many disposable cups you want to add: \n");
        disposableCups += scanner.nextInt();
    }

    private static void buy() {
        System.out.printf("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: \n");
        String select = scanner.nextLine();
        if ("back".equals(select)) {
            return;
        }
        Coffee.values()[Integer.parseInt(select)-1].calculate();
    }

    private static void remaining() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, mlOfWater, mlOfMilk, gOfCoffee, disposableCups, money);
    }

    enum Coffee {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        int amountOfWater;
        int amountOfMilk;
        int amountOfCoffee;
        int cost;

        Coffee(int amountOfWater, int amountOfMilk, int amountOfCoffee, int cost) {
            this.amountOfWater = amountOfWater;
            this.amountOfMilk = amountOfMilk;
            this.amountOfCoffee = amountOfCoffee;
            this.cost = cost;
        }

        public void calculate() {
            if (mlOfWater < amountOfWater) {
                System.out.printf("Sorry, not enough water!\n");
                return;
            }
            if (mlOfMilk < amountOfMilk) {
                System.out.printf("Sorry, not enough milk!\n");
                return;
            }
            if (gOfCoffee < amountOfCoffee) {
                System.out.printf("Sorry, not enough coffee beans!\n");
                return;
            }
            if (disposableCups == 0) {
                System.out.printf("Sorry, not enough cup!\n");
                return;
            }
            mlOfWater -= this.amountOfWater;
            mlOfMilk -= this.amountOfMilk;
            gOfCoffee -= this.amountOfCoffee;
            disposableCups--;
            money += cost;
        }

    }

}
