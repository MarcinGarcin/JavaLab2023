package ProgramowanieObiektowe;

public class Rational {
    private int licznik;
    private int mianownik;
    public Rational(){
        this.licznik = 1;
        this.mianownik = 2;
    }
    public Rational(int licznik,int mianownik){
        if(mianownik == 0){
            throw new IllegalArgumentException("Mianownik nie może być równy 0");
        }
        this.licznik = licznik;
        this.mianownik = mianownik;
    }
    public Rational add(Rational arg){
        int nowyLicznik = (this.licznik * arg.mianownik) + (arg.licznik * this.mianownik);
        int nowyMianownik = this.mianownik * arg.mianownik;
        int nwd = najwiekszyWspolnyDzielnik(nowyLicznik,nowyMianownik);
        return new Rational(nowyLicznik/nwd,nowyMianownik/nwd);
    }
    public Rational mul(Rational arg){
        int nowyLicznik = this.licznik * arg.licznik ;
        int nowyMianownik = this.mianownik * arg.mianownik;
        int nwd = najwiekszyWspolnyDzielnik(nowyLicznik,nowyMianownik);
        return new Rational(nowyLicznik/nwd,nowyMianownik/nwd);
    }
    public Rational sub(Rational arg){
        int nowyLicznik = this.licznik * arg.mianownik - arg.licznik * this.mianownik;
        int nowyMianownik = this.mianownik * arg.mianownik;
        int nwd = najwiekszyWspolnyDzielnik(nowyLicznik,nowyMianownik);
        return new Rational(nowyLicznik/nwd,nowyMianownik/nwd);
    }
    public Rational div(Rational arg){
        int nowyLicznik = this.licznik * arg.mianownik;
        int nowyMianownik = this.mianownik * arg.mianownik;
        int nwd = najwiekszyWspolnyDzielnik(nowyLicznik,nowyMianownik);
        return new Rational(nowyLicznik/nwd,nowyMianownik/nwd);
    }
    public boolean equals(Rational arg) {
        boolean tmp = false;
        if(this.licznik/this.mianownik==arg.licznik/ arg.mianownik){
            return true;
        }
        else
            return false;
    }
    public int compareTo(Rational arg) {
        int roznica = this.licznik * arg.mianownik - arg.licznik * this.mianownik;
        return Integer.compare(roznica, 0);
    }
    public String toString(){
        if(mianownik == 1){
            return Integer.toString(licznik);
        }
        else
            return ( licznik+ "/" + mianownik);
    }
    // funkcja obliczająca największy wspólny dzielnik
    public int najwiekszyWspolnyDzielnik(int a, int b){
        if (a == 0)
            return b;
        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
        }

}
