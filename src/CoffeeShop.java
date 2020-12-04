import java.util.Scanner;
import java.util.Random;
public class CoffeeShop {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        final int[] Balance = {0};
        final int[] CardNum = {new Random().nextInt(10000)};
        class util {
            int scanInt() {
                return reader.nextInt();
            } int getBalance() {
                return Balance[0];
            } void addBalance(int args) {
                Balance[0] = Balance[0] + args;
            }
        }
        class RemoteCommands {
            void startMenu() {
                System.out.println("\nWelcome to the cafe! You have $" + new util().getBalance() + ".\n");
                System.out.println("Select from the following options:\n\n1. View the ordering menu\n2. Order something\n3. See how much money you have\n4. Add money to your account\n5. Check your payment method\n0. Quit\n");
                int option = new util().scanInt();
                if (option == 0) {
                    System.exit(1);
                } else if (option == 1) {
                    this.orderMenu();
                } else if (option == 2) {
                    this.order();
                } else if (option == 3) {
                    System.out.println("Your balance is $" + new util().getBalance() + ".");
                    this.startMenu();
                } else if (option == 4) {
                    this.addMoneyMenu();
                } else if (option == 5) {
                    System.out.println("Payment method: MasterCard Debit " + CardNum[0]);
                    this.startMenu();
                }

            } void orderMenu() {
                System.out.println("\nThe menu:\n\n1. Breakfast Burrito ($6)\n2. Hot Coffee ($2)\n3. Cappuccino ($4)\n4. Iced Coffee ($2)\n5. Doughnut ($5)");
                new RemoteCommands().startMenu();
            } void order() {
                System.out.println("\nOrder from the menu (choose 1 to 5):\n\n1. Breakfast Burrito ($6)\n2. Hot Coffee ($2)\n3. Cappuccino ($4)\n4. Iced Coffee ($2)\n5. Doughnut ($5)\n0. Exit");
                int option = new util().scanInt();
                if (Balance[0] < option) {
                    System.out.println("You don't have enough for this item! Your card only has $" + Balance[0] + ".");
                    this.order();
                } else if (option == 0) {
                    new RemoteCommands().startMenu();
                } else if (option == 1) {
                    Balance[0] = (int) (Balance[0] - 6);
                    System.out.println("The transaction has completed successfully, using payment method MasterCard " + CardNum[0] + ". Enjoy your Breakfast Burrito!");
                    this.startMenu();
                } else if (option == 2) {
                    Balance[0] = (int) (Balance[0] - 2);
                    System.out.println("The transaction has completed successfully, using payment method MasterCard " + CardNum[0] + ". Enjoy your Hot Coffee!");
                    this.startMenu();
                } else if (option == 3) {
                    Balance[0] = (int) (Balance[0] - 4);
                    System.out.println("The transaction has completed successfully, using payment method MasterCard " + CardNum[0] + ". Enjoy your Cappuccino!");
                    this.startMenu();
                } else if (option == 4) {
                    Balance[0] = (int) (Balance[0] - 2);
                    System.out.println("The transaction has completed successfully, using payment method MasterCard " + CardNum[0] + ". Enjoy your Iced Coffee!");
                    this.startMenu();
                } else if (option == 5) {
                    Balance[0] = (int) (Balance[0] - 5);
                    System.out.println("The transaction has completed successfully, using payment method MasterCard " + CardNum[0] + ". Enjoy your Doughnut!");
                    this.startMenu();
                }
            } void addMoneyMenu() {
                System.out.println("\nHow much would you like to add to your account?\n");
                int option = new util().scanInt();
                new util().addBalance(option);
                System.out.println("You have added $" + option + " to MasterCard " + CardNum[0] + ".");
                this.startMenu();
            }
        }

        new RemoteCommands().startMenu();

    }
}
