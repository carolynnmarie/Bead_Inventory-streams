package io.carolynn.beadinventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.carolynn.beadinventory.Beads.*;

import java.util.*;
import java.util.stream.Collectors;

public class CreateBeads {

    ArrayList<Bead> inventory;

    Scanner input;


    public CreateBeads(ArrayList<Bead> inventory){
        this.inventory = inventory;
        this.input = new Scanner(System.in);
    }

    public CreateBeads(){
        this.inventory = new ArrayList<>();
        this.input = new Scanner(System.in);
    }


    public Bead beadFromUserInput(){
        Material material = getMaterial();
        ColorFamily colorFamily = getColorFamily();
        String colorShade = getColor();
        int size = getSize();
        Shape shape = getShape();
        String description = getDescription();
        Quality quality = getQuality();
        int quantity = getQuantity();
        Bead bead = new Bead(material,colorFamily,colorShade,size,shape,description,quality,quantity);
        return bead;
    }

    public Material getMaterial(){
        Material[] materials= Material.values();
        String x =Arrays.stream(materials).map(Material::getMaterial).collect(Collectors.joining("\n"));
        Material material = null;
        System.out.println("Enter material from list of choices:\n" + x);
        String in = input.nextLine().toLowerCase();
        for(Material item: materials){
            if(item.getMaterial().equals(in)){
                material = item;
            }
        }
        return material;
    }

    public ColorFamily getColorFamily(){
        ColorFamily[] colorFamily = ColorFamily.values();
        String x = Arrays.stream(colorFamily).map(ColorFamily::getColor).collect(Collectors.joining(", "));
        ColorFamily cFamily = null;
        System.out.println("Enter color family from list: " + x);
        String in = input.nextLine().toLowerCase();
        for(ColorFamily c: colorFamily){
            if(c.getColor().equals(in)){
                cFamily = c;
            }
        }
        return cFamily;
    }

    private String getColor(){
        System.out.println("Enter the color");
        return input.nextLine().toLowerCase();
    }

    private int getSize(){
        System.out.println("enter size in centimeters. If item is seed bead, enter 0");
        int size = input.nextInt();
        input.nextLine();
        return size;
    }

    private Shape getShape(){
        Shape[] shapes = Shape.values();
        String x = Arrays.stream(shapes).map(Shape::getShape).collect(Collectors.joining("\n"));
        Shape shape = null;
        System.out.println("Enter shape from list of choices:\n" + x);
        String shape1 = input.nextLine().toLowerCase();
        for(Shape item : shapes){
            if(item.getShape().equals(shape1)){
                shape = item;
            }
        }
        return shape;
    }

    private String getDescription(){
        System.out.println("enter description of any patterns, markings, or interesting features");
        return input.nextLine();
    }

    private Quality getQuality(){
        Quality[] quality = Quality.values();
        String x = Arrays.stream(quality).map(Quality::getQuality).collect(Collectors.joining("\n"));
        Quality quality1 = null;
        System.out.println("Enter quality from list:\n" + x);
        String in = input.nextLine().toLowerCase();
        for(Quality q: quality){
            if(q.getQuality().equals(in)){
                quality1 = q;
            }
        }
        return quality1;
    }

    private int getQuantity(){
        System.out.println("Enter the quantity");
        int x = input.nextInt();
        input.nextLine();
        return x;
    }



}
