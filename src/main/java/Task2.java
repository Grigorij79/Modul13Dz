import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Task2 {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    public static void Task3(int userId) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        UsersId [] usersIdsArray = gson.fromJson(response.body(), (Type) UsersId[].class);
        List <UsersId> usersIds = new ArrayList<>(Arrays.asList(usersIdsArray));
        int Y = usersIds.get(usersIds.size() - 1).getId();
        String nameFile = "user-" + userId + "-post-" + Y  + "-comments.json";
        uri = "https://jsonplaceholder.typicode.com/posts/" + Y + "/comments";
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response2 = CLIENT.send(request2, HttpResponse.BodyHandlers.ofString());
        FileWriter fileWriter = new FileWriter(nameFile, false);
        fileWriter.write(response2.body());
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
       int usersId = 1;
    Task3(usersId);
    }

}
class UsersId{
private int userId;
private int id;
private String title;
  private   String body;
    public UsersId(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "UsersId{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}