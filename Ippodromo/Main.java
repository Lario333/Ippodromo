import java.util.Scanner;

public class Main{
  //Scanner
  static Scanner input = new Scanner (System.in);

  public static void main(String args[]) {
    int spaces = 0 ;
    String[] names = new String[8]; // Array Nomi
    //Nomi
    names[0] = "CORBINO";
    names[1] = "BOTTURI";
    names[2] = "MILANESE";
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
    final int RUNS = 90; // lunghezza del traguardo
    final int TRAGUARDO = 220;

    int intChoose = initialBet();
    String betChoose = names[intChoose - 1]; // Nome della scelta



    for (int x = 0 ; x < RUNS ; x++){      // Numero di volte che le macchine devono andare avanti
      for (int y = 0 ; y < names.length ; y++) {    // Numero di macchine , 8
        int randSpaces = (int)(Math.random() * 3 + 1);
        nameSpaces[y] += randSpaces;
        for(int i = 0 ; i < 3 ; i++) {     // For che crea la macchina singola
          if (i == 0){
            System.out.println( spaceGen( MAXSPACES + nameSpaces[y]) + "***********" + spaceGen(TRAGUARDO - 11 - (MAXSPACES + nameSpaces[y]) ) + "|" );
          } else if (i == 1) {
            System.out.println(names[y] + spaceGen( nameSpaces[y] + MAXSPACES - names[y].length() )+ "***********" +  spaceGen(TRAGUARDO - 11 - (MAXSPACES + nameSpaces[y] ) ) + "|");
          } else {
            System.out.println(spaceGen( MAXSPACES + nameSpaces[y] ) + "***********" + spaceGen(TRAGUARDO - 11 - (MAXSPACES + nameSpaces[y]))+ "|"  );
          }
        }
        System.out.println();
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

    }



  } // main closed

  public static String spaceGen(int num){
    String generatedString = "";
    for ( int i = 0 ; i <= num ; i++){
      generatedString = generatedString + " ";
    }
    return generatedString;
  }

  public static int initialBet() {
    String[] names = new String[8]; // Array Nomi
    //Nomi
    names[0] = "CORBINO";
    names[1] = "BOTTURI";
    names[2] = "MILANESE";
    names[3] = "PUNTA";
    names[4] = "POGGIO";
    names[5] = "MONTEGRANDI";
    names[6] = "FRACCHIA";
    names[7] = "FERRARA";

    int choose = 0;

    System.out.println("============Scommesse============");

    for (int i = 0; i < names.length; i ++){
      System.out.println( (i + 1 ) + "-" + names [i]);
    }

    boolean hasInt = false;

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
