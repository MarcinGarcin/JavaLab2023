package IITermin2012;


class Samochod{

    String marka;
    int zuzyciePaliwa;

    public Samochod(){
        this.marka = "";
        this.zuzyciePaliwa = 0;
    }
    public Samochod(String marka, int zużyciePaliwa){
        this.marka = marka;
        this.zuzyciePaliwa = zużyciePaliwa;
    }
    public double Koszt(int kilometry, int cena){
        double koszt = (kilometry/100)*zuzyciePaliwa*cena;
        System.out.println(marka);
        System.out.println(zuzyciePaliwa);
        return koszt;
    }

}
class Autobus extends Samochod{
    int IMiejsc;
    public Autobus(String Marka, int zużyciePaliwa, int IMiejsc){
        this.marka = Marka;
        this.zuzyciePaliwa = zużyciePaliwa;
        this.IMiejsc = IMiejsc;
    }
    public void wypiszDane(){
        System.out.println(marka);
        System.out.println(zuzyciePaliwa);
        System.out.println(IMiejsc);
    }
}
class Ciezarowka extends Samochod{
    int nosnosc;
    public Ciezarowka(String Marka, int zużyciePaliwa, int nosnosc){
        this.marka = Marka;
        this.zuzyciePaliwa = zużyciePaliwa;
        this.nosnosc = nosnosc;
    }
    public void wypiszDane(){
        System.out.println(marka);
        System.out.println(zuzyciePaliwa);
        System.out.println(nosnosc);
    }

}
public class Zad_A3{
    public static void main(String[] args) {
        Samochod man = new Samochod();
        man.Koszt(200,6);
    }
}


