package com.ardaeren.hackerrank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static long repeatedString(String s, long n){
        // 2 durum var 1 -> string size ile n size birbirini katıysa
        // stringdeki en çok tekrar eden sayının ne kadar geçtiğini bul
        //  n/s.length kadar o sayıyı çarp
        // 2-> string size ile n birbirinin katı değilse
        // üssteki işlemleri yap + olarak n%s kalanını da contains...
        long ekstraAsayisi;
        long aTekrarSayisi;

        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            charList.add(c);
        }
        aTekrarSayisi = charList.stream().filter(ch -> ch == 'a').count();


        if(n%s.length() == 0){
            return n/s.length() * aTekrarSayisi;
        }
        else{
            var ekstraharfler = n % s.length();
            var kalankelime = s.substring(0,(int) ekstraharfler);
            ekstraAsayisi = kalankelime.chars().filter(ch -> ch == 'a').count();
            return ekstraAsayisi + n/s.length() * aTekrarSayisi;
        }
    }

}

