package net.oilcake.mitelros.mixins.item;

import net.minecraft.Material;
import net.oilcake.mitelros.item.Materials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({Material.class})
public class MaterialMixin {
   @Shadow
   protected float durability;
   @Shadow
   protected int min_harvest_level;
   @Shadow
   protected String name;
   @Shadow
   private boolean requires_tool;

   public Material setRequiresToolC() {
      return this.setRequiresTool();
   }

   @Shadow
   protected Material setRequiresTool() {
      return null;
   }

   public float getDurability() {
      return this.durability;
   }

   public int getMinHarvestLevel() {
      return this.min_harvest_level;
   }

   public String getName() {
      return this.name;
   }

   public Material classifyMaterialForm(Material material) {
      return material != Material.water && material != Materials.unsafe_water && material != Materials.dangerous_water ? material : Material.water;
   }
}
