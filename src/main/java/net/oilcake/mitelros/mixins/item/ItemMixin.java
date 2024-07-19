package net.oilcake.mitelros.mixins.item;

import java.io.PrintStream;
import java.util.List;
import net.minecraft.Block;
import net.minecraft.CreativeTabs;
import net.minecraft.EntityPlayer;
import net.minecraft.EnumChatFormatting;
import net.minecraft.IRecipe;
import net.minecraft.Item;
import net.minecraft.ItemBlock;
import net.minecraft.ItemStack;
import net.minecraft.Material;
import net.minecraft.Slot;
import net.minecraft.Translator;
import net.oilcake.mitelros.item.Items;
import net.oilcake.mitelros.item.Materials;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Item.class})
public class ItemMixin {
   private int water;
   public Item item;
   @Shadow
   protected List materials;
   @Shadow
   private List crafting_products_this_is_component_of;
   @Shadow
   private int satiation;
   @Shadow
   private int nutrition;
   @Shadow
   private int sugar_content;
   @Shadow
   private boolean has_protein;
   @Shadow
   private boolean has_essential_fats;
   @Shadow
   private boolean has_phytonutrients;
   @Shadow
   private String potionEffect;
   @Shadow
   public IRecipe[] recipes;

   @Inject(
      method = {"<init>()V"},
      at = {@At("RETURN")}
   )
   private void injectCtor(CallbackInfo callbackInfo) {
      ReflectHelper.dyCast(Item.class, this).recipes = new IRecipe[1024];
   }

   @Redirect(
      method = {"<init>(ILjava/lang/String;I)V"},
      at = @At(
   value = "INVOKE",
   target = "Ljava/io/PrintStream;println(Ljava/lang/String;)V"
)
   )
   public void removePrint(PrintStream printStream, String messsage) {
   }

   @Redirect(
      method = {"doesSubtypeMatterForProduct(Lnet/minecraft/ItemStack;)Z"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/Minecraft;setErrorMessage(Ljava/lang/String;)V"
)
   )
   public void removeErrorInfo(String text) {
   }

   @Inject(
      method = {"<init>(ILjava/lang/String;I)V"},
      at = {@At("RETURN")}
   )
   private void ItemInject(int par1, String texture, int num_subtypes, CallbackInfo callbackInfo) {
      ReflectHelper.dyCast(Item.class, this).recipes = new IRecipe[1024];
   }

   public final Item setFoodValueForWather(int satiation, int nutrition, int sugar_content, boolean has_protein, boolean has_essential_fats, boolean has_phytonutrients, int water) {
      this.satiation = satiation;
      this.nutrition = nutrition;
      this.sugar_content = sugar_content;
      this.has_protein = has_protein;
      this.has_essential_fats = has_essential_fats;
      this.has_phytonutrients = has_phytonutrients;
      this.water = water;
      if (satiation > 0 || nutrition > 0) {
         this.setCreativeTab(CreativeTabs.tabFood);
      }

      return this.item;
   }

   public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
      if (extended_info) {
         int satiation = this.getSatiation(player);
         int nutrition = this.getNutrition();
         int water = this.getWater();
         if (this.satiation > 0 || nutrition > 0) {
            info.add("");
            if (this.item instanceof ItemBlock) {
               ItemBlock item_block = (ItemBlock)this.item;
               if (item_block.getBlock() == Block.mushroomRed) {
                  info.add(EnumChatFormatting.RED + Translator.getFormatted("item.tooltip.satiation", new Object[]{satiation}));
                  info.add(EnumChatFormatting.RED + Translator.getFormatted("item.tooltip.nutrition", new Object[]{nutrition}));
                  return;
               }
            }

            if (this.satiation > 0) {
               info.add((this.sugar_content > 0 && player.isInsulinResistant() ? player.getInsulinResistanceLevel().getColorC() : EnumChatFormatting.LIGHT_GRAY) + Translator.getFormatted("item.tooltip.satiation", new Object[]{satiation}));
            }

            if (nutrition > 0) {
               info.add(EnumChatFormatting.LIGHT_GRAY + Translator.getFormatted("item.tooltip.nutrition", new Object[]{nutrition}));
            }
         }

         if (this.water != 0) {
            if (this.water < 0) {
               info.add(EnumChatFormatting.YELLOW + Translator.getFormatted("item.tooltip.water.minus", new Object[]{water}));
            } else {
               info.add(EnumChatFormatting.AQUA + Translator.getFormatted("item.tooltip.water.add", new Object[]{water}));
            }
         }
      }

   }

   public final int getWater() {
      return this.water;
   }

   public Item setWater(int water) {
      this.water = water;
      return this.item;
   }

   public void setPotionEffectC(String par1Str) {
      this.setPotionEffect(par1Str);
   }

   @Overwrite
   public Item getRepairItem() {
      Material material_for_repairs = this.getMaterialForRepairs();
      if (material_for_repairs == Material.copper) {
         return Item.copperNugget;
      } else if (material_for_repairs == Material.silver) {
         return Item.silverNugget;
      } else if (material_for_repairs == Materials.wolf_fur) {
         return Items.Wolf_fur;
      } else if (material_for_repairs == Material.gold) {
         return Item.goldNugget;
      } else if (material_for_repairs != Material.iron && material_for_repairs != Material.rusted_iron) {
         if (material_for_repairs == Material.mithril) {
            return Item.mithrilNugget;
         } else if (material_for_repairs == Material.adamantium) {
            return Item.adamantiumNugget;
         } else if (material_for_repairs == Materials.nickel) {
            return Items.nickelNugget;
         } else if (material_for_repairs == Materials.tungsten) {
            return Items.tungstenNugget;
         } else if (material_for_repairs == Materials.ancient_metal_sacred) {
            return Items.AncientmetalArmorPiece;
         } else if (material_for_repairs == Materials.uru) {
            return Items.UruNugget;
         } else {
            return material_for_repairs == Material.ancient_metal ? Item.ancientMetalNugget : null;
         }
      } else {
         return Item.ironNugget;
      }
   }

   @Shadow
   public Material getMaterialForRepairs() {
      return null;
   }

   @Shadow
   public Material getMaterial(int index) {
      return null;
   }

   @Shadow
   protected Item setPotionEffect(String par1Str) {
      return this.item;
   }

   public String getResourceLocationPrefix() {
      return "";
   }

   public float getStrVsBlock(Block block, int metadata, ItemStack itemStack, EntityPlayer user) {
      return 0.0F;
   }

   @Shadow
   public Item setCreativeTab(CreativeTabs table) {
      return null;
   }

   public void setCreativeTable(CreativeTabs table) {
      this.setCreativeTab(table);
   }

   @Shadow
   public Item setMaxStackSize(int maxStackSize) {
      return null;
   }

   public void setResourceLocation(String location) {
      this.setTextureName(location);
   }

   @Shadow
   public Item setTextureName(String location) {
      return null;
   }

   @Shadow
   @Final
   public int getSatiation(EntityPlayer player) {
      return 1;
   }

   @Shadow
   public int getNutrition() {
      return 1;
   }
}
