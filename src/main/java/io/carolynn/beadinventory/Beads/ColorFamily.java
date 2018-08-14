package io.carolynn.beadinventory.Beads;

public enum ColorFamily {

    BLUE("blue"),GREEN("green"),YELLOW("yellow"),RED("red"),PURPLE("purple"),PINK("pink"),TAN("tan"),WHITE("white"), BLACK("black");


    String color;

    ColorFamily(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
