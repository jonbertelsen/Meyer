public class Baeger {

    // attributter

    private Terning t1;
    private Terning t2;

    // Metoder

    public Baeger(){
        this.t1 = new Terning();
        this.t2 = new Terning();
    }

    public Terning getT1(){
        return t1;
    }

    public Terning getT2() {
        return t2;
    }

    public void ryst(){
        t1.kastTerning();
        t2.kastTerning();
    }

    public int getBaegerVaerdi(){
        if (t1.getSlag() >= t2.getSlag()){
            return t1.getSlag() * 10 + t2.getSlag();
        } else {
            return t2.getSlag() * 10 + t1.getSlag();
        }
    }
}
