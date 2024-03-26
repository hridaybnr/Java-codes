import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GistContentFetcher {

    public static void main(String[] args) {
        String gistUrl = "https://github.com/hridaybnr/Java-codes.git"; // Replace this with your Gist URL

        try {
            String content = fetchGistContent(gistUrl);
            System.out.println("Content of the Gist:");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fetchGistContent(String gistUrl) throws IOException {
        URL url = new URL(gistUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            return content.toString();
        }
    }
}
