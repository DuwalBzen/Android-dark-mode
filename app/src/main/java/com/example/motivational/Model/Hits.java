package com.example.motivational.Model;

public class Hits {
    private String largeImageURL;
    private int likes;
    private int views;
    private int downloads;
    private String webformatURL;
    private int favorites;
    private String tags;
    private String user;

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Hits{" +
                "largeImageURL='" + largeImageURL + '\'' +
                ", likes=" + likes +
                ", views=" + views +
                ", downloads=" + downloads +
                ", webformatURL='" + webformatURL + '\'' +
                ", favorites=" + favorites +
                ", tags='" + tags + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
