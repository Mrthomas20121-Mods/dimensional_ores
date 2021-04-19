package stardust_binding.dimensional_ores.ore;

import stardust_binding.dimensional_ores.config.Json;
import stardust_binding.dimensional_ores.config.JsonMetal;

public enum Metal {
    ARDITE,
    ALUMINUM,
    COPPER,
    COBALT,
    LEAD,
    NICKEL,
    PLATINUM,
    SILVER,
    TIN,
    OSMIUM,
    URANIUM;

    public JsonMetal getProperties() {
        if(!Json.metals.isEmpty()) {
            return Json.metals.stream().filter(jsonMetal -> jsonMetal.getName().equals(this.name().toLowerCase())).findFirst().get();
        }
        return null;
    }
}
