import java.util.*; // Kibtikin Ilya IT3-2307

public class Tasks {
    // Task A
    public static boolean getNumber(int N){
        if(N == 1){
            return true;
        }
        if(N < 0){
            return false;
        }
        return getNumber(N - 3) || getNumber(N - 5);
    }
    // Task B
    public static int maxDigit(int number){
        if(number / 10 == 0){
            return number;
        }
        int lastDigit = number %  10;
        int remain = maxDigit(number / 10);
        if (lastDigit > remain){
            return lastDigit;
        }
        else{
            return remain;
        }
    }
    // Task C
    public static int strLength(String message){
        if (message.length() == 0){
            return 0;
        }
        if (Character.isDigit(message.charAt(0))){
            return 1 + strLength(message.substring(1));
        }
        else{
            return 0 + strLength(message.substring(1));
        }
    }
    // Task D
    public static String addAsterisk(String str){
        if(str.length() == 1){
            return str;
        }
        return str.charAt(0) + "*" + addAsterisk(str.substring(1));
    }
    // Task E
    public static String addBrackets(String str){
        String totalString = "";
        double middleChar = str.length() / 2.0;
        for(int i = 0; i < str.length(); i++){
            totalString += str.charAt(i);
            if ((i + 1) < middleChar){
                totalString += "(";
            }
            else if((i + 1) > middleChar && i != str.length() - 1){
                totalString += ")";
            }
        }
        return totalString;
    }
    // Task F
    public static String mirrorString(String mStr){
        String mirrorStr = "";
        for(int i = mStr.length() - 1; i >= 0; i--){
            if(mStr.charAt(i) == '('){
                mirrorStr += ")";
            }
            else{
                mirrorStr += mStr.charAt(i);
            }
        }
        return mStr + mirrorStr;
    }
    // Task G
    public static String stringReduce(String bigStr){
        String leftSide = "";
        String rightSide = "";
        String middle = "";
        if (bigStr.length() % 2 != 0){
            middle += bigStr.charAt(bigStr.length() / 2);
        }
        for (int i = 0; i < bigStr.length() / 2; i++){
            if(bigStr.charAt(i) != bigStr.charAt(bigStr.length() - 1 - i)){
                leftSide += bigStr.charAt(i);
                rightSide = bigStr.charAt(bigStr.length() - 1 - i) + rightSide;
            }
        }
        return leftSide + middle + rightSide;
    }
    // Task H
    public static int branchDeletion(int[][] messages, int quantity, int numberForDelete){
        List<Integer> queue = new ArrayList<>();
        queue.add(numberForDelete);
        int deleteCounter = 0;

        while(!queue.isEmpty()){
            int currentMessage = queue.remove(0);
            deleteCounter++;
            for(int i = 0; i < quantity; i++){
                if(messages[i][1] == currentMessage){
                    queue.add(messages[i][0]);
                }
            }
        }
        return deleteCounter;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // TASK A
        System.out.println("Enter a number to check for sum of 3 or 5: ");
        int N = Integer.parseInt(scanner.nextLine());
        if(getNumber(N)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }

        // TASK B
        System.out.println("Enter a number: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Max digit in number " + number + " is: " + maxDigit(number));

        // TASK C
        System.out.println("Enter a string: ");
        String strCounter = scanner.nextLine();
        System.out.println("Length of string is: " + strLength(strCounter));

        // TASK D
        System.out.println("Enter a string for adding asterisks: ");
        String strAsterisk = scanner.nextLine();
        System.out.println(addAsterisk(strAsterisk));

        // TASK E
        System.out.println("Enter a string for adding brackets: ");
        String strBrackets = scanner.nextLine();
        System.out.println(addBrackets(strBrackets));

        // TASK F
        System.out.println("Enter a string for adding mirror brackets: ");
        String strMirror = scanner.nextLine();
        System.out.println(mirrorString(strMirror));

        // TASK G
        System.out.println("Enter a string for adding reducing same symbols: ");
        String strLarge = scanner.nextLine();
        System.out.println(stringReduce(strLarge));

        // TASK H
        System.out.println("Enter number of messages: ");
        int quantity = scanner.nextInt();
        int[][] messages = new int[quantity][2];
        for(int i = 0; i < quantity; i++){
            messages[i][0] = scanner.nextInt();
            messages[i][1] = scanner.nextInt();
        }

        int numberForDelete = scanner.nextInt();
        System.out.println("Number of deleted messages is: " + branchDeletion(messages, quantity, numberForDelete));


        scanner.close();
    }
}
