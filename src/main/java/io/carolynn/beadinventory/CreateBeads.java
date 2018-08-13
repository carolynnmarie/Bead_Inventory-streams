package io.carolynn.beadinventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.carolynn.beadinventory.Beads.Bead;
import io.carolynn.beadinventory.Beads.Material;
import io.carolynn.beadinventory.Beads.Quality;
import io.carolynn.beadinventory.Beads.Shape;

import java.util.*;
import java.util.stream.Collectors;

public class CreateBeads {

    ArrayList<Bead> inventory;
    Material[] materials;
    Shape[] shapes;
    Quality[] quality;
    Scanner input;


    public CreateBeads(ArrayList<Bead> inventory){
        this.inventory = inventory;
        this.materials = Material.values();
        this.shapes = Shape.values();
        this.quality = Quality.values();
        this.input = new Scanner(System.in);
    }

    public CreateBeads(){
        this.inventory = new ArrayList<>();
        this.materials = Material.values();
        this.shapes = Shape.values();
        this.quality = Quality.values();
        this.input = new Scanner(System.in);
    }


    public String printMaterials(){
        return Arrays.stream(materials).map(Material::getMaterial).collect(Collectors.joining("\n "));
    }

    public String printShapes(){
        return Arrays.stream(shapes).map(Shape::getShape).collect(Collectors.joining("\n"));
    }

    public String printQuality(){
        return Arrays.stream(quality).map(Quality::getQuality).collect(Collectors.joining("\n"));
    }
    public Bead addBead(){
        Material material = getMaterial();
        String color = getColor();
        int size = getSize();
        Shape shape = getShape();
        String description = getDescription();
        Quality quality = getQuality();
        int quantity = getQuantity();
        String id = "M" + material.getId() + ",Sh" + shape.getId() + ",Si" + size + ",C" + color;
        Bead bead = new Bead(material,color,size,shape,description,quality,quantity,id);
        return bead;
    }

    public Material getMaterial(){
        Material material = null;
        System.out.println("Enter material from list of choices:\n" + printMaterials());
        String in = input.nextLine().toLowerCase();
        for(Material item: materials){
            if(item.getMaterial().equals(in)){
                material = item;
            }
        }
        return material;
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
        Shape shape = null;
        System.out.println("Enter shape from list of choices:\n" + printShapes());
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
        Quality quality1 = null;
        System.out.println("Enter quality from list:\n" + printQuality());
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
