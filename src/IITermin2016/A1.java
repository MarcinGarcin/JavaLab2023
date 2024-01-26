package IITermin2016;

public class A1 {

    double A;
    double B;
    double C;

    private double x1;
    private double x2;
    public A1(double a,double b,double c){
        if(a == 0){
            this.A = (b + c)/2;
        }else{
            this.A = a;
        }
        this.B = b;
        this.C = c;
    }
    public double zwrocWartosc(double x){
        double y = (A * Math.pow(2,x)) + (B * x) + C;
        return y;
    }
    public int liczbaPierwiastkow(){
        int liczbaPierwiastkow = 0 ;
        double delta = Math.pow(2,B) - 4*A*C;
        if(delta > 0){
            liczbaPierwiastkow = 2;
            x1 = (-B-Math.sqrt(delta))/2*A;
            x2 = (-B+Math.sqrt(delta))/2*A;
        } else if (delta == 0) {
            liczbaPierwiastkow = 1;
            x1 = (-B)/2*A;
            x2 = x1;
        }
        else{
            liczbaPierwiastkow = 0;
        }
        return liczbaPierwiastkow;
    }
}
