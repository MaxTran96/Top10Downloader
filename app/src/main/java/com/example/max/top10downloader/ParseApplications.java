package com.example.max.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by max on 3/18/2017.
 */
public class ParseApplications {
    private String xmlData;
    private ArrayList<Application> applications;

    public ParseApplications(String xmlData) {
        this.xmlData = xmlData;
        applications = new ArrayList<>();
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }
    public boolean process(){
        boolean status = true;
        Application currentRecord = null;
        boolean inEntry = false;
        String textValue = "";
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch(eventType){
                    case XmlPullParser.START_TAG:
                        Log.d("ParseApplications", "Starting tag for " + tagName);
                        if(tagName.equalsIgnoreCase("anime")){
                            inEntry = true;
                            currentRecord = new Application();

                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        Log.d("ParseApplications", "Ending tag for " + tagName);
                        if(inEntry){
                            if(tagName.equalsIgnoreCase("anime")){
                                applications.add(currentRecord);
                            } else if(tagName.equalsIgnoreCase("series_title")){
                                currentRecord.setTitle(textValue);
                            } else if(tagName.equalsIgnoreCase("series_episodes")){
                                currentRecord.setNum_Episodes(textValue);
                            } else if(tagName.equalsIgnoreCase("series_start")){
                                currentRecord.setReleaseDate(textValue);
                            }
                        }
                    default:
                }
                eventType = xpp.next();

            }
            return true;

        }catch(Exception e){
            status = false;
            e.printStackTrace();
        }
        for(Application app : applications){
            Log.d("ParseApplications","*****");
            Log.d("ParseApplications","Title: " +app.getTitle());
            Log.d("ParseApplications","Number of episodes: " +app.getNum_Episodes());
            Log.d("ParseApplications","Release Date: " + app.getReleaseDate());
            Log.d("ParseApplications","End Date: " + app.getEndDate());
        }
        return true;
    }
}
