package stardust_binding.dimensional_ores.api.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import stardust_binding.dimensional_ores.DimensionalOres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonConfig {

    private final Gson gson;
    private final String file_path;
    private JsonObject object;

    public JsonConfig(Gson gson, String file_path) {
        this.gson = gson;
        this.file_path = file_path;
    }

    /**
     * Read the config file
     */
    public void read() {
        try {
            FileReader fileReader = new FileReader(this.file_path);
            this.object = gson.fromJson(fileReader, JsonObject.class);
        }
        catch(FileNotFoundException e) {
            DimensionalOres.getLogger().error(e.getMessage());
        }
    }

    public JsonObject getAsJsonObject(String member) {
        return this.object.getAsJsonObject(member);
    }

    public String getAsString(String member) {
        return this.getAsElement(member).getAsString();
    }

    public int getAsInteger(String member) {
        return this.getAsElement(member).getAsInt();
    }

    public boolean getAsBoolean(String member) {
        return this.getAsElement(member).getAsBoolean();
    }

    public JsonElement getAsElement(String member) {
        return this.object.get(member);
    }

    /**
     * Create the config file if it doesn't exists already
     */
    public void create() {

    }


}
