package io.github.vaatik.chickenshedder;
import org.bukkit.plugin.java.JavaPlugin;


public class ChickenShedder extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Chicken Shedder 1.18.1 enabled!");
        new ChickenShedderListener(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisabled is called!");
    }

}