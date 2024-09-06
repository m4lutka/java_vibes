// Kibitkin Ilya IT3-2307
import java.util.Scanner;

public class MyPrograms{
    // Task 1
    public static boolean isPalindrome(String message){
        int left = 0;
        int right = message.length() - 1;
        while (right > left){
            if(message.charAt(left) == message.charAt(right)){
            left++;
            right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    // Task 2
    public static void Fibonacci(int n){
        int fibb1 = 1;
        int fibb2 = 1;
        int fibbSum = 0;
        int i = 0;
        if (n == 1) {
            System.out.print(fibb1);
            return;
        } else if (n == 2) {
            System.out.print(fibb1 + " " + fibb2);
            return;
        }

        System.out.print(fibb1 + " " + fibb2 + " ");

        while(i < n - 2){
            fibbSum = fibb1 + fibb2;
            fibb1 = fibb2;
            fibb2 = fibbSum;
            i++;
            System.out.print(fibbSum + " ");
        }
        System.out.println();
    }
    // Task 3
    public static void MaxMin(int[] numbers){
        int max = numbers[0];
        int min = numbers[0];
        if(numbers.length == 1){
            System.out.println("Max value of array is: " + max);
            System.out.println("Min value of array is: " + min);
            return;
        }
        for(int i = 0; i < numbers.length; i++){
            if (max < numbers[i]){
                max = numbers[i];
            } else if(min > numbers[i]){
                min = numbers[i];
            }
        }
        System.out.println("Max value of array is: " + max);
        System.out.println("Min value of array is: " + min);
    }
    // Task 4
    public static double CalcGPA(double[] marks, int[] credit){
        double totalSum = 0;
        int totalCredit = 0;
        for(int i = 0; i < marks.length; i++){
            totalSum += marks[i] * credit[i];
            totalCredit += credit[i];
        }
        return (double) totalSum / totalCredit;
    }
    // Task 5
    public static int factorial(int num){
        if(num == 0 || num == 1){
            return 1;
        } else if(num < 0){
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        int total = 1;
        for(int i = 1; i < num + 1; i++){
            total *= i;
        }
        return total;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("What do you want to do? Write a number: \n 1 - Palindrome Check \n 2 - Fibonacci number \n 3 - MinMax of array \n 4 - GPA Calc \n 5 - Factorial \n Other - Exit");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                // Task 1 : Palindrome
                case 1:
                    System.out.print("Enter a string to check if it is a palindrome: ");
                    String testStr = scanner.nextLine();
                    System.out.print("Your word " + testStr + " is: ");
                    System.out.println(isPalindrome(testStr) ? "Palindrome" : "Not Palindrome" );
                    System.out.println();
                    break;
                // Task 2: Fibonacci
                case 2:
                    System.out.print("Enter the number of Fibonacci numbers: ");
                    int fibCount = scanner.nextInt();
                    Fibonacci(fibCount);
                    System.out.println();
                    break;
                // Task 3: MaxMin
                case 3:
                    System.out.println("Enter the size of an array: ");
                    int size = scanner.nextInt();
                    System.out.println("Enter " + size + " int numbers in a row");
                    int[] arrayOfNums = new int[size];
                    for(int i = 0; i < size; i++){
                        arrayOfNums[i] = scanner.nextInt();
                    }
                    MaxMin(arrayOfNums);
                    System.out.println();
                    break;
                // Task 4: GPA Calculator
                case 4:
                    System.out.println("Enter number of subjects");
                    int subjectsNum = Integer.parseInt(scanner.nextLine());
                    double[] marks = new double[subjectsNum];
                    int[] credits = new int[subjectsNum];
                    for(int i = 0; i < subjectsNum; i++){
                        System.out.println("Enter your GPA and credit data with ':' - (4.0:5): ");
                        String[] gpaData = scanner.nextLine().split(":");
                        marks[i] = Double.parseDouble(gpaData[0]);
                        credits[i] = Integer.parseInt(gpaData[1]);
                    }
                    System.out.println("Your GPA is: " + CalcGPA(marks, credits));
                    System.out.println();
                    break;
                // Task 5: Factorial
                case 5:
                    System.out.println("Enter the factorial number: ");
                    int factNumber = scanner.nextInt();
                    System.out.println(factorial(factNumber));
                    System.out.println();
                    break;
                default:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
        }
    }
    }

}