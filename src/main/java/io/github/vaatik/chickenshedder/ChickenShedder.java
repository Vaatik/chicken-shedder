package io.github.vaatik.chickenshedder;

import org.bukkit.plugin.java.JavaPlugin;

public class ChickenShedder extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getLogger().info("Chicken Shedder 1.2.0 for Minecraft Spigot 1.18.2 enabled");
        new ChickenShedderListener(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Chicken Shedder 1.2.0 for Minecraft Spigot 1.18.2 disabled");
    }
}