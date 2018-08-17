package io.carolynn.beadinventory.Beads;

import java.io.Serializable;

public class Bead implements Serializable {

    private Material material;
    private ColorFamily colorFamily;
    private String colorShade;
    private int sizeMM;
    private Shape shape;
    private String description;
    private Quality quality;
    private int quantity;
    private String id;


    public Bead(){ }

    public Bead(Material material, ColorFamily colorFamily, String colorShade, int sizeMM, Shape shape, String description,
                Quality quality, int quantity){
        this.material = material;
        this.colorFamily = colorFamily;
        this.colorShade = colorShade;
        this.sizeMM = sizeMM;
        this.shape = shape;
        this.description = description;
        this.quality = quality;
        this.quantity = quantity;
        this.id = material.getId() + colorFamily.getId() + colorShade + sizeMM + shape.getId();
    }

    public Material getMaterial() {
        return material;
    }
    public MaterialCategories getMaterialCategory(){
        return material.getCategory();
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getColorShade() {
        return colorShade;
    }

    public void setColorShade(String colorShade) {
        this.colorShade = colorShade;
    }

    public int getSizeMM() {
        return sizeMM;
    }

    public void setSizeMM(int sizeMM) {
        this.sizeMM = sizeMM;
    }

    public String getShape() {
        return shape.getShape();
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuality() {
        return quality.getQuality();
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public ColorFamily getColorFamily() {
        return colorFamily;
    }

    public void setColorFamily(ColorFamily colorFamily) {
        this.colorFamily = colorFamily;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%-24s Color: %-6s %-13s Size: %-3d Shape: %-20s Quality: %-6s  Quantity: %-5d Id: %-21s, Desc: %-40s",
                material.getMaterial(),colorFamily.getColor(),colorShade,sizeMM,shape.getShape(),quality.getQuality(),
                quantity,id,description);

    }
}
