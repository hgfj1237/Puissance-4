import java.util.Scanner;
import java.util.Random;

public class Puissance4AvecRobot {

    public static void jouerPuissance4AvecRobot() {
        Scanner scanner = new Scanner(System.in);
        String joueur;

        System.out.println("Vous jouez au Puissance 4 avec robot.");
        // les noms des joueurs
        System.out.print("Choisissez un nom: ");
        joueur = scanner.next();
       

        System.out.println("_____________________________\n");

        char[][] grille = new char[6][7];
        initGrille(grille);
        boolean finDuJeu = false;
        while (!finDuJeu) {
            Boolean tour = true;
            
            // Tour du joueur 1
            do{
                tour = jouerTour(scanner, grille, joueur, 'X'); // Utiliser des caractères pour représenter les jetons
                if(tour){
                    afficherGrille(grille);
                }
                if (verifierVictoire(grille, 'X')) {
                    System.out.println(joueur + " a gagné !");
                    break;
                }
            }while(!tour);
            

            // Tour du joueur 2
            do{
                tour = jouerTourBis(scanner, grille, 'O');
                                if(tour){
                    afficherGrille(grille);
                }
                if (verifierVictoire(grille, 'O')) {
                    System.out.println("Le robot a gagné !");
                    break;
                }
            }while(!tour);
            
        }
    } 

    public static boolean jouerTour(Scanner scanner, char[][] grille, String joueur, char jeton) {
        String col;
        int _col;
        try 
		{ 
            do {
            System.out.println(joueur + ", choisissez une colonne (1-7) :");
            col = scanner.next();
            _col = Integer.parseInt(col);
            } while ((_col < 1 || _col > 7 || !colonneValide(grille, _col - 1)));

            jouerCoup(grille, _col - 1, jeton); // col - 1 car l'index commence à 0
            return colonneValide(grille, _col - 1);
		}  
		catch (NumberFormatException e)  
		{ 
			System.out.println("Choisissez un chiffre (1-7) :"); 
		} 
        return false;
    }

    public static boolean jouerTourBis(Scanner scanner, char[][] grille, char jeton) {
            Random random = new Random();
            int _col;
            
            System.out.println("_____________________________\n");
                
            do {
                _col = random.nextInt(7) + 1;
                } while ((_col < 1 || _col > 7 || !colonneValide(grille, _col - 1)));
    
                jouerCoup(grille, _col - 1, jeton); // col - 1 car l'index commence à 0
                return colonneValide(grille, _col - 1);
            
        }

    public static void initGrille(char[][] grille) {
            for (int i = 0; i < grille.length; i++) {
                for (int j = 0; j < grille[i].length; j++) {
                    grille[i][j] = ' '; // Utiliser un espace pour les cellules vides
                }
            }
        }

    public static void afficherGrille(char[][] grille) {
            for (int i = 0; i < grille.length; i++) {
                for (int j = 0; j < grille[i].length; j++) {
                    if (grille[i][j] == 'X') {
                        System.out.print("|" + ANSI_RED + grille[i][j] + ANSI_RESET);
                    } else if (grille[i][j] == 'O') {
                        System.out.print("|" + ANSI_YELLOW + grille[i][j] + ANSI_RESET);
                    } else {
                        System.out.print("|" + grille[i][j]);
                    }
                }
                System.out.println("|");
            }
            // ... reste du code pour afficher les numéros de colonnes
        }

    public static boolean verifierVictoire(char[][] grille, char jeton) {
            // Vérifier horizontalement
            for (int ligne = 0; ligne < grille.length; ligne++) {
                for (int col = 0; col < grille[0].length - 3; col++) {
                    if (grille[ligne][col] == jeton && grille[ligne][col + 1] == jeton && grille[ligne][col + 2] == jeton && grille[ligne][col + 3] == jeton) {
                        return true;
                    }
                }
            }
    
            // Vérifier verticalement
            for (int ligne = 0; ligne < grille.length - 3; ligne++) {
                for (int col = 0; col < grille[0].length; col++) {
                    if (grille[ligne][col] == jeton && grille[ligne + 1][col] == jeton && grille[ligne + 2][col] == jeton && grille[ligne + 3][col] == jeton) {
                        return true;
                    }
                }
            }
    
            // Vérifier diagonalement (haut gauche à bas droite)
            for (int ligne = 0; ligne < grille.length - 3; ligne++) {
                for (int col = 0; col < grille[0].length - 3; col++) {
                    if (grille[ligne][col] == jeton && grille[ligne + 1][col + 1] == jeton && grille[ligne + 2][col + 2] == jeton && grille[ligne + 3][col + 3] == jeton) {
                        return true;
                    }
                }
            }
    
            // Vérifier diagonalement (bas gauche à haut droite)
            for (int ligne = 3; ligne < grille.length; ligne++) {
                for (int col = 0; col < grille[0].length - 3; col++) {
                    if (grille[ligne][col] == jeton && grille[ligne - 1][col + 1] == jeton && grille[ligne - 2][col + 2] == jeton && grille[ligne - 3][col + 3] == jeton) {
                        return true;
                    }
                }
            }
    
            return false;
        }

    public static boolean colonneValide(char[][] grille, int col) {
            return grille[0][col] == ' ';
        }

    public static void jouerCoup(char[][] grille, int col, char jeton) {
            for (int i = grille.length - 1; i >= 0; i--) {
                if (grille[i][col] == ' ') {
                    grille[i][col] = jeton;
                    break;
                }
            }
        }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
}