import java.util.Scanner;

public class Spiel {

   protected String zielWort;
    protected String[] verborgenesWort;
    protected int zähler;
    protected int falscheVersuche;
     


    public Spiel(String wortZuErraten){

        this.zielWort = wortZuErraten;
        this.verborgenesWort = wortMitVerborgenenBuchstaben();
        this.zähler =0;
        this.falscheVersuche = 0;

    }




     protected  String[] wortMitVerborgenenBuchstaben(){

        String[] leerebuchstabeDesWortes = new String[this.zielWort.length()];

        for (int i = 0; i < leerebuchstabeDesWortes.length; i++) {
            
            leerebuchstabeDesWortes[i] ="_";

        }

        return  leerebuchstabeDesWortes;

    } 

    public void benutzerEingabenVergleichen(String vermutung, boolean esrtesEingabe){

        

        if (esrtesEingabe == true) {

            
            for (int i = 0; i < this.zielWort.length(); i++) {
                
                if (vermutung.equals(String.valueOf(this.zielWort.charAt(i))) ) {
                        this.zähler++;
                        this.verborgenesWort[i] = vermutung;
                        
                    }
            }
            
        }

    }

    protected void maskeAnzeigen() {
        System.out.println(String.join(" ", this.verborgenesWort));
    }


    public void falscheVersuchezaehlen(){

        this.falscheVersuche++;

    }


    protected void buchstabeAufdecken(int position) {
        String buchstabe = String.valueOf(this.zielWort.charAt(position));
        for (int j = 0; j < this.zielWort.length(); j++) {
            if (String.valueOf(this.zielWort.charAt(j)).equals(buchstabe)) {
                this.verborgenesWort[j] = buchstabe;
            }
        }
    }



    public boolean ergebnisAnzeigen(boolean esrtesEingabe){

        if (this.zähler > 0) {

    
            System.out.println("Prima! Ihre Vermutung ist richtig.");
  
            this.zähler = 0;

            return true; // bedeutet, dass kein Hinweis soll gegeben werden.

        }else if (!esrtesEingabe) {
            System.out.println("Sie haben schon diesen Buchstaben eingegeben.");
            return false; // bedeutet, dass kein Hinweis gegeben werden soll.
        }

        System.out.println("Schade, falsche Vermutung.");
        falscheVersuchezaehlen();

        return false;
        

    }


    public boolean zielWortgefunden(){

       String erratenesWort = "";

       for (int i = 0; i < this.verborgenesWort.length; i++) {
        
           erratenesWort += this.verborgenesWort[i];

       }

       if (erratenesWort.equals(this.zielWort)) {
            return true;
       }

       return false;
    }

    public void displayHint(){


        for (int i = 0; i < this.verborgenesWort.length; i++) {
             if (this.verborgenesWort[i].equals("_")) {
                        
                    System.out.println("Als kleiner Hinweis wird ein Buchsatbe aufgedeckt. Nutzen Sie ihn!");
                    buchstabeAufdecken(i);
                    break;
            }           
        }
                   
                        

                    
                

               
           
    }


    public void playGame( Scanner scanner){

       


    }

   
}
