import java.io.*;
import java.util.*;

public class App {
    static final String FILE_PATH = "users.txt";

    static void signUp(Scanner sc) {
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        try {
            List<String> users = readUsersFromFile();
            int newId = users.size() + 1;

            for (String user : users) {
                String[] userData = user.split(" ");
                if (userData[1].equals(name)) {
                    System.out.println("User already exists!");
                    return;
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write(newId + " " + name + " " + password);
            writer.newLine();
            writer.close();

            System.out.println("User signed up successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while signing up: " + e.getMessage());
        }
    }

    static void signIn(Scanner sc) {
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        try {
            List<String> users = readUsersFromFile();

            for (String user : users) {
                String[] userData = user.split(" ");
                if (userData[1].equals(name) && userData[2].equals(password)) {
                    System.out.println("Sign in successful!");
                    return;
                }
            }

            System.out.println("Invalid name or password!");
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    static List<String> readUsersFromFile() throws IOException {
        List<String> users = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            while ((line = reader.readLine()) != null) {
                users.add(line);
            }

            reader.close();
        }

        return users;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int query;

        do {
            System.out.println("Choose the number:");
            System.out.println("1. Sign up");
            System.out.println("2. Sign in");
            System.out.println("0. Exit");
            query = sc.nextInt();
            sc.nextLine();

            if (query == 1) {
                signUp(sc);
            } else if (query == 2) {
                signIn(sc);
            }
        } while (query != 0);

        sc.close();
    }
}