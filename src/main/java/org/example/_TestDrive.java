package org.example;

import org.example.testObjects.SingleBlock;

public class _TestDrive {
    public static void main(String[] args) {
        // create some single blocks
        Block b1 = new SingleBlock("red", "ceramic");
        Block b2 = new SingleBlock("grey", "concrete");
        Block b3 = new SingleBlock("yellow", "plastic");
        Block b4 = new SingleBlock("blue", "plastic");
        Block b5 = new SingleBlock("transparent", "glass");
        Block b6 = new SingleBlock("green", "glass");
        Block b7 = new SingleBlock("orange", "ceramic");
        Block b8 = new SingleBlock("sandy", "concrete");

        // create some walls
        Wall plasticGlassWall = new Wall();
        Wall concreteCeramicWall = new Wall();
        Wall mixedWall = new Wall();

        // build these walls withs single blocks
        plasticGlassWall.add(b3);
        plasticGlassWall.add(b4);
        plasticGlassWall.add(b5);
        plasticGlassWall.add(b6);
        concreteCeramicWall.add(b1);
        concreteCeramicWall.add(b2);
        concreteCeramicWall.add(b7);
        concreteCeramicWall.add(b8);

        System.out.print("\nThis plasticGlassWall is made of : " + plasticGlassWall.getMaterial());
        System.out.println("; with colors : " + plasticGlassWall.getColor());
        System.out.print("\nThis ceramicConcreteWall is made of : " + concreteCeramicWall.getMaterial());
        System.out.println("; with colors : " + concreteCeramicWall.getColor());

        // merge two walls into one big wall
        mixedWall.add(plasticGlassWall);
        mixedWall.add(concreteCeramicWall);
        System.out.print("\nThis mixedWall is made of everything : " + mixedWall.getMaterial());
        System.out.println("; with all colors : " + mixedWall.getColor());

        // findByColor
        System.out.println(mixedWall.findBlockByColor("red").get());
        System.out.println(mixedWall.findBlockByColor("grey").get());
        System.out.println(mixedWall.findBlockByColor("yellow").get());
        System.out.println(mixedWall.findBlockByColor("blue").get());
        System.out.println(mixedWall.findBlockByColor("transparent").get());
        System.out.println(mixedWall.findBlockByColor("green").get());
        System.out.println(mixedWall.findBlockByColor("sandy").get());

        // findByMaterial
        System.out.println(mixedWall.findBlocksByMaterial("concrete"));
        System.out.println(mixedWall.findBlocksByMaterial("glass"));
        System.out.println(mixedWall.findBlocksByMaterial("plastic"));
        System.out.println(mixedWall.findBlocksByMaterial("ceramic"));

        // count
        System.out.println(mixedWall.count());
    }
}