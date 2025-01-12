package com.example.selenium4java17;

public class ImageRes {
    private Image image;

    // Getter and Setter
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    // Optional: Override toString() for better output formatting
    @Override
    public String toString() {
        return "Response{" +
                "image=" + image +
                '}';
    }
}

