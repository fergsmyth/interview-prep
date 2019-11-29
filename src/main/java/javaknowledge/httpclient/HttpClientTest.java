package javaknowledge.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        new HttpClientTest().sendHttpRequest();
    }

    public void sendHttpRequest() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder().uri(URI.create("https://winterbe.com")).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    // Async returns a completable future.
    // Completable future functions :
    // thenApply returns a CompletableFuture<T> where T is the returned value of the method executed
    // thenAccept returns a CompletableFuture<Void> i.e. no value
    public void sendAsyncRequest(){
        var request = HttpRequest.newBuilder().uri(URI.create("https://winterbe.com")).GET().build();
        CompletableFuture<HttpResponse<String>> futureResponse = HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<String> futureBody = futureResponse.thenApply(HttpResponse::body);
        futureBody.thenAccept(System.out::println);
    }
}
