package com.example.selenium4java17;

public class Image {
    private String thumb;
    private String small;
    private String large;

    // Getters and Setters
    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    // Optional: Override toString() for better output formatting
    @Override
    public String toString() {
        return "Image{" +
                "thumb='" + thumb + '\'' +
                ", small='" + small + '\'' +
                ", large='" + large + '\'' +
                '}';
    }
}

