
package server;


public class PonudaPrakse {
    private int trPrakse;
    private String grad;
    private double plata;

    public PonudaPrakse(int trPrakse, String grad, double plata) {
        this.trPrakse = trPrakse;
        this.grad = grad;
        this.plata = plata;
    }

    public int getTrPrakse() {
        return trPrakse;
    }

    public String getGrad() {
        return grad;
    }

    public double getPlata() {
        return plata;
    }

    @Override
    public String toString() {
        return "PonudaPrakse{" + "trajanje=" + trPrakse + ", grad=" + grad + ", plata=" + plata + '}';
    }
    
            
}
