import java.util.Arrays;

class Macierz {
    double[][] macierz;

    Macierz() {
        this.macierz = new double[][]{
                {1.0, 1.0, 1.0},
                {1.0, 1.0, 1.0},
                {1.0, 1.0, 1.0}
        };
    }

    public Macierz(double[][] macierz) {
        if (macierz.length != 3 || macierz[0].length != 3) {
            throw new IllegalArgumentException("Macierz musi być 3x3.");
        }
        this.macierz = macierz;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : macierz) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return "Macierz:\n" + sb.toString();
    }

    double wyznacznik() {
        double a11 = macierz[0][0], a12 = macierz[0][1], a13 = macierz[0][2];
        double a21 = macierz[1][0], a22 = macierz[1][1], a23 = macierz[1][2];
        double a31 = macierz[2][0], a32 = macierz[2][1], a33 = macierz[2][2];
        return a11 * (a22 * a33 - a23 * a32)
                - a12 * (a21 * a33 - a23 * a31)
                + a13 * (a21 * a32 - a22 * a31);
    }

    public Macierz tranzpozycja() {
        double[][] transponowana = new double[3][3];

        transponowana[0][0] = macierz[0][0];
        transponowana[0][1] = macierz[1][0];
        transponowana[0][2] = macierz[2][0];
        transponowana[1][0] = macierz[0][1];
        transponowana[1][1] = macierz[1][1];
        transponowana[1][2] = macierz[2][1];
        transponowana[2][0] = macierz[0][2];
        transponowana[2][1] = macierz[1][2];
        transponowana[2][2] = macierz[2][2];

        return new Macierz(transponowana);
    }

    public double[][] calculateCofactors() {
        double[][] cofactors = new double[3][3];

        cofactors[0][0] = determinant2x2(macierz[1][1], macierz[1][2], macierz[2][1], macierz[2][2]);
        cofactors[0][1] = -determinant2x2(macierz[1][0], macierz[1][2], macierz[2][0], macierz[2][2]);
        cofactors[0][2] = determinant2x2(macierz[1][0], macierz[1][1], macierz[2][0], macierz[2][1]);

        cofactors[1][0] = -determinant2x2(macierz[0][1], macierz[0][2], macierz[2][1], macierz[2][2]);
        cofactors[1][1] = determinant2x2(macierz[0][0], macierz[0][2], macierz[2][0], macierz[2][2]);
        cofactors[1][2] = -determinant2x2(macierz[0][0], macierz[0][1], macierz[2][0], macierz[2][1]);

        cofactors[2][0] = determinant2x2(macierz[0][1], macierz[0][2], macierz[1][1], macierz[1][2]);
        cofactors[2][1] = -determinant2x2(macierz[0][0], macierz[0][2], macierz[1][0], macierz[1][2]);
        cofactors[2][2] = determinant2x2(macierz[0][0], macierz[0][1], macierz[1][0], macierz[1][1]);

        return cofactors;
    }

    private double determinant2x2(double a, double b, double c, double d) {
        return a * d - b * c;
    }

    private Macierz mnozenie_macierzy_przez_liczbe(double liczba, Macierz macierz) {
        double[][] nowa_macierz = new double[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nowa_macierz[i][j] = liczba * macierz.macierz[i][j];
            }
        }
        return new Macierz(nowa_macierz);
    }

    public Macierz Macierz_odwrotna() {
        double wyznacznik = wyznacznik();

        if (wyznacznik == 0) {
            throw new IllegalArgumentException("Macierz nie ma odwrotności, ponieważ wyznacznik wynosi 0.");
        }
        double odwrotny_wyznacznik = 1 / wyznacznik;
        Macierz odwrocona = mnozenie_macierzy_przez_liczbe(odwrotny_wyznacznik, new Macierz(calculateCofactors()).tranzpozycja());
        return odwrocona;
    }

    private double[] obliczanieWielomianu3Stopnia( double[] lista) {

        double b = lista[0] ;
        double c = lista[1] ;
        double d = lista[2] ;

        double p = c - (Math.pow(b, 2) / 3);
        double q = (2 * Math.pow(b, 3) / 27) - (b * c / 3) + d;
        double wyroznik = Math.pow(p, 3) / 27 + Math.pow(q, 2) / 4;

        if (wyroznik > 0) {
            double[] zwrot = new double[1];
            double y = Math.cbrt(-q / 2 + Math.sqrt(wyroznik)) + Math.cbrt(-q / 2 - Math.sqrt(wyroznik));
            zwrot[0] = y;
            return zwrot;
        } else if (wyroznik < 0) {
            double[] zwrot = new double[3];
            double u = 2 * Math.sqrt(-p / 3);
            double v = Math.acos(3 * q / (2 * p) * Math.sqrt(-3 / p));

            zwrot[0] = u * Math.cos(v / 3);
            zwrot[1] = u * Math.cos((v + 2 * Math.PI) / 3);
            zwrot[2] = u * Math.cos((v + 4 * Math.PI) / 3);

            return zwrot;
        } else {
            double u = -Math.cbrt(q / 2);
            double[] zwrot = new double[2];
            zwrot[0] = 2 * u;
            zwrot[1] = -u;

            return zwrot;
        }
    }
    private double[] dowielomianu(){
        double a = -1 * ( macierz[0][0] + macierz[1][1] + macierz[2][2]);
        double b = macierz[0][0] * macierz[1][1] + macierz[2][2] * macierz[0][0] - macierz[2][2] * macierz[1][1] - macierz[0][1] * macierz[1][0] - macierz[2][0] * macierz[0][2] - macierz[1][2] * macierz[2][1] ;
        double c = wyznacznik() ;
        double[] zwrot = new double[3];
        zwrot[0] = a ;
        zwrot[1] = b ;
        zwrot[2] = c ;
        return zwrot ;

    }
    /**
     Macierz obliczanie_macierzy_diagonalneh();{

    }**/

}

public class Cw_2_6 {
    public static void main(String[] args) {
        double[][] dane = {
                {3.0, 1.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        Macierz macierz = new Macierz(dane);

        System.out.println("Wyznacznik: " + macierz.wyznacznik());
        System.out.println("Macierz dopełnień: " + new Macierz(macierz.calculateCofactors()));
        System.out.println("Macierz odwrotna: " + macierz.Macierz_odwrotna());
    }
}
