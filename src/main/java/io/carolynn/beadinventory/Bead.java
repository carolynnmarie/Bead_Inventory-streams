package io.carolynn.beadinventory;

public class Bead {

    Material material;
    String color;
    int sizeCM;
    Shape shape;
    String shapeOther;
    String description;
    Quality quality;
    int quantity;
    long id;

    public Bead(){ }

    public Bead(Material material, String color, int sizeCM, Shape shape, String shapeOther, String description,
                Quality quality, int quantity, int id){
        this.material = material;
        this.color = color;
        this.sizeCM = sizeCM;
        this.shape = shape;
        this.shapeOther = shapeOther;
        this.description = description;
        this.quality = quality;
        this.quantity = quantity;
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getShapeOther() {
        return shapeOther;
    }

    public void setShapeOther(String shapeOther) {
        this.shapeOther = shapeOther;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Material: " + material.getMaterial() + ", Color: " + color + ", Size: " + sizeCM +
                ", Shape: " + shape.getShape() + ", Description: " + shapeOther + description + ", Quality: "
                + quality.getQuality() + ", Quantity: " + quantity;
    }
}
