import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserService {
    public boolean registerUser(String username, String password) {
        try {
            String userKey = emailToKey(username);

            String response = FirebaseService.get("users/" + userKey);
            if (!response.equals("null")) {
                System.out.println("Пользователь уже существует.");
                return false;
            }

            String hashedPassword = PasswordUtils.hashPassword(password);

            JSONObject userData = new JSONObject();
            userData.put("password", hashedPassword);

            FirebaseService.put("users/" + userKey, userData.toJSONString());
            System.out.println("Пользователь успешно зарегистрирован.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean authenticateUser(String username, String password) {
        try {
            String userKey = emailToKey(username);
            String response = FirebaseService.get("users/" + userKey);

            if (response.equals("null")) {
                System.out.println("Пользователь не найден.");
                return false;
            }

            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(response);
            String storedHashedPassword = (String) userData.get("password");

            if (storedHashedPassword.equals(PasswordUtils.hashPassword(password))) {
                System.out.println("Авторизация успешна.");
                return true;
            } else {
                System.out.println("Неверный пароль.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String emailToKey(String email) {
        return email.replace(".", "_").replace("@", "_at_");
    }
}
