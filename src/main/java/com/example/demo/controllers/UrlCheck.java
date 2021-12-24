package com.example.demo.controllers;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.*;
import java.net.HttpURLConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheck {
    private final String SITE_IS_UP = "Site is up!";
    private final String SITE_IS_DOWN = "Site is up!";
    private final String INCORRECT_URL = "Incorrect url";
        private final String PAGE_IS_DOWN = "Page is down";


    @GetMapping("/check")
    public String getUrlsStatusMessage(@RequestParam String url) {
        String returnMessage = "";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCodeCategory = connection.getResponseCode() / 100;
            if (responseCodeCategory != 2 || responseCodeCategory != 3) {
                returnMessage = SITE_IS_DOWN;
            } 
             else {
                returnMessage = SITE_IS_UP;
             }

        } catch (MalformedURLException e) {
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            returnMessage = PAGE_IS_DOWN;
        }

        return returnMessage;
    }

}
