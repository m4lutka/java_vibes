// Kibitkin Ilya IT3-2307

class MyMath {

    public static double PI = find_pi();
    public static double E = exp(1);

    private MyMath() {}

    public static Double find_pi() {

        Double PI = 3., n = 2., sign = 1.;
        for (int i = 0; i <= 1000000; i++) {
            PI = PI + (sign * (4 / ((n) * (n + 1) * (n + 2))));
            sign = sign * (-1);
            n += 2;
        }
        return PI;
    }

    public static double exp(int n) {
        double result = 1.0;
        double term = 1.0;
        int i = 1;

        while (true) {
            term *= (double)n / i;
            if (term < 1e-10 && term > -1e-10) {
                break;
            }
            result += term;
            i++;
        }

        return result;
    }

    public static int factorial(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        int res = 1;
        for (int i = 1; i <= n; i++){
            res = res * i;
        }

        return res;
    }


    public static Double power(Double base, int power){
        if(base == 0 && power == 0){
            throw new IllegalArgumentException();
        }

        Double result = 1.;

        int absPower = (power < 0) ? -power : power;

        for (int i = 0; i < absPower; i++) {
            result *= base;
        }


        if (power < 0) {
            result = 1.0 / result;
        }

        return result;
    }

    public static double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
        }
        if (number == 0 || number == 1) {
            return number;
        }

        double guess = number / 2;
        double epsilon = 1e-10;

        while (true) {
            double nextGuess = (guess + number / guess) / 2;
            if (((nextGuess - guess < epsilon) && (guess - nextGuess < epsilon))) {
                break;
            }
            guess = nextGuess;
        }

        return guess;
    }

    public static double sin(double x) {
        double result = 0.0;
        double term = x;
        int n = 1;

        while (true) {
            result += term;
            term *= -x * x / ((2 * n) * (2 * n + 1));

            if (term < 1e-10 && term > -1e-10) break;
            n++;
        }

        return result;
    }

    public static double cos(double x) {
        double result = 0.0;
        double term = 1.0;
        int n = 0;

        while (true) {
            result += term;
            term *= -x * x / ((2 * n + 1) * (2 * n + 2));

            if (term < 1e-10 && term > -1e-10) break;
            n++;
        }

        return result;
    }

    public static double tan(double x) {
        double cosValue = cos(x);
        if (cosValue < 1e-10 && cosValue > -1e-10) {
            throw new ArithmeticException("tan is undefined for x where cos(x) = 0.");
        }
        return sin(x) / cosValue;
    }

    public static double cot(double x) {
        double sinValue = sin(x);
        if (sinValue < 1e-10 && sinValue > -1e-10) {
            throw new ArithmeticException("cot is undefined for x where sin(x) = 0.");
        }
        return cos(x) / sinValue;
    }
}
    public class Main{
        public static void main(String[] args) throws Exception {
            System.out.println(MyMath.PI);
            System.out.println(MyMath.E);
            System.out.println(MyMath.factorial(5));
            System.out.println(MyMath.power(4., -2));
            System.out.println(MyMath.sqrt(16));
            System.out.println(MyMath.sin(30. * MyMath.PI / 180));
            System.out.println(MyMath.cos(30. * MyMath.PI / 180));
            System.out.println(MyMath.tan(45. * MyMath.PI / 180));
            System.out.println(MyMath.cot(45. * MyMath.PI / 180));
        }
}
