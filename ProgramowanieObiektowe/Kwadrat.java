package ProgramowanieObiektowe;

public class Kwadrat implements Figura{

    private double bok;

    public Kwadrat(){
        this.bok = 3;
    }
    public Kwadrat(double bok){
        this.bok = bok;
    }

    @Override
    public double pole() {
        return Math.pow(bok,2);
    }

    @Override
    public double obwod() {
        return bok*4;
    }
}
