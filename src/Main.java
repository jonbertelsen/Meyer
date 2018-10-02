import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] points = {21,31,66,55,44,33,22,11,65,64,63,62,61,54,53,52,51,43,42,41,32};

        Baeger b1 = new Baeger();
        Baeger b2 = new Baeger();
        Spiller s1 = new Spiller();
        Spiller s2 = new Spiller();

        // ***** Menu ******* //

        int valg = 0;

        while (valg != 9) {

            visHovedMenu();
            valg = getInputNumber("Indtast dit valg: ");

            switch (valg) {
                case 1:
                    // Opret 2 instanser af et bæger

                    String s1Navn = getInputString("Indtast navn på spiller 1:");
                    String s2Navn = getInputString("Indtast navn på spiller 2:");
                    s1.setNavn(s1Navn);
                    s2.setNavn(s2Navn);
                    System.out.println("Nu starter spillet .....");
                    break;
                case 2:
                    System.out.println("Ryst for spiller 1");
                    b1.ryst();
                    break;
                case 3:
                    System.out.println("Bæger1:");
                    System.out.println("t1: " + b1.getT1().getSlag());
                    System.out.println("t2: " + b1.getT2().getSlag());
                    break;
                case 4:
                    System.out.println("Ryst for spiller 2");
                    b2.ryst();
                    break;
                case 5:
                    System.out.println("Bæger2:");
                    System.out.println("t1: " + b2.getT1().getSlag());
                    System.out.println("t2: " + b2.getT2().getSlag());
                    break;
                case 6:
                    System.out.println("Vinderen har værdien:");
                    System.out.println(vinder(b1, b2, points).getBaegerVaerdi());
                    System.out.print("Og det var ");
                    if (vinder(b1, b2, points).getBaegerVaerdi() == b1.getBaegerVaerdi()) {
                        System.out.println(s1.getNavn() + " der vandt runden.");
                        s2.taelNed();
                    } else {
                        System.out.println(s2.getNavn() + " der vandt runden");
                        s1.taelNed();
                    }
                    break;
                case 7:
                    System.out.println(s1.getNavn() + " har " + s1.getLiv() + " liv.");
                    System.out.println(s2.getNavn() + " har " + s2.getLiv() + " liv.");
                    break;
                case 9:
                    System.out.println("Tak for denne gang.");
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
        System.out.println("2. Ryst bæger for spiller 1");
        System.out.println("3. Vis bæger 1");
        System.out.println("4. Ryst bæger for spiller 2");
        System.out.println("5. Vis bæger 2");
        System.out.println("6. Afgør resultat for runde og juster liv-terning");
        System.out.println("7. Vis status for liv.");
        System.out.println("9. Afslut");
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

    public static Baeger vinder(Baeger b1, Baeger b2, int[] points) {
        int v1 = b1.getBaegerVaerdi();
        int v2 = b2.getBaegerVaerdi();

        if (getPointsIndex(points, v1) < getPointsIndex(points,v2)){
            return b1;
        } else {
            return b2;
        }
    }

    public static int getPointsIndex(int[] points, int vaerdi) {
        int i = 0;
        while (vaerdi != points[i]) {
            i++;
        }
        return i;
    }


}
