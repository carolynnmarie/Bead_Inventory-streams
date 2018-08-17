package io.carolynn.beadinventory.Beads;

public enum ColorFamily {

    BLUE("blue", "C1"),
    GREEN("green","C2"),
    YELLOW("yellow","C3"),
    RED("red","C4"),
    PURPLE("purple","C5"),
    PINK("pink", "C6"),
    TAN("tan","C7"),
    WHITE("white","C8"),
    BLACK("black","C9");


    private String color;
    private String id;

    ColorFamily(String color, String id){
        this.color = color;
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }
}
