package dev.amalendu.projectservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    //P: G
    //l to r -->1: 1
    //r to l -->M: 1
    //Ans =>    m: 1
    @ManyToOne
    private Category category;
    private double price;

    Product(String title, String description, String image, Category category, double price) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private String title;
        private String description;
        private String image;
        private Category category;
        private double price;

        ProductBuilder() {
        }

        public ProductBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder image(String image) {
            this.image = image;
            return this;
        }

        public ProductBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public ProductBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this.title, this.description, this.image, this.category, this.price);
        }

        public String toString() {
            return "Product.ProductBuilder(title=" + this.title + ", description=" + this.description + ", image=" + this.image + ", category=" + this.category + ", price=" + this.price + ")";
        }
    }
}
