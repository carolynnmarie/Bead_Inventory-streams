package io.carolynn.beadinventory.Beads;

public enum Quality {
    POOR("poor"), OKAY("okay"), GOOD("good"), EXCELLENT("excellent");

    String quality;

    Quality(String quality){
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }
}
