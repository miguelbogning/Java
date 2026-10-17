import java.util.Arrays;
import java.util.Scanner;

public class EingabeSpiel extends Spiel {


    private String[] benutzerEingaben;
    private int eingabenAnzahl;

    public  EingabeSpiel(String wortZuErraten){

        super(wortZuErraten);
        this.eingabenAnzahl = 0;
        this.benutzerEingaben = new String[20]; //20 ist die Anzahl von zugelassenen Eingaben
        Arrays.fill(this.benutzerEingaben, "");

    }

    public void benutzerEingabenSetter(int index, String buchstabeEinzufügen){

        benutzerEingaben[index] = buchstabeEinzufügen;

    }



    public String benutzerEingabeEntgegennehmen(Scanner scanner){

            String vermutung;
            while (true) {

                    System.out.println("Geben Sie Ihre Vermutung ein:");           
                    vermutung = scanner.next();
                
                    if (vermutung.length() > 1) {
                        System.out.println("Bitte! Geben Sie nur einen Buchstaben ein.");    
                    }else {

                        char kleinenBuchstaben = vermutung.charAt(0);
                        if (kleinenBuchstaben >= 65 && kleinenBuchstaben <= 90) {
                            System.out.println("Bitte in KleinBuchstaben eingeben.");
                        }else if (kleinenBuchstaben >= 97 && kleinenBuchstaben <= 122) {
                            break;
                        }else{
                            System.out.println("Bitte, ein gültiges Zeichen eingeben.");
                        }

                    }

            }
            

            return vermutung;

    }

    public  boolean einmaligeEingabeSicherstellen(String vermutung){


        if (Arrays.asList(this.verborgenesWort).contains(vermutung)) {
            return false;
        }


        for (int i = 0; i < this.benutzerEingaben.length; i++) {
         
            if (this.benutzerEingaben[i].equals(vermutung)) {
                return false;
            }

        }

        this.eingabenAnzahl++;
        eingegebeneBuchstaben(vermutung);

        return true;

    }


    public void eingegebeneBuchstaben(String vermutung){

        this.benutzerEingaben[this.eingabenAnzahl - 1 ] = vermutung;

    }

    @Override
    public void playGame( Scanner scanner) {
        
         boolean spielFortsetzen = true;
        int versuche = 0;

          spielSchleife:
        while (spielFortsetzen) {


            maskeAnzeigen();
             String vermutung = benutzerEingabeEntgegennehmen(scanner);

            boolean istErsteEingabe = einmaligeEingabeSicherstellen(vermutung);
            super.benutzerEingabenVergleichen(vermutung, istErsteEingabe);
            boolean istVersucheErfolgreich = super.ergebnisAnzeigen(istErsteEingabe);

           if (istErsteEingabe && !istVersucheErfolgreich) {
                if (super.falscheVersuche > 8) {
                    displayHint();
                } else if (super.falscheVersuche > 4) {
                    super.displayHint();
                }
            }

            if (istErsteEingabe) {
               versuche++; 
            }
            

            if (super.zielWortgefunden()) {
                    
                System.out.println("Super!! Sie haben das Wort gefunden.");
                spielFortsetzen = false;
                continue;    

            }



            if (versuche == 20) {
                System.out.println("Leider haben Sie das Wort mit den erlaubten Versuchen nicht erraten.");
                spielFortsetzen = false;
            }

            else if (versuche % 3 == 0 && istErsteEingabe) {
                
                while (true) {
                    
                    System.out.println("Möchten Sie das Spiel fortsetzen? (ja/nein)");
                    String antwort = scanner.next();

                    if (antwort.equalsIgnoreCase("nein")) {
                        System.out.println("Danke für die Teilnahme.");
                        break spielSchleife;

                    }else if (antwort.equalsIgnoreCase("ja")) {
                        break;

                    }else{

                        System.out.println("Bitte, antworten Sie nur mit \"ja\" oder \"nein\".");

                    }


                }


            }


            
        }



    

         
    }



}
