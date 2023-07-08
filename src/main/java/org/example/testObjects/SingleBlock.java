package org.example.testObjects;

import org.example.Block;

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
}
