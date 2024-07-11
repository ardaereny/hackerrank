package com.ardaeren.hackerrank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        long aCountInString = s.chars().filter(ch -> ch == 'a').count();

        long fullRepeats = n / s.length();
        long remainingChars = n % s.length();

        long totalCount = fullRepeats * aCountInString;

        totalCount += s.substring(0, (int) remainingChars).chars().filter(ch -> ch == 'a').count();

        return totalCount;
    }

    public int romanToInt(String s) {

        //LVIII,MCMXCIV= 1994
        List<Integer> valueList = new ArrayList<>();
        List<Integer> wishList = new ArrayList<>();
        Map<Character, Integer> romanValues = new HashMap<>();

        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        for(int i = 0; i < s.length(); i++){
          valueList.add(romanValues.get(s.charAt(i)));
        }

        for(int i = 0; i < valueList.size(); i++){
            if(i == valueList.size() -1){
                wishList.add(valueList.get(i));
            }
            else if(valueList.get(i) >= valueList.get(i + 1)){
                wishList.add(valueList.get(i));
            }
            else {
                int i1 = valueList.get(i + 1) - valueList.get(i);
                wishList.add(i1);
                i++;
            }
        }
    return wishList.stream().reduce(0,Integer::sum);
}


}

