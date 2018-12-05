package io.carolynn.beadinventory.Inventory;

import io.carolynn.beadinventory.Findings.Finding;
import java.nio.file.Path;
import java.util.*;

public class FindingInventoryStorage {

    private Path filePath;
    private ArrayList<Finding> findings;

    public FindingInventoryStorage(Path filePath){
        this.findings = new ArrayList<>();
    }
}
