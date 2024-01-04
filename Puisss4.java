import java.util.Scanner;

public class Puisss4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // menu du jeu
        while (true) {
            System.out.println("Menu Puissance 4 :");
            System.out.println("1. Règle du jeu ");
            System.out.println("2. Puissance 4 sans Robot");
            System.out.println("3. Puissance 4 avec Robot"); // Vous pourriez vouloir implémenter cela plus tard
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option (1-4): ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    fo.regledejeu();
                    break;
                case 2:
                    fo.jouerPuissance4SansRobot();
                    break;
                case 3:
                    // jouerPuissance4AvecRobot(); // À implémenter
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    return; // Utilisez return pour sortir du programme
                default:
                    System.out.println("Veuillez choisir une option valide.");
            }
        }
    }
}