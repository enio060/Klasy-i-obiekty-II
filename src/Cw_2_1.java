class Ulamek{
    int a ;
    int b ;
    Ulamek(){
        this.a = 0;
        this.b = 1;
    }
    Ulamek(int a , int b ){
        this.a = a ;
        if(b!=0){
            this.b = b ;
        }else{
            throw new IllegalArgumentException("Mianownik nie może być równy 0!");
        }

    }

    @Override
    public String toString(){
        return  a + " / " + b ;
    }

    double rozwDziesietne(){

        double x = (double)a;
        double y = (double)b;
        return x/y ;
    }

    Ulamek plus(Ulamek ulamek2){
        if(ulamek2.b == b){
            int new_a = a + ulamek2.a ;
            Ulamek Nowy = new Ulamek(new_a,b);
            return Nowy;

        }else{
            int new_a = a * ulamek2.b + b * ulamek2.a;
            int new_b = b * ulamek2.b;
            Ulamek Nowy = new Ulamek(new_a,new_b);
            return Nowy;
        }
    }
    Ulamek minus(Ulamek ulamek2){
        if(ulamek2.b == b){
            int new_a = a - ulamek2.a ;
            Ulamek Nowy = new Ulamek(new_a,b);
            return Nowy;
    }else{
            int new_a = a * ulamek2.b - b * ulamek2.a;
            int new_b = b * ulamek2.b;
            Ulamek Nowy = new Ulamek(new_a,new_b);
            return Nowy;
        }
    }
    Ulamek razy(Ulamek ulamek2){
        Ulamek ulamek = new Ulamek(ulamek2.a * a, ulamek2.b * b);
        return ulamek ;
    }

    public void odwroc(){
        int pomocnicza = a;
        this.a = b;
        this.b = pomocnicza;
    }

    private int NWD(int a,int b){
        while(a != b){
            if(a > b ){
                a = a - b ;
            }else{
                b = b - a ;
            }
        }return a;
    }

    public void skroc(){
        int NWD = NWD(a,b);
        a /= NWD;
        b /= NWD;
    }
}


public class Cw_2_1 {
    public static void main(String[] args) {
        Ulamek obj,obj2;
        obj=new Ulamek(6,8);
        obj2=new Ulamek(3,7);

        System.out.println(obj);

        double x = obj.rozwDziesietne();


        Ulamek obj3 = obj.plus(obj2);
        System.out.println(obj3);
        Ulamek obj4=obj.minus(obj2);
        System.out.println(obj4);
        Ulamek obj5=obj.razy(obj2);
        System.out.println(obj5);

        obj.odwroc();
        System.out.println(obj);
        obj.skroc();
        System.out.println(obj);
    }
}