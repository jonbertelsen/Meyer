import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Runde> runder = new ArrayList<>();
    private static int rundeNummer = 0;


    public Main() {
    }

    public static void main(String[] args) {

        int[] points = {21,31,66,55,44,33,22,11,65,64,63,62,61,54,53,52,51,43,42,41,32};

        Baeger b = new Baeger();
        Spiller s1 = new Spiller();
        Spiller s2 = new Spiller();
        Spiller aktuelSpiller = new Spiller();
        Runde nyRunde = new Runde();

        // ***** Menu ******* //

        int valg = 0;

        while (valg != 9) {

            visHovedMenu();
            valg = getInputNumber("Indtast dit valg: ");


            switch (valg) {
                case 1:
                    // Opret bæger og spillere

                    String s1Navn = getInputString("Indtast navn på spiller 1:");
                    String s2Navn = getInputString("Indtast navn på spiller 2:");
                    s1.setNavn(s1Navn);
                    s2.setNavn(s2Navn);
                    aktuelSpiller = s1;
                    System.out.println("Aktuel spiller: " + aktuelSpiller.getNavn());
                    System.out.println("Nu starter spillet .....");
                    break;
                case 2:
                    System.out.println("Ryst  bæger");
                    rundeNummer++;
                    if (aktuelSpiller == s1) {
                        nyRunde = new Runde(rundeNummer, s1.getNavn());
                    } else
                    {
                        nyRunde = new Runde(rundeNummer, s2.getNavn());
                    }
                    b.ryst();
                    nyRunde.setSlagVaerdi(b.getBaegerVaerdi());
                    break;
                case 3:
                    System.out.println("Bæger:");
                    System.out.println("t1: " + b.getT1().getSlag());
                    System.out.println("t2: " + b.getT2().getSlag());
                    System.out.println("Værdi: " + b.getBaegerVaerdi());
                    break;
                case 4:
                    int melding = getInputNumber("Indtast din melding: ");
                    nyRunde.setBudVaerdi(melding);
                    break;
                case 5:
                    Spiller vinderSpiller = null;
                    System.out.println("Så løftes der:");
                    System.out.println("Bud: " + nyRunde.getBudVaerdi());
                    System.out.println("Reel værdi: " + nyRunde.getSlagVaerdi());
                    if (aktuelSpiller == s1){
                        vinderSpiller = simpelvinder(s1, nyRunde.getBudVaerdi(), s2,nyRunde.getSlagVaerdi());
                        aktuelSpiller = s2;
                    } else{
                        vinderSpiller = simpelvinder(s2, nyRunde.getBudVaerdi(), s1,nyRunde.getSlagVaerdi());
                        aktuelSpiller = s1;
                    }
                    System.out.println("Vinderen af runden er: " + vinderSpiller.getNavn());
                    nyRunde.setVinder(vinderSpiller.getNavn().equals(nyRunde.getSpillerNavn()));
                    nyRunde.setSnyd(nyRunde.getBudVaerdi() != nyRunde.getSlagVaerdi());
                    if (vinderSpiller == s1){
                        s2.taelNed();
                    } else
                    {
                        s1.taelNed();
                    }

                    runder.add(nyRunde);
                    break;
                case 6:
                    System.out.println(s1.getNavn() + " har " + s1.getLiv() + " liv.");
                    System.out.println(s2.getNavn() + " har " + s2.getLiv() + " liv.");
                    break;
                case 7:
                    visRunder();
                    break;
                case 8:
                    gemRunder();
                    break;
                case 9:
                    System.out.println("Tak for denne gang.");
                    break;
                case 10:
                    hentRunder();
                    break;
                default:
                    System.out.println("Den kommando kender jeg ikke. Prøv igen.");
                    break;
            }
        }
    }

    public static void visHovedMenu(){
        System.out.println("************************************************");
        System.out.println("Velkommen til Meyer");
        System.out.println("Menu:");
        System.out.println("1. Start et spil Meyer");
        System.out.println("2. Ryst bæger for spiller");
        System.out.println("3. Vis bæger");
        System.out.println("4. Giv melding");
        System.out.println("5. Løft, check for snyd og opdater stilling");
        System.out.println("6. Vis status for liv.");
        System.out.println("7. Vis alle runder");
        System.out.println("8. Gem alle runder");
        System.out.println("9. Afslut");
        System.out.println("10. Læs fra fil");
    }

    // funktionen spørg brugeren efter input.

        private static int getInputNumber(String s) {

            int svar = 0;

            System.out.print(s);
            svar = Integer.parseInt(scanner.nextLine());
            return svar;
        }

    private static String getInputString(String s) {
        String svar;
        System.out.print(s);
        svar = scanner.nextLine();
        return svar;
    }

    public static Spiller simpelvinder(Spiller s1, int v1, Spiller s2, int v2){

        if (v1 != v2)
            return s2;
        else
            return s1;
    }

    public static Spiller vinder(Spiller s1, int v1, Spiller s2, int v2, int[] points) {

        if (getPointsIndex(points, v1) < getPointsIndex(points,v2)){
            return s1;
        } else {
            return s2;
        }
    }

    public static int getPointsIndex(int[] points, int vaerdi) {
        int i = 0;
        while (vaerdi != points[i]) {
            i++;
        }
        return i;
    }

    public static void visRunder(){
        System.out.println("Alle runder:1");
        for (int i = 0; i < runder.size() ; i++) {
            System.out.println("Runde: " + runder.get(i).getRundeNummer() + ": " + runder.get(i).getSpillerNavn());
        }
    }

    public static void gemRunder(){

        PrintWriter outputStream = null;

        try {

            outputStream = new PrintWriter(new FileWriter("runder.txt"));

            for (int i = 0; i < runder.size() ; i++) {
                outputStream.println("Runde: " + runder.get(i).getRundeNummer() + ": " + runder.get(i).getSpillerNavn());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void hentRunder(){
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("runder.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                System.out.println(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
