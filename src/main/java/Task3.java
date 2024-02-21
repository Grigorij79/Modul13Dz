import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
     public static void taskTodos (int id) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String uri = "https://jsonplaceholder.typicode.com/users/" + id + "/todos?completed=" + false;
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .GET()
            .build();
    HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
         //System.out.println(response.body());
    UsersTodos [] todosArray = gson.fromJson(response.body(), (Type) UsersTodos[].class);
    List <UsersTodos> todosList = new ArrayList<>(Arrays.asList(todosArray));
         System.out.println("Open tasks for a user with an ID = " + id + " :");
        int i = 1;
        for (UsersTodos element:todosList) {
                        System.out.println( i + ". " + element.getTitle());
                        i++;
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
         int id = 1;
         taskTodos(id);
    }
 }

class UsersTodos {
    int userId;
    int id;
    String title;
    boolean completed;

    public UsersTodos(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
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

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "ToDos{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

