// Kibitkin Ilya IT3-2307

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         UserService userService = new UserService();

//         while (true) {
//             System.out.println("\nВыберите действие:");
//             System.out.println("1. Регистрация");
//             System.out.println("2. Авторизация");
//             System.out.println("3. Выход");
//             System.out.print("Ваш выбор: ");
//             String choice = scanner.nextLine();

//             switch (choice) {
//                 case "1":
//                     System.out.print("Введите email: ");
//                     String email = scanner.nextLine();
//                     System.out.print("Введите пароль: ");
//                     String password = scanner.nextLine();

//                     userService.registerUser(email, password);
//                     break;
//                 case "2":
//                     System.out.print("Введите email: ");
//                     String loginEmail = scanner.nextLine();
//                     System.out.print("Введите пароль: ");
//                     String loginPassword = scanner.nextLine();

//                     userService.authenticateUser(loginEmail, loginPassword);
//                     break;
//                 case "3":
//                     System.out.println("Выход из программы.");
//                     scanner.close();
//                     System.exit(0);
//                 default:
//                     System.out.println("Неверный выбор. Попробуйте снова.");
//             }
//         }
//     }
// }


import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}
