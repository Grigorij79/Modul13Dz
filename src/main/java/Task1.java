import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

public class Task1 {
    private static final String USER_URI = "https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) throws IOException, InterruptedException{

        //*********** zad 1.1 *************
        System.out.println("*********** zad 1.1 *************");

        User  user = new User(2, "Leanne Graham", "Bret", "Sincere@april.biz", new String[]{
                "Kulas Light",
                "Apt. 556",
                "Gwenborough",
                "92998-3874",
                Arrays.toString(new String []{"-37.3159",
                        "81.1496"})},
                "1-770-736-8031 x56442",
                 "hildegard.org",
                new String[] {
                "Romaguera-Crona", "Multi-layered client-server neural-net",
            "harness real-time e-markets"});
        System.out.println(HttpUtillTask1.sendPost(URI.create(USER_URI), user));
        //**************** zad 1.2 *********************
        System.out.println("*********** zad 1.2 *************");
        System.out.println(HttpUtillTask1.sendPut(2, user));
        //****************8 zsd 1.3 ******************
        System.out.println("*********** zad 1.3 *************");
        int deleteUserId = 1;
        System.out.println("User with id = " + deleteUserId + "; delete status - "
                + HttpUtillTask1.deleteUser(deleteUserId));
        //*********** zad 1.4 *************
        System.out.println("*********** zad 1.4 *************");
        HttpUtillTask1.zadAllUser(URI.create(USER_URI));
        //*********** zad 1.5 *************
        System.out.println("*********** zad 1.5 *************");
        int userId = 2;
       System.out.println("id =" + userId + HttpUtillTask1.getUserId(userId));


        //*********** zad 1.6 *************
        System.out.println("*********** zad 1.6 *************");
        String userName = "Samantha";
        System.out.println( "userName = " + userName + HttpUtillTask1.getUserName(userName));

    }
}
