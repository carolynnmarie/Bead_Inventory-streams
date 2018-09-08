package io.carolynn.beadinventory;

public enum MaterialCategories {

    NATURAL_STONE("stone"),
    SEMI_PRECIOUS_STONE("s-p stone"),
    METAL("metal"),
    PRECIOUS_METAL("precious metal"),
    GLASS("glass"),
    OTHER("other");

    String category;

    MaterialCategories(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
