package ohtu;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players);

        System.out.println("Players from FIN " + new Date(System.currentTimeMillis()));
        for (Player player : players) {
            System.out.println(player);
        }
    }

}
