package io.github.vaatik.chickenshedder;

import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

public class ChickenShedder extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getLogger().info("Chicken Shedder 1.2.4 for Minecraft Spigot 1.20 enabled");
        new ChickenShedderListener(this);

        ZombieFurnaceRecipe leatherRecipe = new ZombieFurnaceRecipe(this);
        this.getServer().addRecipe(ZombieFurnaceRecipe.registerNewRecipe());
    }

    @Override
    public void onDisable() {
        getLogger().info("Chicken Shedder 1.2.3 for Minecraft Spigot 1.20 disabled");
    }
}