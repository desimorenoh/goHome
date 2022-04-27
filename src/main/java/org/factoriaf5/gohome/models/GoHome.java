package org.factoriaf5.gohome.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity 
@Table(name = "homes")
public class GoHome implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private int price;
    private int surface;
    private String description;
    private int bedrooms;

    public GoHome() {

    }

    public GoHome(String title, String image, int price, int surface, String description, int bedrooms) {
        this.title = title;
        this.image = image;
        this.price = price;
        this.surface = surface;
        this.description = description;
        this.bedrooms = bedrooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoHome goHome = (GoHome) o;
        return Objects.equals(id, goHome.id) && Objects.equals(title, goHome.title) && Objects.equals(image, goHome.image) && Objects.equals(price, goHome.price) && Objects.equals(surface, goHome.surface) && Objects.equals(description, goHome.description) && Objects.equals(bedrooms, goHome.bedrooms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, image, price, surface, description, bedrooms);
    }
}
