package com.servlet.main;

import java.io.BufferedReader;
import java.util.*;

public class Utils {

    private static long lastId=0;

    public static Map<String,String> parseJSON(BufferedReader bufferedReader){
        String line="";
        Scanner scanner=new Scanner(bufferedReader);
        Map<String,String> bodyMapped=new HashMap<>();

        while(scanner.hasNextLine()) {
            line=scanner.nextLine();
            line=line.replaceAll(",","");
            if (!line.trim().equalsIgnoreCase("{") && !line.trim().equalsIgnoreCase("}")) {

                final String finalLine = line.trim();
                bodyMapped.put(finalLine.split(":",2)[0], finalLine.split(":",2)[1]);

            }
        }
       return bodyMapped;
    }

    public static Long generateRandomId(){
        long num=Long.valueOf(""+(long)(Math.random()*9)+(long)(Math.random()*9)+
                (long)(Math.random()*9)+(long)(Math.random()*9))*1000+lastId;
        lastId+=1;
        return num;
    }

}
