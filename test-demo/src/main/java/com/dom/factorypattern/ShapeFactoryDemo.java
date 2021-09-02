package com.dom.factorypattern;

public class ShapeFactoryDemo {

    public static void main(String[] args) {
        String shapeStr01 = "circle";
        String shapeStr02 = "square";
        String shapeStr03 = "rectangle";

        ShapeFactory.getShape(shapeStr01).draw();
        ShapeFactory.getShape(shapeStr02).draw();
        ShapeFactory.getShape(shapeStr03).draw();

    }

}
