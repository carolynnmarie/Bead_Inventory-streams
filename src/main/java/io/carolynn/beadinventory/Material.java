package io.carolynn.beadinventory;

import static io.carolynn.beadinventory.MaterialCategories.*;

public enum Material {

    SHELL("shell", NATURAL_STONE),
    HOWLITE("howlite", NATURAL_STONE),
    TURQUISE("turquise", NATURAL_STONE),
    BONE("bone", NATURAL_STONE),
    UNAKITE("unakite", NATURAL_STONE),
    PEARL("pearl", NATURAL_STONE),
    MOTHER_OF_PEARL("mother of pearl", NATURAL_STONE),
    BAMBOO_CORAL("bamboo coral", NATURAL_STONE),
    HEMATITE("hematite", NATURAL_STONE),
    TIGER_EYE("tiger eye", NATURAL_STONE),
    MAGNESITE("magnesite", NATURAL_STONE),
    STONE("stone", NATURAL_STONE),

    AMETHYST("amethyst", SEMI_PRECIOUS_STONE),
    ADVENTURINE("adventurine", SEMI_PRECIOUS_STONE),
    BLUE_ADVENTURINE("blue adventurine", SEMI_PRECIOUS_STONE),
    SERPENTINE("serpentine", SEMI_PRECIOUS_STONE),
    JASPER("jasper", SEMI_PRECIOUS_STONE),
    QUARTZITE("quartzite", SEMI_PRECIOUS_STONE),
    AGATE("agate", SEMI_PRECIOUS_STONE),

    COPPER("copper", METAL),
    BRASS("brass", METAL),
    GUN_METAL_GREY("gun metal grey", METAL),
    DULL_SILVER_PLATED("dull silver plated", METAL),
    BRIGHT_SILVER_PLATED("bright silver plated", METAL),
    GOLD_TONED_PLATED("gold toned plated", METAL),
    STERLING_SILVER_PLATED("925 sterling silver plated", PRECIOUS_METAL),
    FULL_STERLING_SILVER("925 sterling silver plated", PRECIOUS_METAL),
    GOLD("gold", PRECIOUS_METAL),
    GOLD_PLATED("gold plated", PRECIOUS_METAL),
    STAINLESS_STEEL("stainless steel", METAL),

    GLASS("glass", MaterialCategories.GLASS),
    CRYSTAL("crystal", MaterialCategories.GLASS),
    SWAROVSKI_CRYSTAL("swarovski crystal", MaterialCategories.GLASS),
    GLASS_PEARL("glass pearl", MaterialCategories.GLASS),


    PAPER("paper", OTHER),
    CERAMIC("ceramic", OTHER),
    ACRYLIC("acrylic", OTHER),
    WOOD("wood", OTHER),
    PLASTIC("plastic", OTHER);



    String material;
    MaterialCategories category;

    Material(String material, MaterialCategories category){
        this.material = material;
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public MaterialCategories getCategory() {
        return category;
    }
}
