package com.example.mymusic;

public class Music {
    private String name;
    private String artist1;
    private String artist2;
    private String artist3;
    private boolean isplaying;
    private int thumbnail;

    public Music(String name, String artist1, String artist2, String artist3, boolean isplaying, int thumbnail) {
        this.thumbnail = thumbnail;
        this.name = name;
        this.artist1 = artist1;
        this.artist2 = artist2;
        this.artist3 = artist3;
        this.isplaying = isplaying;
    }

    public String getName() {
        return name;
    }

    public boolean getIsplaying() {
        return isplaying;
    }

    public void setIsplaying(boolean isplaying) {
        this.isplaying = isplaying;
    }

    public String getAllAuthors() {
        String[] arr = new String[3];
        arr[0] = artist1;
        arr[1] = artist2;
        arr[2] = artist3;
        String ans = "";
        if (arr[0] == null) {
            ans = "Unknown";
        } else if (arr[1] == null) {
            ans += arr[0];
        } else if (arr[2] == null) {
            ans += arr[0] + ", " + arr[1];
        } else {
            ans += arr[0] + ", " + arr[1] + ", " + arr[2];
        }
        return ans;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}
