import java.util.Scanner;

/**
 * Simulate user interaction with Parrot objects by creating, storing,
 * and providing options for feeding, commanding, playing, hitting and quitting.
 * January 26, 2023
 *
 * @author Jesse Atkinson
 */
public class ParrotCraft {
    /**
     * Main method of the program that runs the user dialog
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Create 3 parrots and store them in the array
        Parrot[] parrots = new Parrot[3];
        for (int i = 0; i < 3; i++) {
            parrots[i] = new Parrot();
        }
        parrots[1].setName("Greg");
        parrots[1].setCrumbs(0.6);

        parrots[2].setName("Andrew");
        parrots[2].setCrumbs(1.0);
        while (true) {
            boolean allDead = true;
            // Loop to determine whether all parrots are dead
            for (Parrot value : parrots) {
                if (value.isAlive()) {
                    allDead = false;
                    break;
                }
            }
            if (allDead) {
                System.out.println("All parrots are dead.");
                break;
            }
            // Display the information for all the parrots in the array
            for (int i = 0; i < parrots.length; i++) {
                System.out.println((i + 1) + ". " + parrots[i]);
            }
            // Output
            System.out.println("1. Feed 2. Command 3. Play 4. Hit 5. Quit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            // Quit the program
            if (choice == 5) {
                break;
            }
            System.out.print("Which parrot? ");
            int parrotIndex = input.nextInt() - 1;
            Parrot parrot = parrots[parrotIndex];
            // Feed the parrot an amount of crumbs
            if (choice == 1) {
                System.out.print("How much? ");
                double amount = input.nextDouble();
                parrot.feed(amount);
                if (parrot.isTamed()) {
                    System.out.println("You tamed " + parrot.getName() + "!");
                }
            }
            // Command the parrot to sit or fly
            else if (choice == 2) {
                System.out.print("1. Sit 2. Fly: ");
                int command = input.nextInt();
                if (command == 1) {
                    parrot.command("sit");
                } else if (command == 2) {
                    parrot.command("fly");
                }
            }
            // Determine which parrots play together
            else if (choice == 3) {
                System.out.print("With which parrot? ");
                int otherParrotIndex = input.nextInt() - 1;
                Parrot otherParrot = parrots[otherParrotIndex];
                parrot.play(otherParrot);
            }
            // Hit the parrot
            else if (choice == 4) {
                parrot.hit();
            }
        }
    }
}