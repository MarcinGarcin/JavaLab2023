package ProgramowanieObiektowe;

public class Kolo implements Figura {
    private double promien;

    public Kolo(){
        this.promien = 2;
    }
    public Kolo(double promien){
        this.promien = promien;
    }

    @Override
    public double pole() {
        return Math.PI*Math.pow(promien,2);
    }

    @Override
    public double obwod() {
        return 2*Math.PI*promien;
    }

}
