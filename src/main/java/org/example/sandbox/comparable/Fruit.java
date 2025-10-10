package org.example.sandbox.comparable;

public class Fruit implements Comparable<Fruit> {

    private String name;
    private String color;
    private double weight;
    private double price;
    private int quantity;

    // No-argument constructor
    public Fruit() {

    }

    // Private constructor used by the Builder
    private Fruit(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.weight = builder.weight;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    // Copy constructor
    public Fruit(Fruit fruit) {
        this.name = fruit.name;
        this.color = fruit.color;
        this.weight = fruit.weight;
        this.price = fruit.price;
        this.quantity = fruit.quantity;
    }

    // Public constructor with all parameters
    public Fruit(String name, String color, double weight, double price, int quantity) {

        this.name = name;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fruit{");
        sb.append("name='").append(name).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Fruit that) {
        return this.name.compareTo(that.name);
    }

    public static Builder grower() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String color;
        private double weight;
        private double price;
        private int quantity;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder withPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Fruit build() {
            return new Fruit(this);
        }
    }
}
