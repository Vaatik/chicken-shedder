package io.github.vaatik.chickenshedder;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Chicken;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Random;


public class ChickenShedderListener implements Listener {
    private final ChickenShedder plugin;
    private final FileConfiguration configuration;

    public ChickenShedderListener(ChickenShedder plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        FileConfiguration config = plugin.getConfig();
        config.addDefault("featherAmount", 3);
        config.addDefault("usingDefaultConfig", false);
        plugin.saveConfig();
        this.configuration = config;
        this.plugin = plugin;

        new ZombieFurnaceRecipe(plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDrop(EntityDropItemEvent event) {

        World world = event.getEntity().getWorld();
        Location location = event.getEntity().getLocation();

        if(event.getEntity() instanceof Chicken) {
            Random rand = new Random();

            if (configuration.getBoolean("usingDefaultConfig")) {
                int randomNum = rand.nextInt((3 - 1) +1) + 1;
                ItemStack drop = new ItemStack(Objects.requireNonNull(Material.getMaterial("FEATHER")), randomNum);
                world.dropItem(location, drop);
            } else {
                int featherAmount = configuration.getInt("maxFeatherAmount");
                int randomNum = rand.nextInt((featherAmount - 1) +1) + 1;
                ItemStack drop = new ItemStack(Objects.requireNonNull(Material.getMaterial("FEATHER")), randomNum);
                world.dropItem(location, drop);
            }
        }
    }
}
