import com.fasterxml.jackson.core.JsonFactory;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;

public class HttpClientController {
    private String RESOURCE_POINT;
    HttpClient client = null;
    HttpClientController() {
        client = HttpClient.newBuilder().build();
    }

}

class ChatBot extends HttpClientController {
    String userid = "***REMOVED***";
    String RESOURCE_POINT = "https://aiproject.ru/api/";

    ChatBot() {
        super();
    }

    HttpRequest requestAnswer(String msg) {
        String ask = "\"ask\":\"" + msg + "\",";
        String userid = "\"userid\":\"" + this.userid + "\",";
        String key = "\"key\":\"\"";
        String query = "{" + ask + userid + key + "}";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(RESOURCE_POINT))
                .POST(HttpRequest.BodyPublishers.ofString("query=" + query))
                .build();

        return httpRequest;
    }

    public String getAnswer(String msg) {
        HttpRequest request = requestAnswer(msg);
        String answer = "Что-то пошло не так";
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(response.body().toString()).getAsJsonObject();
            int status = jsonResponse.get("status").getAsInt();
            if (status == 1) {
                answer = jsonResponse.get("aiml").getAsString();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return answer;
    }
}

class ComicBot extends HttpClientController {
    private String RESOURCE_POINT = "http://anecdotica.ru/api";
    private String pid = "z2njof3gz598spk3hunv";
    private String skey = "dbc506036a28b8e4ebb6ad60654cfca8d1e8a4c0c089de9792e198b30c77cc58";

    ComicBot(){
        super();
    }

    HttpRequest requestAnswer() {
        String method = "getRandItemP";
        long timestamp = Instant.now().getEpochSecond();
        String query = "pid=" + pid + "&method=" + method + "&uts=" + timestamp;

        String hash = DigestUtils.md5Hex(query + skey);
        query += "&hash=" + hash;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(RESOURCE_POINT + "?" + query))
                .GET()
                .build();

        return httpRequest;
    }

    public String getAnek(){
        HttpRequest request = requestAnswer();
        String answer = null;
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(response.body().toString()).getAsJsonObject();
            int status = jsonResponse.get("result").getAsJsonObject().get("error").getAsInt();
            if (status == 0) {
                answer = jsonResponse.get("item").getAsJsonObject().get("text").getAsString();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return answer;
    }



}