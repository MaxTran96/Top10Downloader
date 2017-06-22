package com.example.max.top10downloader;

/**
 * Created by max on 3/18/2017.
 */
public class Application {
    private String title;
    private String num_Episodes;
    private String releaseDate;
    private String endDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNum_Episodes() {
        return num_Episodes;
    }

    public void setNum_Episodes(String episodes) {
        this.num_Episodes = episodes;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + "\n" +
                "Number of episodes: " + getNum_Episodes() + "\n" +
                "Release Date: " + getReleaseDate() + "\n" +
                "End date: " + getEndDate() +"\n";
    }
}
