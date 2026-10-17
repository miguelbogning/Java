import java.util.Random;

public class AdvancedSpiel extends EingabeSpiel {



    public AdvancedSpiel(String wortZuErraten){

        super(wortZuErraten);

    }


    @Override
    public void displayHint(){

        Random random = new  Random();

         int anzahlAnLerrZeichen = 0;

            for (String buchstabe : verborgenesWort) {

                if (buchstabe.equals("_")) {
                    anzahlAnLerrZeichen++;
                }
                
            }

            if (anzahlAnLerrZeichen > 2) {
                

                while (true) {

                    int i = random.nextInt(verborgenesWort.length);

                    if (verborgenesWort[i].equals("_")) {
                        
                         System.out.println("Als kleiner Hinweis wird ein Buchsatbe aufgedeckt. Nutzen Sie ihn!");
                        

                       buchstabeAufdecken(i);
                        break;

                    }
                }

               
            
            }else if (anzahlAnLerrZeichen == 2) {
                System.out.println("Es fehlen nur noch zwei Buchstaben. Sie sind fast am Ziel!");
            }else if (anzahlAnLerrZeichen == 1) {
                System.out.println("Nur noch ein Buchstabe fehlt!!");
            }

                

            
    }


}
