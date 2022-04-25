package io.github.vaatik.chickenshedder;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class ZombieFurnaceRecipe implements Recipe {
    private static NamespacedKey ChickenShedderNamespace;
    private static Material zombieFlesh = null;
    private static Material leather = null;
    private static ItemStack recipeResult = null;

    public ZombieFurnaceRecipe(ChickenShedder plugin) {
        ZombieFurnaceRecipe.ChickenShedderNamespace = new NamespacedKey(plugin, "CHICKENSHEDDER");
        ZombieFurnaceRecipe.zombieFlesh = Material.getMaterial("ROTTEN_FLESH");
        ZombieFurnaceRecipe.leather = Material.getMaterial("LEATHER");

        assert ZombieFurnaceRecipe.leather != null;
        ZombieFurnaceRecipe.recipeResult = new ItemStack(ZombieFurnaceRecipe.leather);
        ZombieFurnaceRecipe.registerNewRecipe();
    }

    public static FurnaceRecipe registerNewRecipe() {
        if(ZombieFurnaceRecipe.leather != null && ZombieFurnaceRecipe.zombieFlesh != null) {
            int cookingTime = 100;
            float experience = 0.1f;

            return new FurnaceRecipe(
                    ZombieFurnaceRecipe.ChickenShedderNamespace,
                    ZombieFurnaceRecipe.recipeResult,
                    ZombieFurnaceRecipe.zombieFlesh,
                    experience,
                    cookingTime
            );
        }

        return null;
    }

    @Override
    public ItemStack getResult() {
        return new ItemStack(this.leather);
    }
}