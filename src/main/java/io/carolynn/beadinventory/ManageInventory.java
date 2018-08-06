package io.carolynn.beadinventory;

import java.util.*;
import java.util.stream.Collectors;

public class ManageInventory {

    ArrayList<Bead> inventory;
    Material [] materials;
    Shape [] shapes;
    Quality [] quality;
    Scanner input;

    public ManageInventory(ArrayList<Bead> inventory){
        this.inventory = inventory;
        this.materials = Material.values();
        this.shapes = Shape.values();
        this.quality = Quality.values();
        this.input = new Scanner(System.in);

    }

    public ManageInventory(){
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
    public void addBead(){
        Material material = getMaterial();
        String color = getColor();
        int size = getSize();
        Shape shape = getShape();
        String otherShape = "";
        if(shape.getShape().equals("other")){
            System.out.println("enter description of bead's shape");
            otherShape = input.nextLine();
        }
        String description = getDescription();
        Quality quality = getQuality();
        int quantity = getQuantity();
        int id = (int)inventory.get(inventory.size()-1).id +1;
        Bead bead = new Bead(material,color,size,shape,otherShape,description,quality,quantity,id);
        inventory.add(bead);
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

    public void changeQuantity(int id){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new quantity");
        int quantity = scanner.nextInt();
        for(Bead bead: inventory){
            if(bead.getId() == id){
                bead.setQuantity(quantity);
            }
        }
    }

}
