package com.yliborio.demospring.entity;

import jakarta.persistence.*;




@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;


    @Column(name="price")
    private double price;

    @Column(name="description")
    private String description;

    @Column(name="category")
    private String category;


    @Column(name="image")
    private String image;

    @Column(name="rating_rate")
    private int rating_rate;

    @Column(name="rating_count")
    private int rating_count;

    // Getters and Setters (or use Lombok for getters and setters)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRating_rate() {
        return rating_rate;
    }

    public void setRating_rate(int rating_rate) {
        this.rating_rate = rating_rate;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating_rate=" + rating_rate +
                ", rating_count=" + rating_count +
                '}';
    }
}

