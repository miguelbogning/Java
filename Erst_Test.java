import java.util.Scanner;

public class Play{  

  static double addieren(double[] nombres){

    double total = 0;

    for(int i = 0; i < nombres.length; i++){

      total += nombres[i];

    }
    return total;
    
  }
  
  static int factoriel(int nummer){

    int result = 1;

    for(int i = 1; i <= nummer; i++ ){

      result *= i;

    }
    return result;

    

  }
  
  static boolean primzahl(int eingabe){

    boolean estpremier = true;

    for(int i = 2; i*i <= eingabe && estpremier; i++){


      if (eingabe % i == 0) {
        estpremier = false;
        break;
      }

    }

    return estpremier;
  }
  
  static int multiplication(int n1){

    int[] tabelle = new int[12];

    for(int i = 1; i <= 12; i++){

      tabelle[i - 1] = n1 * i;

    }

    for(int i = 0; i < tabelle.length; i++){

      System.out.println((i + 1) + " -> "   + tabelle[i]);

    }
    return n1;
  }
  
  static int exposant(int n2, int puissance){

    int result = 1;

    for(int i = 1; i <= puissance; i++){

      result = result * n2;

    }
    System.out.println("Der Result ist " + result);
    return result;
  }



  
  public static void main(String[] args){ 
    Scanner sc = new Scanner(System.in);

    System.out.print("Wie heißt du? ");

    String name = sc.nextLine();
    System.out.println("__Wilkomen beim Menu Kalkulator " + name + " __");

    while (true) {
      
      System.out.println("Hier sind die unterschiedliche optionen. \n1- mehrere Nummer addieren.\n2- Das Factoriel eines Nummers finden.\n3- Prüfen, ob ein nummer eine primzahl ist.\n4- die Multiplication_tabelle eines Nummer geben.\n5-Puissance d'un nombre.\n6- Programm beenden.\nwelche Option wählst du? ");
    
      int Wahl = sc.nextInt();

      switch (Wahl) {
        case 1:

          System.out.println("wie viel nummer willst du addieren? ");
          int zahl = sc.nextInt();

          double[] nombres = new double[zahl]; 

          for(int i = 0; i < zahl; i++){

            System.out.print("Gib das " + (i +1) + " Nummer ein: ");

            nombres[i] = sc.nextDouble();

          }

          System.out.println("Der Result der Addierung ist " + addieren(nombres));

          System.out.println();
          break;
        case 2:

          System.out.print("Gib das Nummer ein: ");
          int nummer = sc.nextInt();
              
          System.out.println("das factoriel ist " + factoriel(nummer));

          System.out.println();
          break;
        
        case 3:

          System.out.print("Gib ein positives nummer ein: ");

          int eingabe = sc.nextInt();

          boolean value = primzahl(eingabe);
          
          if (eingabe == 1) {
            System.out.println("Dieses Nummer ist keine primzahl");
          }
          else if (value == true) {
            System.out.println("dieses Nummer ist eine Primzahl");
          }else{
            System.out.println("dieses Nummer ist keine Primzahl ");
          }
          System.out.println();
          break;
        case 4:

          System.out.println("Gib ein nummer ein: ");

          int n1 = sc.nextInt();
          
          System.out.println(multiplication(n1));
          System.out.println();
          break;
        case 5:
          System.out.print("Gib ein Nummer ein: ");

          int n2 = sc.nextInt();

          System.out.print("a quelle puissance voulez vous eleve ce nombre: ");

          int puissance = sc.nextInt();

          System.out.println(exposant(n2, puissance));
          System.out.println();
          break;
        
        case 6:
          break;

        default:
         break;
          
        }

        if (Wahl == 6) {
          break;
        }

      }
      sc.close();
    }

    
  }




  