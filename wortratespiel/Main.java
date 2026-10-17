
import java.util.Random;
import java.util.Scanner;

public class Main {





    public  static void  main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new  Random();

       String[] wortSammlung = {"pinguin", "zitrone", "vulkan", "teppich", "flasche",
                         "schiff", "kerze", "tiger", "bibliothek", "schokolade"};           

        String wortZuErraten = wortSammlung[random.nextInt(wortSammlung.length)];

        System.out.println("=== WORTRATESPIEL ===");
        System.out.println("Ein Wort wurde zufällig ausgewählt. Jeder Unterstrich _ steht für einen Buchstaben.");
        System.out.println();
        System.out.println("Regeln:");
        System.out.println("1. Geben Sie pro Runde genau einen Kleinbuchstaben ein (a-z).");
        System.out.println("2. Ein Buchstabe, den Sie schon eingegeben haben, zählt nicht als neuer Versuch.");
        System.out.println("3. Sie haben höchstens 20 Versuche.");
        System.out.println("4. Nach jeweils 3 Versuchen können Sie entscheiden, ob Sie weiterspielen.");
        System.out.println("5. Nach mehreren falschen Versuchen bekommen Sie Hinweise.");
        System.out.println();
        System.out.println("Viel Erfolg!");
        System.out.println();

        AdvancedSpiel spiel = new  AdvancedSpiel(wortZuErraten);

        System.out.println("Versuchen Sie das Wort zu erraten!");
        

       spiel.playGame(scanner);
        

        scanner.close();
    } 
}   