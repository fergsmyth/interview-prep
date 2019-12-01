package javaknowledge.httpclient;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * Taken from https://winterbe.com/posts/2018/09/24/java-11-tutorial/
 * */
public class HttpClientTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClientTest client = new HttpClientTest();
        client.sendHttpGETRequest();
        client.sendAsyncGETRequest();
        client.sendPOSTRequest();
        client.sendGETBasicAuth();
    }

    public void sendHttpGETRequest() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder().uri(URI.create("https://winterbe.com")).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    // Async returns a completable future.
    // Completable future functions :
    // thenApply returns a CompletableFuture<T> where T is the returned value of the method executed
    // thenAccept returns a CompletableFuture<Void> i.e. no value
    public void sendAsyncGETRequest(){
        var request = HttpRequest.newBuilder().uri(URI.create("https://winterbe.com")).GET().build();
        CompletableFuture<HttpResponse<String>> futureResponse = HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<Integer> futureBody = futureResponse.thenApply(HttpResponse::statusCode);
        futureBody.thenAccept(System.out::println);
    }

    public void sendPOSTRequest() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/post"))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString("Say something"))
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    public void sendGETBasicAuth() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/basic-auth"))
                .build();
        var client = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("postman", "password".toCharArray());
                    }
                })
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }
}
