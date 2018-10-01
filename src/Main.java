

public class Main {

    public static void main(String[] args) {

        int[] points = {21,31,66,55,44,33,22,11,65,64,63,62,61,54,53,52,51,43,42,41,32};

        // Opret 2 instanser af et bæger
        Baeger b1 = new Baeger();
        Baeger b2 = new Baeger();

        Spiller s1 = new Spiller("Makrellen");
        Spiller s2 = new Spiller("Blondie");
        Spiller s3 = new Spiller();

        System.out.println(s1.getNavn() + " har " + s1.getLiv() + " liv.");
        System.out.println(s2.getNavn() + " har " + s2.getLiv() + " liv.");
        s3.taelNed();
        System.out.println(s3.getNavn() + " har " + s3.getLiv() + " liv.");

        System.out.println("Bæger1:");
        System.out.println("t1: " + b1.getT1().getSlag());
        System.out.println("t2: " + b1.getT2().getSlag());
        System.out.println("Værdi: " + b1.getBaegerVaerdi());

        System.out.println("Bæger2:");
        System.out.println("t1: " + b2.getT1().getSlag());
        System.out.println("t2: " + b2.getT2().getSlag());
        System.out.println("Værdi: " + b2.getBaegerVaerdi());

        System.out.println("Vinderen har værdien:");
        System.out.println(vinder(b1,b2,points).getBaegerVaerdi());

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
