package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081).usePlaintext().build();

        com.example.grpc.GreetingServiceGrpc.GreetingServiceBlockingStub stub = com.example.grpc.GreetingServiceGrpc.newBlockingStub(channel);

        com.example.grpc.GreetingServiceOuterClass.HelloRequest request =
                com.example.grpc.GreetingServiceOuterClass.HelloRequest.newBuilder().setName("Andrey").build();
        com.example.grpc.GreetingServiceOuterClass.HelloResponse response = stub.greeting(request);
        System.out.println(response);
        channel.shutdownNow();



    }
}
