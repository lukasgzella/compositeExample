package org.example.testObjects;

import org.example.Block;

import java.util.Objects;

public class SingleBlock implements Block {
    private final String color;
    private final String material;

    public SingleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "SingleBlock{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleBlock that = (SingleBlock) o;
        return Objects.equals(color, that.color) && Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material);
    }
}
