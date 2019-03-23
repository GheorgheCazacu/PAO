package com.fmi.laborator;

import com.fmi.laborator.geometric.Triangle;
import com.fmi.laborator.geometric.TriangleScalene;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Triangle triangle = new TriangleScalene("name", "description",
                3d, 4d, 5d);

        System.out.println("area: " + triangle.getArea());
        System.out.println("perimeter: " + triangle.getPerimeter());


    }
}
