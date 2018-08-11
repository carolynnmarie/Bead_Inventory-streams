package io.carolynn.beadinventory.Beads;

import static io.carolynn.beadinventory.Beads.MaterialCategories.*;

public enum Material {

    SHELL("shell", NATURAL_STONE,1),
    HOWLITE("howlite", NATURAL_STONE,2),
    TURQUISE("turquise", NATURAL_STONE,3),
    BONE("bone", NATURAL_STONE,4),
    UNAKITE("unakite", NATURAL_STONE,5),
    PEARL("pearl", NATURAL_STONE,6),
    MOTHER_OF_PEARL("mother of pearl", NATURAL_STONE,7),
    BAMBOO_CORAL("bamboo coral", NATURAL_STONE,8),
    HEMATITE("hematite", NATURAL_STONE,9),
    TIGER_EYE("tiger eye", NATURAL_STONE,10),
    MAGNESITE("magnesite", NATURAL_STONE,11),
    STONE("stone", NATURAL_STONE,12),

    AMETHYST("amethyst", SEMI_PRECIOUS_STONE,13),
    ADVENTURINE("adventurine", SEMI_PRECIOUS_STONE,14),
    BLUE_ADVENTURINE("blue adventurine", SEMI_PRECIOUS_STONE,15),
    SERPENTINE("serpentine", SEMI_PRECIOUS_STONE,16),
    JASPER("jasper", SEMI_PRECIOUS_STONE,17),
    QUARTZITE("quartzite", SEMI_PRECIOUS_STONE,18),
    AGATE("agate", SEMI_PRECIOUS_STONE,19),

    COPPER("copper", METAL,20),
    BRASS("brass", METAL,21),
    GUN_METAL_GREY("gun metal grey", METAL,22),
    DULL_SILVER_PLATED("dull silver plated", METAL,23),
    BRIGHT_SILVER_PLATED("bright silver plated", METAL,24),
    GOLD_TONED_PLATED("gold toned plated", METAL,25),
    STERLING_SILVER_PLATED("925 sterling silver plated", PRECIOUS_METAL,26),
    FULL_STERLING_SILVER("925 sterling silver plated", PRECIOUS_METAL,27),
    GOLD("gold", PRECIOUS_METAL,28),
    GOLD_PLATED("gold plated", PRECIOUS_METAL,29),
    STAINLESS_STEEL("stainless steel", METAL,30),

    GLASS("glass", MaterialCategories.GLASS,31),
    CRYSTAL("crystal", MaterialCategories.GLASS,32),
    SWAROVSKI_CRYSTAL("swarovski crystal", MaterialCategories.GLASS,33),
    GLASS_PEARL("glass pearl", MaterialCategories.GLASS,34),


    PAPER("paper", OTHER,35),
    CERAMIC("ceramic", OTHER,36),
    ACRYLIC("acrylic", OTHER,37),
    WOOD("wood", OTHER,38),
    PLASTIC("plastic", OTHER,39);



    String material;
    MaterialCategories category;
    int id;

    Material(String material, MaterialCategories category, int id){
        this.material = material;
        this.category = category;
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public MaterialCategories getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }
}
