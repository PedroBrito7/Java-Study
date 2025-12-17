package javacore.Rdatas.test;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
    public static void main(String[] args) {
        //igual date porem com nano segundos
        Instant now = Instant.now();
        System.out.println(now); // zulo time stadard of the word
        System.out.println(LocalDateTime.now());
    }
}
