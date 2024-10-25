class BigLiczba{
    double liczba ;
    BigLiczba(){
        this.liczba = 0 ;
    }

    @Override
    public String toString() {
        return "BigLiczba{" +
                "liczba=" + liczba +
                '}';
    }

    public BigLiczba(double liczba) {
        this.liczba = liczba;
    }

    boolean czy_dzieli(double liczba2){
        if((liczba % liczba2) == 0){
            return true;
        }else {
            return false;
        }
    }

    boolean czy_pierwsza(){
        if (liczba <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(liczba); i++) {
            if (liczba % i == 0) {
                return false; // Liczba nie jest pierwsza
            }
        }
        return true ;
    }
}

public class Cw_2_5 {
    public static void main(String[] args) {
        // Tworzenie obiektów klasy BigLiczba
        BigLiczba liczba1 = new BigLiczba(10);
        BigLiczba liczba2 = new BigLiczba(29);
        BigLiczba liczba3 = new BigLiczba(7);

        // Wyświetlanie informacji o liczbach
        System.out.println(liczba1);
        System.out.println(liczba2);
        System.out.println(liczba3);

        // Sprawdzanie, czy liczby dzielą inne liczby
        System.out.println("Czy " + liczba1.liczba + " dzieli 5? " + liczba1.czy_dzieli(5));
        System.out.println("Czy " + liczba1.liczba + " dzieli 2? " + liczba1.czy_dzieli(2));

        // Sprawdzanie, czy liczby są pierwsze
        System.out.println("Czy " + liczba1.liczba + " jest liczbą pierwszą? " + liczba1.czy_pierwsza());
        System.out.println("Czy " + liczba2.liczba + " jest liczbą pierwszą? " + liczba2.czy_pierwsza());
        System.out.println("Czy " + liczba3.liczba + " jest liczbą pierwszą? " + liczba3.czy_pierwsza());
    }
}
