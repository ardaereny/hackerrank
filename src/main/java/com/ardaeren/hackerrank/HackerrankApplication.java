package com.ardaeren.hackerrank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HackerrankApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackerrankApplication.class, args);
    }

    public static String appendAndDelete(String s, String t, int k){

        if(s.startsWith(t) && s.length() - t.length() <= k){
            return "Yes";
        }
        else if (k >= s.length() + t.length()) {
            return "Yes";

        }
        else if(t.startsWith(s) && t.length() + s.length() > k) {
            return "No";

        }
        else {
            for(int i = t.length(); i > 0; i--){
                String isEqual = t.substring(0, i);

                if(s.startsWith(isEqual) && (s.length() - i + (t.length() - i)) <= k){
                    return "Yes";
                }
            }
        }
        return "No";
    }

}

