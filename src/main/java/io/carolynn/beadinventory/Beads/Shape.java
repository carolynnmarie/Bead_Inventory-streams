package io.carolynn.beadinventory.Beads;

public enum Shape {

    ROUND("round",101),
    OVAL("oval",102),
    RONDELLE("rondelle",103),
    FLAT_ROUND("flat round",104),
    FLAT_OVAL("flat oval",105),
    SQUARE("square",106),
    RECTANGLE("rectangle",107),
    CUBE("cube",108),
    BICONE("bicone",109),
    DONUT("donut",110),
    DIAMOND("diamond",111),
    TEARDROP("teardrop",112),
    TUBE("tube",113),
    HEART("heart",114),
    FACETED_ROUND("faceted round",115),
    FACETED_RONDELLE("faceted rondelle",116),
    FACETED_OVAL("faceted oval",117),
    FACETED_BICONE("faceted bicone",118),
    FACETED_TEARDROP("faceted teardrop",119),
    T_D_FACETED_TEARDROP("top drilled faceted teardrop",120),
    T_D_PENDANT("top drilled pendant", 121),
    CHIP("chip",122),
    IRREGULAR("irregular",123),
    SEED_SMALL("small seed bead",124),
    SEED_E("E seed bead",125),
    SEED_E_LARGE("large E seed bead",126),
    SEED_TUBE("tube seed bead",127),

    OTHER("other",128);


    String shape;
    int id;

    Shape(String shape, int id){
        this.shape = shape;
        this.id = id;
    }

    public String getShape() {
        return shape;
    }

    public int getId(){
        return id;
    }
}
