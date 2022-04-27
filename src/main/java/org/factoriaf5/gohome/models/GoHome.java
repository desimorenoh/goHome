package org.factoriaf5.gohome.repositories;

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
    private String price;
    private String surface;
    private String description;
    private String bedrooms;

    public GoHome() {

    }

    public GoHome(String title, String image, String price, String surface, String description, String bedrooms) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
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