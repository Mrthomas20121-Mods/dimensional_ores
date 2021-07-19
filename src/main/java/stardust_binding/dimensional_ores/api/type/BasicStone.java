package stardust_binding.dimensional_ores.api.type;

import java.util.ArrayList;

public class BasicStone extends Stone {

    public BasicStone(String stone_name, String modid, int dimension_id, String block_name) {
        super(stone_name, modid, dimension_id, block_name);
    }

    public BasicStone(String stone_name, String modid, int dimension_id) {
        super(stone_name, modid, dimension_id);
    }

    @Override
    public ArrayList<String> getBlacklist() {
        if(this.getName().contains("asteroids") || this.getModId().equals("moreplanets")) {
            this.ores.add("aluminum");
        }
        else if(this.getModId().contains("extraplanets") || this.getModId().contains("galacticraft")) {
            if(this.getName().equals("venus")) {
                this.ores.add("aluminum");
                this.ores.add("lead");
            }
            else {
                if(this.getName().equals("kepler22b")) {
                    this.ores.add("platinum");
                }
                else if(this.getName().equals("ceres")) {
                    this.ores.add("uranium");
                }
                this.ores.add("copper");
                this.ores.add("tin");
            }
        }
        else if(getModId().equals("zollerngalaxy")) {
            this.ores.add("tin");
            if(this.getName().equals("edenrock")) {
                this.ores.add("cobalt");
                this.ores.add("aluminum");
                this.ores.add("platinum");
                this.ores.add("lead");
                this.ores.add("nickel");
                this.ores.add("copper");
            }
            else if(this.getName().equals("oasisstone")) {
                this.ores.add("copper");
            }
            else if(this.getName().equals("purgstone")) {
                this.ores.add("copper");
                this.ores.add("lead");
                this.ores.add("cobalt");
                this.ores.add("aluminum");
            }
            else if(this.getName().equals("zolstone")) {
                this.ores.add("copper");
                this.ores.add("cobalt");
            }
            else if(this.getName().equals("xantheonstone")) {
                this.ores.add("copper");
                this.ores.add("nickel");
            }
        }
        return this.ores;
    }
}
