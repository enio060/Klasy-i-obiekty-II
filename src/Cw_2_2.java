class Liczby_zespolone{
    int cr;
    int cu;
    Liczby_zespolone(){
        this.cr = 0;
        this.cu = 0;
    }
    Liczby_zespolone(int cr,int cu){
        this.cr = cr;
        this.cu = cu;
    }

    @Override
    public String toString(){
        return  cr + " + " + cu + "i" ;
    }

    Liczby_zespolone plus(Liczby_zespolone liczba){
        int New_cr = cr + liczba.cr ;
        int New_cu = cu + liczba.cu ;
        Liczby_zespolone nowa = new Liczby_zespolone(New_cr,New_cu);
        return nowa ;
    }

    Liczby_zespolone odjac(Liczby_zespolone liczba){
        int New_cr = cr - liczba.cr ;
        int New_cu = cu - liczba.cu ;
        Liczby_zespolone nowa = new Liczby_zespolone(New_cr,New_cu);
        return nowa ;
    }
    Liczby_zespolone mnozenie(Liczby_zespolone liczba){
        int New_cr = cr * liczba.cr - cu * liczba.cu ;
        int New_cu = cr * liczba.cu + cr * liczba.cr;
        Liczby_zespolone nowa = new Liczby_zespolone(New_cr,New_cu);
        return nowa;
    }

    Liczby_zespolone dzielenie(Liczby_zespolone liczba){
        int mianownik = liczba.cr * liczba.cr + liczba.cu * liczba.cu;
        if(mianownik == 0){
            throw new ArithmeticException("Nie można dzielić przez zero!");
        }else{
            int new_cr = (cr * liczba.cr + cu * liczba.cu);
            int new_cu = (cu * liczba.cr + cr * liczba.cu);
            return new Liczby_zespolone(new_cr,new_cu);
        }
    }

}

public class Cw_2_2 {
    public static void main(String[] args) {
        Liczby_zespolone z1 = new Liczby_zespolone(3, 2);
        Liczby_zespolone z2 = new Liczby_zespolone(1, 7);

        Liczby_zespolone wynikDodawanie = z1.plus(z2);
        System.out.println("Dodawanie: " + wynikDodawanie);

        Liczby_zespolone wynikOdejmowanie = z1.odjac(z2);
        System.out.println("Odejmowanie: " + wynikOdejmowanie);

        Liczby_zespolone wynikMnozenie = z1.mnozenie(z2);
        System.out.println("Mnożenie: " + wynikMnozenie);

        Liczby_zespolone wynikDzielenie = z1.dzielenie(z2);
        System.out.println("Dzielenie: " + wynikDzielenie);
    }
}
