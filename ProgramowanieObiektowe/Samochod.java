package ProgramowanieObiektowe;

public class Samochod{
    private int vMax ;
    private  double paliwoWZbiorniku ;
    private  double zuzycieNa100km ;


    public  Samochod(){
        this.vMax = 180;
        this.paliwoWZbiorniku = 32.5;
        this.zuzycieNa100km = 6.5;

    }
    public Samochod(int vMax, double paliwoWZbiorniku,double zuzycieNa100km){
        this.vMax = vMax;
        this.paliwoWZbiorniku = paliwoWZbiorniku;
        this.zuzycieNa100km = zuzycieNa100km;
    }

    public int getvMax() {
        return vMax;
    }
    public double getPaliwoWZbiorniku() {
        return paliwoWZbiorniku;
    }
    public double getZuzycieNa100km() {
        return zuzycieNa100km;
    }
    public double zasieg(){
        return (paliwoWZbiorniku/zuzycieNa100km)*100;
    }
    public double czasDojazdu(double dystans){
        return dystans/(vMax * 0.75);
    }
    public void zatankuj(double ilePaliwaZatankowano){
        paliwoWZbiorniku += ilePaliwaZatankowano;
    }
    public void trasa(double liczbaKilometrów){
        paliwoWZbiorniku -= (liczbaKilometrów/100)*zuzycieNa100km;
    }



}

