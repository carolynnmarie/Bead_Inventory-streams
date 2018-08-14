package io.carolynn.beadinventory.Beads;

import java.io.Serializable;

public class Bead implements Serializable {

    Material material;
    ColorFamily colorFamily;
    String colorShade;
    int sizeCM;
    Shape shape;
    String description;
    Quality quality;
    int quantity;


    public Bead(){ }

    public Bead(Material material, ColorFamily colorFamily, String colorShade, int sizeCM, Shape shape, String description,
                Quality quality, int quantity){
        this.material = material;
        this.colorFamily = colorFamily;
        this.colorShade = colorShade;
        this.sizeCM = sizeCM;
        this.shape = shape;
        this.description = description;
        this.quality = quality;
        this.quantity = quantity;

    }

    public String getMaterial() {
        return material.getMaterial();
    }
    public String getMaterialCategory(){
        return material.getCategory().getCategory();
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

    public int getSizeCM() {
        return sizeCM;
    }

    public void setSizeCM(int sizeCM) {
        this.sizeCM = sizeCM;
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

    @Override
    public String toString() {
        return "Material: " + material.getMaterial() + ", Color: " + colorShade + ", Size: " + sizeCM +
                ", Shape: " + shape.getShape() + ", Description: " + description + ", Quality: "
                + quality.getQuality() + ", Quantity: " + quantity;
    }
}
