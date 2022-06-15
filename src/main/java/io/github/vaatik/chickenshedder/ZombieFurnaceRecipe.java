package io.github.vaatik.chickenshedder;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.Objects;

public class ZombieFurnaceRecipe implements Recipe {
    private static NamespacedKey ChickenShedderNamespace;
    private static Material zombieFlesh = null;
    private static Material leather = null;
    private static ItemStack recipeResult = null;
    private static FileConfiguration configuration;
    private static int cookingTime = 100;
    private static float experience = 0.1f;

    public ZombieFurnaceRecipe(ChickenShedder plugin) {
        ZombieFurnaceRecipe.configuration = plugin.getConfig();
        ZombieFurnaceRecipe.configuration.addDefault("zombieLeatherCookingTime", ZombieFurnaceRecipe.cookingTime);
        ZombieFurnaceRecipe.configuration.addDefault("zombieLeatherExperience", ZombieFurnaceRecipe.experience);
        ZombieFurnaceRecipe.configuration.addDefault("zombieLeatherEnabled", true);
        plugin.saveConfig();

        if(ZombieFurnaceRecipe.configuration.getBoolean("zombieLeatherEnabled")) {
            ZombieFurnaceRecipe.ChickenShedderNamespace = new NamespacedKey(plugin, "CHICKENSHEDDER");
            ZombieFurnaceRecipe.zombieFlesh = Material.getMaterial("ROTTEN_FLESH");
            ZombieFurnaceRecipe.leather = Material.getMaterial("LEATHER");
            assert ZombieFurnaceRecipe.leather != null;
            ZombieFurnaceRecipe.recipeResult = new ItemStack(ZombieFurnaceRecipe.leather);
            ZombieFurnaceRecipe.registerNewRecipe();
        }
    }

    public static FurnaceRecipe registerNewRecipe() {
        if(ZombieFurnaceRecipe.leather != null && ZombieFurnaceRecipe.zombieFlesh != null) {
            if(ZombieFurnaceRecipe.configuration.getInt("zombieLeatherCookingTime") != 100) {
                ZombieFurnaceRecipe.cookingTime = ZombieFurnaceRecipe.configuration.getInt("zombieLeatherCookingTime");
            }

            if(ZombieFurnaceRecipe.configuration.getString("zombieLeatherExperience") != null && !Objects.requireNonNull(ZombieFurnaceRecipe.configuration.getString("zombieLeatherExperience")).isEmpty()) {
                ZombieFurnaceRecipe.experience = Float.parseFloat(Objects.requireNonNull(ZombieFurnaceRecipe.configuration.getString("zombieLeatherExperience")));
            }

            return new FurnaceRecipe(
                    ZombieFurnaceRecipe.ChickenShedderNamespace,
                    ZombieFurnaceRecipe.recipeResult,
                    ZombieFurnaceRecipe.zombieFlesh,
                    ZombieFurnaceRecipe.experience,
                    ZombieFurnaceRecipe.cookingTime
            );
        }

        return null;
    }

    @Override
    public ItemStack getResult() {
        return new ItemStack(this.leather);
    }
}