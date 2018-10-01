public class Spiller {

    // Attributter

    private String navn;
    private int liv;

    // Metoder

    public Spiller(){
        this.navn = "Jønke";
        this.liv = 6;
    }

    public Spiller(String navn){
          this.navn = navn;
          this.liv = 6;
    }

    // Metoder

    public void taelNed(){
        liv--;
    }

    public int getLiv() {
        return liv;
    }

    public String getNavn() {
        return navn;
    }
}
