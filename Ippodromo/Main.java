import java.util.Scanner;

public class Main{
    //Scanner
    static Scanner input = new Scanner (System.in);

    public static void main(String args[]) {
        char insertedText;

        do {
            System.out.print('\u000c');
            int spaces = 0 ;
            String[] names = new String[8]; // Array Nomi
            //Nomi
            names[0] = "CORBINO";
            names[1] = "BOTTURI";
            names[2] = "FIRPO";
            names[3] = "PUNTA";
            names[4] = "POGGIO";
            names[5] = "MONTEGRANDI";
            names[6] = "FRACCHIA";
            names[7] = "FERRARA";

            int[] nameSpaces = new int[8]; // Array spazi
            nameSpaces[0] = 0;
            nameSpaces[1] = 0;
            nameSpaces[2] = 0;
            nameSpaces[3] = 0;
            nameSpaces[4] = 0;
            nameSpaces[5] = 0;
            nameSpaces[6] = 0;
            nameSpaces[7] = 0;

            final int MAXSPACES = 11; // Lunghezza del nome più lungo
            final int TRAGUARDO = 200; // Lunghezza del punto di arrivo

            int intChoose = initialBet();
            String betChoose = names[intChoose - 1]; // Nome della scelta

            int arrivedCarSpaces = 0 ; // Spazi della macchina arrivata
            int secondoCarSpaces = 0; // Spazi della seconda macchina arrivata
            int terzoCarSpaces = 0 ; // Spazi della terza macchina arrivata
            String winner = ""; // String del vincitore
            String secondo = ""; // String del podio
            String terzo = ""; // String del terzo

            while( arrivedCarSpaces < TRAGUARDO - (11 + MAXSPACES) ) {
                for (int y = 0 ; y < names.length ; y++) {    // Numero di macchine , 8
                    int randSpaces = (int)(Math.random() * 3 + 1); // randomizza
                    nameSpaces[y] += randSpaces; // Aggiunge spazi random a se stesso

                    for(int i = 0 ; i < 3 ; i++) {     // For che crea la macchina singola
                        if (i == 0){
                            System.out.println( spaceGen( MAXSPACES + nameSpaces[y]) + "***********" + spaceGen(TRAGUARDO - 11 - (MAXSPACES + nameSpaces[y]) ) + "|" );
                        } else if (i == 1) {
                            System.out.println(names[y] + spaceGen( nameSpaces[y] + MAXSPACES - names[y].length() )+ "***********" +  spaceGen(TRAGUARDO - 11 - (MAXSPACES + nameSpaces[y] ) ) + "|");
                        } else {
                            System.out.println(spaceGen( MAXSPACES + nameSpaces[y] ) + "***********" + spaceGen(TRAGUARDO - 11 - (MAXSPACES + nameSpaces[y]))+ "|"  );
                        }
                    }
                    System.out.println( spaceGen(TRAGUARDO) + "|");
                    for (int x = 1 ; x <= names.length - 1; x++) { //
                        if (y == 0) {
                            if ( x == 1 ) {
                                winner = names[x];
                                arrivedCarSpaces = nameSpaces[x];
                            } else if ( nameSpaces[x - 1] > nameSpaces[x]) {
                                winner = names[x - 1];
                                arrivedCarSpaces = nameSpaces[x - 1];
                            } else if (nameSpaces[x] > nameSpaces[x - 1] ){
                                winner = names[x];
                                arrivedCarSpaces = nameSpaces[x];
                            }
                        } else {
                            if ( nameSpaces[x] > arrivedCarSpaces ){
                                winner = names[x];
                                arrivedCarSpaces = nameSpaces[x];
                            }
                        }
                    } // max closed

                }
                try
                {
                    Thread.sleep(200);
                }
                catch(InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }

                System.out.print('\u000c');



            } // while closing

            // Podio secondo
            for (int i = 1 ; i <= nameSpaces.length - 1; i++){
                if (i == 1){ // Prima volta
                    if ( names[i - 1] != winner ) { // Se il selezionato non è il primo
                        secondoCarSpaces = nameSpaces[i - 1];
                        secondo = names[i - 1];
                    } else {
                        secondoCarSpaces = nameSpaces[i];
                        secondo = names[i];
                    }
                } else {
                    if ( names[i] != winner){
                        if(nameSpaces[i] > secondoCarSpaces ){
                            secondoCarSpaces = nameSpaces[i];
                            secondo = names[i];
                        }
                    }
                }
            } // Secondo for closed

            // Podio terzo
            for (int i = 1 ; i <= nameSpaces.length - 1; i++){
                if (i == 1){ // Prima volta
                    if ( names[i - 1] != winner  ) { // Se il selezionato non è il primo
                        if ( names[i-1] != secondo ){
                            terzoCarSpaces = nameSpaces[i - 1];
                            terzo = names[i - 1];
                        }
                    } else {
                        if ( names[i] != secondo ) {
                            terzoCarSpaces = nameSpaces[i];
                            terzo = names[i];
                        } else {
                            terzoCarSpaces = nameSpaces[i + 1];
                            terzo = names[i + 1];
                        }
                    }
                } else {
                    if (  names[i] != winner   ){
                        if ( names[i] != secondo){
                            if( nameSpaces[i] > terzoCarSpaces ){
                                terzoCarSpaces = nameSpaces[i];
                                terzo = names[i];
                            }
                        }
                    }
                }
            } // Terzo for closed


            int terzoNumChar = terzo.length();    // calcolare gli spazi da mettere nel podio del terzo

            // Stampa dell'intestazione del Podio
            for (int i = 0 ; i < 6 ; i++){
                if (i == 2)
                System.out.println("===============================PODIO===============================");
                else
                System.out.println();
            }
            // stampa del podio
            System.out.println ( spaceGen(10) +  spaceGen(18) + winner );
            System.out.println ( spaceGen(10) + spaceGen(15) + "|^^^^^^^^^^^^^^|" +spaceGen(2) + secondo );
            System.out.println ( spaceGen(10) + spaceGen(2) + terzo + spaceGen( (13 - terzoNumChar) ) + "|              |^^^^^^^^^^^^^^|" );
            System.out.println (spaceGen(10) + "|^^^^^^^^^^^^^^|              |              |");
            System.out.println (spaceGen(10) + "|              |              |              |");
            System.out.println( );

            // Spaziatura
            for (int i = 0 ; i < 3 ;i++)
            System.out.println();

            // controllo della vincita
            for (int i = 0 ; i <= names.length - 1; i++) {
                if ( intChoose - 1 == i ) {
                    if (winner == names[i] ) {
                        System.out.println("Hai vinto la scommessa, ma un euro potevi mettercelo...");
                    }else{
                        System.out.println("Hai perso la scommessa!");
                    }
                }
            }

            // Chiede all'utente se vuole rigiocare
            do {
                System.out.println("\nVuoi rigiocare? S/N");
                insertedText = input.next().charAt(0);
                if ( insertedText != 's' && insertedText != 'n' && insertedText != 'S' && insertedText != 'N' )
                    System.err.println ("Scelta non valida");
            } while( insertedText != 's' && insertedText != 'n' && insertedText != 'S' && insertedText != 'N');

        } while ( insertedText == 's' || insertedText == 'S' );
        System.out.println("\nSei uscito dal gioco");
    } // main closed

    // Generatore di spazi
    public static String spaceGen(int num){
        String generatedString = "";
        for ( int i = 0 ; i < num ; i++){
            generatedString = generatedString + " ";
        }
        return generatedString;
    }
    // Schermata iniziale per la scommessa
    public static int initialBet() {
        String[] names = new String[8]; // Array Nomi
        //Nomi
        names[0] = "CORBINO";
        names[1] = "BOTTURI";
        names[2] = "FIRPO";
        names[3] = "PUNTA";
        names[4] = "POGGIO";
        names[5] = "MONTEGRANDI";
        names[6] = "FRACCHIA";
        names[7] = "FERRARA";

        int choose = 0;

        System.out.println("============Scommesse============\n");


        for (int i = 0; i < names.length; i ++){
            System.out.println( (i + 1 ) + "-" + names [i]);
        }

        boolean hasInt = false;

        System.out.println();

        do {
            System.out.print("Inserire numero su chi puntare: ");
            hasInt = false;
            if ( input.hasNextInt() ){
                hasInt = true;
                choose = input.nextInt();
                if (choose > (names.length) || choose < 1 ){
                    hasInt = false;
                    System.out.println();
                    input.nextLine();
                    continue;
                }
            } else {
                System.err.print ("Scelta non valida");
                hasInt = false;
                System.out.println();
                input.nextLine();
                continue;
            }
        } while ( hasInt == false );

        return choose;
    }
}
