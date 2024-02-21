import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtillTask1 {

   private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private  static final Gson GSON = new Gson();
    public static User sendPut (int userId, User user)throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        final HttpResponse<String> response =CLIENT.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println(" Code =" + response.statusCode());
        return GSON.fromJson(response.body(),User.class);
    }
    public static User sendPost (URI uri, User user)throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
               .uri(uri)
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
               .build();
        final HttpResponse<String> response =CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(" Code =" + response.statusCode());
        return GSON.fromJson(response.body(),User.class);
    }



    public static void zadAllUser (URI uri)throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json; charset=UTF-8")
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Body =" + response.body());
        System.out.println(" Code =" + response.statusCode());
    }
    public static int deleteUser(int id ) throws IOException, InterruptedException {
        String uriDtlete = "https://jsonplaceholder.typicode.com/users/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriDtlete))
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }
    public static String getUserId (int id) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getUserName(String userName) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users?username=" + userName;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
