package com.example.demo.service;

import com.example.demo.entity.Sight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SiteCrawlerService {

    public SiteCrawlerService() {
    }

    public Sight[] getItems(String zone) {
        String URL = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";
        Document doc = null;
        Document nextDoc = null;

        // connection
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // find sights number
        Elements zoneData = doc.select("h4:contains("+ zone +") + ul li a[href]");

        // create sights array to store sight info
        Sight[] sights = new Sight[zoneData.size()];

        // find and save sight info in second page
        for(int i = 0;i < zoneData.size();i++){

            // create new Sight class
            sights[i] = new Sight();

            // find second URL
            String sightURL = "https://www.travelking.com.tw" + zoneData.get(i).attr("href");

            // connection to second page
            try {
                nextDoc = Jsoup.connect(sightURL).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // find info in second page
            Elements sightName = nextDoc.select("h1 span");
            Elements category = nextDoc.select("span strong");
            Elements photoURL = nextDoc.select("div.gpic img");
            Elements description = nextDoc.select("#point_area > div.text");
            Elements address = nextDoc.select("div.address span");

            // save info to sight
            sights[i].setZone(zone);
            sights[i].setSightName(sightName.text());
            sights[i].setCategory(category.text());
            if(!photoURL.isEmpty())
                sights[i].setPhotoURL(photoURL.first().attr("data-src"));
            else
                sights[i].setPhotoURL(null);
            sights[i].setDescription(description.text());
            sights[i].setAddress(address.text());

        }
        return sights;
    }
}
