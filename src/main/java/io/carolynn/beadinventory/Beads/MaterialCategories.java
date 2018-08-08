package io.carolynn.beadinventory.Beads;

public enum MaterialCategories {

    NATURAL_STONE("natural stone"),
    SEMI_PRECIOUS_STONE("semi-precious stone"),
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
