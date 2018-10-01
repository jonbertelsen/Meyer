import java.util.Random;

public class Terning {

    // Attributter

    private int slag;
    private final int SIDER = 6;

    private Random rnd = new Random();

    // Metoder

    public Terning(){
        this.slag = rnd.nextInt(SIDER) + 1;
    }

    public int getSlag(){
        return slag;
    }

    public void kastTerning(){
        slag = rnd.nextInt(SIDER) + 1;
    }

    public String visTerning(){
        String terningTekst = "Slag: " + slag;
        return terningTekst;
    }


}
