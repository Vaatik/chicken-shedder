package io.github.vaatik.chickenshedder;

import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

public class ChickenShedder extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getLogger().info("Chicken Shedder 1.2.1 for Minecraft Spigot 1.17.1 enabled");
        new ChickenShedderListener(this);

        ZombieFurnaceRecipe leatherRecipe = new ZombieFurnaceRecipe(this);
        this.getServer().addRecipe(ZombieFurnaceRecipe.registerNewRecipe());
    }

    @Override
    public void onDisable() {
        getLogger().info("Chicken Shedder 1.2.1 for Minecraft Spigot 1.17.1 disabled");
    }
}