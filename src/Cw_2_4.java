class WielomianCzwartegoStopnia{
    double a ;
    double b ;
    double c ;
    double d ;
    double e ;

    WielomianCzwartegoStopnia(){
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public WielomianCzwartegoStopnia(double a, double b, double c, double d, double e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    @Override
    public String toString() {
        return "WielomianCzwartegoStopnia{" + a + "x^4 + " + b + "x^3 + " + c + "x^2 + " + d +"x + " + e + " }";
    }
}

class WielomianKwadratowy{
    double a ;
    double b ;
    double c ;

    WielomianKwadratowy(){
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public WielomianKwadratowy(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "WielomianKwadratowy{" + a + "x^2 + " + b + "x + " + c + "}";
    }

    WielomianKwadratowy dodawanie(WielomianKwadratowy H){
        return new WielomianKwadratowy(H.a + a,H.b + b,H.c + c);
    }
    WielomianKwadratowy odejmowanie(WielomianKwadratowy H){
        return new WielomianKwadratowy(-H.a + a,-H.b + b,-H.c + c);
    }
    WielomianCzwartegoStopnia mnozenie(WielomianKwadratowy H){
        double nowe_a = H.a * a ;
        double nowe_b = a * H.b + H.a * b ;
        double nowe_c = a * H.c + H.a * c + b * H.b ;
        double d = b * H.c + H.b * c ;
        double e = c * H.c ;

        return new WielomianCzwartegoStopnia(nowe_a,nowe_b,nowe_c,d,e) ;
    }

    public void miejsca_zerowe(){
        double delta = b * b - 4 * a * c ;
        if(delta > 0){
            double x1 = (-b - delta) / (2 * a);
            double x2 = (-b + delta) / (2 * a);
            System.out.println("Miejsca zerowe x1 : " + x1 + " x2 : " + x2);

        } else if (delta == 0) {
            System.out.println("Miejsce zerowe" + -b/(2*a));
        }else{
            System.out.println("Nie ma miejsc zerowych delta wynosi : " + delta);
        }

    }
}

public class Cw_2_4 {
    public static void main(String[] args) {
        // Tworzenie obiektów wielomianów kwadratowych
        WielomianKwadratowy p1 = new WielomianKwadratowy(1, -3, 2); // x^2 - 3x + 2
        WielomianKwadratowy p2 = new WielomianKwadratowy(2, 1, -1);  // 2x^2 + x - 1

        // Dodawanie wielomianów
        WielomianKwadratowy suma = p1.dodawanie(p2);
        System.out.println("Suma: " + suma);

        // Odejmowanie wielomianów
        WielomianKwadratowy roznica = p1.odejmowanie(p2);
        System.out.println("Różnica: " + roznica);

        // Mnożenie wielomianów
        WielomianCzwartegoStopnia iloczyn = p1.mnozenie(p2);
        System.out.println("Iloczyn: " + iloczyn);

        // Obliczanie miejsc zerowych
        System.out.print("Miejsca zerowe dla p1: ");
        p1.miejsca_zerowe();

        System.out.print("Miejsca zerowe dla p2: ");
        p2.miejsca_zerowe();
    }
}
