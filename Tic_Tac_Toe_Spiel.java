import java.util.Scanner;


public class Tic_Tac_Toe_Spiel{

    static void anzeige_brett(String [][] arr){

        System.out.println(" |---|---|---|");

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){

               System.out.print( " | " + arr[i][j]);

            }
            System.out.println(" |");
            System.out.println(" |-----------|");
        }


    } 




    static void brett_initialisierung(String[][] arr){

        int a = 1;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){

                arr[i][j] = String.valueOf(a);
                a++;

            }
        }





    }






    static boolean result_überprüfung(String[][] arr){
        boolean prüfer = false;
        int n =0;
        int m = 0;

        if (arr[m][n + 2].equals(arr[m + 1][n + 1]) &&  arr[m][n + 2].equals(arr[m + 2][n]) ){

            prüfer = true;
            return prüfer;

        }else{
            prüfer = false;
        } 


        while (n < 3) {
            
            for(int j = 0; j < 2; j++){

                if (arr[n][j].equals(arr[n][j + 1]) ) {

                    prüfer = true;
                    

                }else{
                    prüfer = false;
                    break;
                }
            }    
            
            if (prüfer == false) {
                n++;
            }else{
                return prüfer;
            }


        }

        while (m < 3) {
            
             for(int i = 0; i < 2; i++){

                if (arr[i][m].equals(arr[i + 1][m]) ) {
                    
                    prüfer = true;

                }else{

                    prüfer = false;
                    break;
                }    

            }

            if (prüfer == false) {
                m++;
            }else{
                return prüfer;
            }


        }

        for(int i = 0; i < 2; i++){

            if (arr[i][i].equals(arr[i + 1][i + 1])) {
                prüfer = true;
            }else{
                prüfer = false;
                break;
            }
            
            if (i == 1) {
                return prüfer;
            }

        }

       return prüfer;
    }






    static void spiel_runde(String[][] arr, Scanner sc, String zeichen, int spieler){


        while (true) {
            
            boolean gute_stelle = false;

            System.out.print("Spieler " + spieler + " : in welcher Zelle willst du "  + zeichen + " platzieren: ");
            String stelle = sc.next();


                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){

                        if (arr[i][j].equals(stelle)){
                            arr[i][j] = zeichen;
                            gute_stelle = true;
                            break;
                        }

                    }
                    if (gute_stelle == true) {
                        break;
                    }
                }  

                if (gute_stelle == false) {

                   System.out.println("Die eingegebene Stelle ist schon besetzt," +
                                        "oder Die eingegebene Stelle entspricht nicht den Nummern des Brettes. \n Bitte wiederholen");

                    
                }else{

                    anzeige_brett(arr);
                    break;

                }

                                        



        }






    }






    public static void main(String [] agrs){

        Scanner sc = new Scanner(System.in);
        int round = 0;

        System.out.println("Willkommen bei dem Tic-Tac-Toe-Spiel"
            + "\n-hier sind die Regeln:"
            + "\n-Beide Spieler wählen entweder X oder O , um Ihre Zelle  zu markieren"
            + "\n-es wird ein 3*3 Gitter geben , wobei jeder der 9 Zellen eine Zahl zugeordnet ist."
            + "\n-Der X wählende Spieler beginnt das Spiel und dafür gibt e die Zellennummer ein, in der er das X platzieren möchte"
            + "\n-danach spielen O und X abwechselnd;bis einer der beiden gewinnt"
            + "\n-Sobald einer der beiden Spieler eine Zeile/Spalte/Diagonale vollständig mit seinem Symbol(X/O) gefülllt hat,gewinnt er und das Spiel endet"
            + "\n-wenn keiner der beiden Spiler gewinnt, spricht man von einem Unentschieden"
        
        );

        String[][] arr = new String[3][3];

        brett_initialisierung(arr);


        anzeige_brett(arr);

        boolean spiel_ende = false;

        System.out.println();
        System.out.println("Wähle 0 zur Beendung des Programms");
        System.out.println();
            
       
           
        while (true) {

            if (spiel_ende == true) {

                spiel_ende = false;

                round =0;
                System.out.print("\nWollen Sie nochmal spielen?(j/N): ");
                String antwort = sc.next();

                if (!"j".equalsIgnoreCase(antwort) ) {
                    break;
                
                }
                
                
            }



            System.out.print("Wähle zwischem x und o ");
            String wahl = sc.next();

            if ("0".equals(wahl)){
                        
                break;
            }

            if ("o".equals(wahl)) {
                
                System.out.println("du bist der zweite Spieler");
                System.out.println();

            }

            if ("o".equals(wahl) || "x".equals(wahl)) {
                
                if ("x".equalsIgnoreCase(wahl)) {
                    System.out.println("du bist der erste Spieler");
                    System.out.println();
                }





                    String zeichen = "X";
                    int spieler = 1;
                    String zeichen_2 = "O";
                    int spieler_2 = 2;

                    while (true) {
        

                        spiel_runde(arr, sc, zeichen, spieler);
                          
                        round += 1;
                                
                        boolean ergebnis  =  result_überprüfung(arr);

                        if (ergebnis == true){
                            System.out.println("Der erste Spieler hat gewonnen!\n    ___Glückwunsch___");

                            spiel_ende = true;
                            brett_initialisierung(arr);

                            break;
                            
                        }

                         if (round == 5 && ergebnis == false) {
                            System.out.println("Leider schafft es niemand, das Spiel zu gewinnen.");
                            spiel_ende = true;
                            brett_initialisierung(arr);
                            break;
                        }

                       
                        

                        spiel_runde(arr, sc, zeichen_2, spieler_2);


                        boolean ergebnis_2  = result_überprüfung(arr);
                                
                        if (ergebnis_2 == true){
                            System.out.println("Der zweite Spieler hat gewonnen!\n      ___Glückwunsch___");
                            spiel_ende = true;
                            brett_initialisierung(arr);
                            break;
                                    
                        }


                    }

            }else{

                System.out.println("ungültige Option.");

            }
    

        }

        sc.close();
    }




}
    

