package lesson4;

public class Triangle {

    public static double calcSquare(int a, int b, int c){
        if (a<=0||b<=0||c<=0){
            throw new IllegalArgumentException("Invalid value of side. Should be positive number");
        }
        double p = (a+b+c)/2.0;
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return s;
    }
}
