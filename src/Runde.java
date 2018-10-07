public class Runde {

    private int rundeNummer = 0;
    private String spillerNavn = "";
    private int slagVaerdi = 0;
    private int budVaerdi = 0;
    private boolean snyd = false;
    private boolean vinder = false;

    // Constructor

    public Runde(int rundeNummer, String spillerNavn) {
        this.rundeNummer = rundeNummer;
        this.spillerNavn = spillerNavn;
    }

    public Runde(int rundeNummer) {
        this.rundeNummer = rundeNummer;
        this.spillerNavn = spillerNavn;
    }

    public Runde() {
    }

    // Getters and Setters

    public boolean isSnyd() {
        return snyd;
    }

    public void setSnyd(boolean snyd) {
        this.snyd = snyd;
    }

    public boolean isVinder() {
        return vinder;
    }

    public void setVinder(boolean vinder) {
        this.vinder = vinder;
    }

    public int getRundeNummer() {
        return rundeNummer;
    }

    public void setRundeNummer(int rundeNummer) {
        this.rundeNummer = rundeNummer;
    }

    public String getSpillerNavn() {
        return spillerNavn;
    }

    public void setSpillerNavn(String spillerNavn) {
        this.spillerNavn = spillerNavn;
    }

    public int getSlagVaerdi() {
        return slagVaerdi;
    }

    public void setSlagVaerdi(int slagVaerdi) {
        this.slagVaerdi = slagVaerdi;
    }

    public int getBudVaerdi() {
        return budVaerdi;
    }

    public void setBudVaerdi(int budVaerdi) {
        this.budVaerdi = budVaerdi;
    }
}
