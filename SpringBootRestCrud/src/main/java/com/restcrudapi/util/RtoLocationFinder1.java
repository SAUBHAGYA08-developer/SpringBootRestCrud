package com.restcrudapi.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RtoLocationFinder1 {

    public static String[] getLocationFromRtoCode(String rtoCode) {
        String[] location = new String[2];
        try {
            URL url = new URL("https://vahanapi.com/api/v1/regstate?reg_no=" + rtoCode);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();
                String[] data = inline.split(",");
                location[0] = data[1].substring(1, data[1].length() - 1);
                location[1] = data[2].substring(1, data[2].length() - 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }
}

