package com.yuxin.common.algorithm;

// Java program to generate short url from integer id and
// integer id back from short url.

import java.io.IOException;

public class UrlShortner {

    // Map to store 62 possible characters
    private final static char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    // Function to generate a short url from integer ID
    public static String id2code(int n) {
        StringBuilder shortUrl = new StringBuilder();
        // Convert given integer id to a base 62 number
        while (n > 0) {
            // use above map to store actual character
            // in short url
            shortUrl.append(map[n % 62]);
            n /= 62;
        }
        // Reverse shortURL to complete base conversion
        return shortUrl.reverse().toString();
    }

    // Function to get integer ID back from a short url
    public static int code2id(String shortUrl) {
        int id = 0; // initialize result
        // A simple base conversion logic
        for (int i = 0; i < shortUrl.length(); i++) {
            if ('a' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'z')
                id = id * 62 + shortUrl.charAt(i) - 'a';
            else if ('A' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'Z')
                id = id * 62 + shortUrl.charAt(i) - 'A' + 26;
            else if ('0' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= '9')
                id = id * 62 + shortUrl.charAt(i) - '0' + 52;
        }
        return id;
    }

    // Driver Code
    public static void main(String[] args) throws IOException {
        int n = 1;
        String shorturl = id2code(64);
        int id = code2id(shorturl);
        System.out.println("Generated short url is " + shorturl);
        System.out.println("Id from url is " + id);
    }

}

// This code is contributed by shubham96301
