package io.github.vaatik.chickenshedder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ChickenShedderListener implements Listener {
    private final ChickenShedder plugin;

    public ChickenShedderListener(ChickenShedder plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDrop(EntityDropItemEvent event) {

        World world = event.getEntity().getWorld();
        Location location = event.getEntity().getLocation();
        Item item = event.getItemDrop();

        if(event.getEntity() instanceof Chicken) {
            Random rand = new Random();
            int randomNum = rand.nextInt((3 - 1) +1) + 1;
            ItemStack drop = new ItemStack(Material.getMaterial("FEATHER"), randomNum);

            world.dropItem(location, drop);
        }
    }
}
