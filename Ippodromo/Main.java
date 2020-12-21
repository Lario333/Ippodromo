public class Main{
  public static void main(String args[]) {
    int spaces = 0 ;
    String[] names = new String[8]; // Array Nomi
    names[0] = "CORBINO";
    names[1] = "BOTTURI";
    names[2] = "MILANESE";
    names[3] = "PUNTA";
    names[4] = "POGGIO";
    names[5] = "MONTEGRANDI";
    names[6] = "FRACCHIA";
    names[7] = "FERRARA";
    final int MAXSPACES = 11; // Lunghezza del nome più lungo
    final int TRAGUARDO = 50; // lunghezza del traguardo


    for ( int x = 0 ; x < TRAGUARDO ; x++ ){   //spazio massimo a cui la macchina arriva
      int randSpaces = (int)(Math.random() * 3 + 1);
      spaces = spaces + randSpaces;
      for(int i = 0 ; i < 3 ; i++){ //for che stampa la macchina
        if (i == 0){
          System.out.println( spaceGen(MAXSPACES + spaces) + "***********");
        } else if (i == 1) {
          System.out.println(names [0] + spaceGen( spaces + MAXSPACES - names [0].length())+ "***********" );
        } else {
          System.out.println(spaceGen(MAXSPACES + spaces) + "***********");
        }
      }

      try
      {
        Thread.sleep(300);
      }
      catch(InterruptedException e)
      {
        Thread.currentThread().interrupt();
      }

      System.out.print('\u000c');

    }
  }

  public static String spaceGen(int num){
    String generatedString = "";
    for ( int i = 0 ; i <= num ; i++){
      generatedString = generatedString + " ";
    }
    return generatedString;
  }
}
