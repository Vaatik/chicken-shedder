package io.github.vaatik.chickenshedder;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class ZombieFurnaceRecipe {
    private final NamespacedKey ChickenShedderNamespace;
    private final Material zombieFlesh;
    private final Material leather;
    private final ItemStack recipeResult;
    public ZombieFurnaceRecipe(ChickenShedder plugin) {
        this.ChickenShedderNamespace = new NamespacedKey(plugin, "CHICKENSHEDDER");
        this.zombieFlesh = Material.getMaterial("ROTTEN_FLESH");
        this.leather = Material.getMaterial("LEATHER");

        assert this.leather != null;
        this.recipeResult = new ItemStack(this.leather);
        this.registerNewRecipe();
    }

    public void registerNewRecipe() {
        if(this.leather != null && this.zombieFlesh != null) {
            int cookingTime = 100;
            float experience = 0.1f;
            FurnaceRecipe fleshToLeather = new FurnaceRecipe(
                    this.ChickenShedderNamespace,
                    this.recipeResult,
                    this.zombieFlesh,
                    experience,
                    cookingTime
            );
        }
    }
}
