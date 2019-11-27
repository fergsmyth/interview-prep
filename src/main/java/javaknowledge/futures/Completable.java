package javaknowledge.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Completable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<String> future = createFuture();
        String value = future.get();
        System.out.println(value);
    }

    public static Future<String> createFuture() {
        CompletableFuture<String> future = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(
                () -> {
                    StringBuilder futureValue = new StringBuilder();
                    for(int i = 0; i < 10; i++) {
                        Thread.sleep(100);
                        futureValue.append(System.currentTimeMillis() % 4);
                    }
                    future.complete(futureValue.toString());
                    return null;
                }
        );
        return future;
    }
}
