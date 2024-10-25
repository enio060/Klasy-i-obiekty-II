class Wektor{
    double x;
    double y;
    double z;
    Wektor(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    Wektor(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Wektor{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    Wektor dodawanie(Wektor wektor){
        return new Wektor(wektor.x + x , wektor.y + y, wektor.z + z) ;
    }

    Wektor odejmowanie(Wektor wektor){
        return new Wektor(this.x - wektor.x, this.y - wektor.y, this.z - wektor.z);
    }

    Wektor mnozenie_wektora_przez_skalar(int skalar){
        return new Wektor(x * skalar , y * skalar, z * skalar) ;
    }

    double Iloczyn_skalarny(Wektor wektor){
        return wektor.x * x + wektor.y * y + wektor.z * z;
    }

    Wektor iloczyn_wektorowy(Wektor wektor){
         return new Wektor(y * wektor.z - z * wektor.y, z * wektor.x - x * wektor.z , x * wektor.y - y * wektor.x) ;
    }

    public double dlugosc_wektora(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    Wektor wektor_unormowany(){
        double len = dlugosc_wektora() ;
        return new Wektor(x / len, y / len , z / len ) ;
    }

    public double kat_miedzy_wektorami(Wektor wektor1){
        double licznik = Iloczyn_skalarny(wektor1);
        double mainownik = dlugosc_wektora() * wektor1.dlugosc_wektora();
        double coskata = licznik / mainownik;
        coskata = Math.max(-1.0, Math.min(1.0, coskata));
        return  Math.acos(coskata) ;
    }

    Wektor projekcja_wektora(Wektor wektor) {
        double iloczynSkalarny = Iloczyn_skalarny(wektor);
        double dlugoscB2 = wektor.dlugosc_wektora() * wektor.dlugosc_wektora();
        double skalar = iloczynSkalarny / dlugoscB2;

        return new Wektor(wektor.x * skalar, wektor.y * skalar, wektor.z * skalar);
    }

}


public class Cw_2_3 {
    public static void main(String[] args) {
        // Tworzenie wektorów
        Wektor wektor1 = new Wektor(1, 2, 3);
        Wektor wektor2 = new Wektor(4, 5, 6);

        // Dodawanie wektorów
        Wektor wektorDodany = wektor1.dodawanie(wektor2);
        System.out.println("Dodawanie: " + wektorDodany);

        // Odejmowanie wektorów
        Wektor wektorOdejmowany = wektor1.odejmowanie(wektor2);
        System.out.println("Odejmowanie: " + wektorOdejmowany);

        // Mnożenie wektora przez skalar
        Wektor wektorPomnozony = wektor1.mnozenie_wektora_przez_skalar(2);
        System.out.println("Mnożenie przez skalar: " + wektorPomnozony);

        // Iloczyn skalarny
        double iloczynSkalarny = wektor1.Iloczyn_skalarny(wektor2);
        System.out.println("Iloczyn skalarny: " + iloczynSkalarny);

        // Iloczyn wektorowy
        Wektor iloczynWektorowy = wektor1.iloczyn_wektorowy(wektor2);
        System.out.println("Iloczyn wektorowy: " + iloczynWektorowy);

        // Długość wektora
        double dlugosc = wektor1.dlugosc_wektora();
        System.out.println("Długość wektora 1: " + dlugosc);

        // Wektor unormowany
        Wektor wektorUnormowany = wektor1.wektor_unormowany();
        System.out.println("Wektor unormowany: " + wektorUnormowany);

        // Kąt między wektorami
        double kat = wektor1.kat_miedzy_wektorami(wektor2);
        System.out.println("Kąt między wektorami: " + Math.toDegrees(kat) + " stopni");

        // Projekcja wektora
        Wektor projekcja = wektor1.projekcja_wektora(wektor2);
        System.out.println("Projekcja wektora A na B: " + projekcja);
    }
}
