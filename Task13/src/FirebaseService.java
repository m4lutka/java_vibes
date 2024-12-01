import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

public class FirebaseService {
    private static final String DATABASE_URL = "https://javatask-4b8a8-default-rtdb.europe-west1.firebasedatabase.app/";

    public static String put(String path, String jsonData) throws IOException {
        URI uri = URI.create(DATABASE_URL + path + ".json");
        URL url = uri.toURL();
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("PUT");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = http.getOutputStream()) {
            os.write(jsonData.getBytes("UTF-8"));
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }
            return response.toString();
        }
    }

    public static String get(String path) throws IOException {
        URI uri = URI.create(DATABASE_URL + path + ".json");
        URL url = uri.toURL();
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }
            return response.toString();
        }
    }
}
