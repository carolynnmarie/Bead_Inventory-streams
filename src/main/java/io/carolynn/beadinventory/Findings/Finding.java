package io.carolynn.beadinventory.Findings;

import io.carolynn.beadinventory.Material;
import io.carolynn.beadinventory.Quality;

public class Finding {

    private FindingType findingType;
    private Material material;
    private Quality quality;
    private String description;

    public Finding(FindingType findingType, Material material, Quality quality, String description) {
        this.findingType = findingType;
        this.material = material;
        this.quality = quality;
        this.description = description;
    }

    public FindingType getFindingType() {
        return findingType;
    }

    public void setFindingType(FindingType findingType) {
        this.findingType = findingType;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }
}
