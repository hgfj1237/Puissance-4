import java.util.Scanner;

public class fo {

    public static void regledejeu() {
        System.out.println("Voici les règles du jeu :");
        System.out.println("Les joueurs doivent faire une ligne de 4 jetons de même couleur.");
    }

    public static void jouerPuissance4SansRobot() {
        Scanner scanner = new Scanner(System.in);
        String joueur1, joueur2;

        System.out.println("Vous jouez au Puissance 4 sans robot.");
        // les noms des joueurs
        System.out.print("Choisissez le nom du joueur 1: ");
        joueur1 = scanner.next();
        System.out.print("Choisissez le nom du joueur 2: ");
        joueur2 = scanner.next();

        System.out.println("_____________________________\n");

        char[][] grille = new char[6][7];
        initGrille(grille);
        boolean finDuJeu = false;
        while (!finDuJeu) {
            // Tour du joueur 1
            jouerTour(scanner, grille, joueur1, 'X'); // Utiliser des caractères pour représenter les jetons
            afficherGrille(grille);
            if (verifierVictoire(grille, 'X')) {
                System.out.println(joueur1 + " a gagné !");
                break;
            }

            // Tour du joueur 2
            jouerTour(scanner, grille, joueur2, 'O');
            afficherGrille(grille);
            if (verifierVictoire(grille, 'O')) {
                System.out.println(joueur2 + " a gagné !");
                break;
            }
        }
    }

    // Méthode pour gérer le tour d'un joueur
    public static void jouerTour(Scanner scanner, char[][] grille, String joueur, char jeton) {
        String col;
        int _col;
        try 
		{ 
            do {
            System.out.println(joueur + ", choisissez une colonne (1-7) :");
            col = scanner.next();
            _col = Integer.parseInt(col);
            } while (((int)_col == _col) && (_col < 1 || _col > 7 || !colonneValide(grille, _col - 1)));
            jouerCoup(grille, _col - 1, jeton); // col - 1 car l'index commence à 0
		}  
		catch (NumberFormatException e)  
		{ 
			System.out.println("Choisissez un chiffre (1-7) :"); 
		} 
        

    }

    // Vérifie si on peut jouer dans la colonne choisie
    public static boolean colonneValide(char[][] grille, int col) {
        return grille[0][col] == ' ';
    }

    // Jouer un coup dans la grille
    public static void jouerCoup(char[][] grille, int col, char jeton) {
        for (int i = grille.length - 1; i >= 0; i--) {
            if (grille[i][col] == ' ') {
                grille[i][col] = jeton;
                break;
            }
        }
    }

    // Ajout des méthodes verifierVictoire, initGrille, et afficherGrille ici...
    // ...
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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";


}

