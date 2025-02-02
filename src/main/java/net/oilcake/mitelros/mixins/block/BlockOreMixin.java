package net.oilcake.mitelros.mixins.block;

import net.minecraft.AchievementList;
import net.minecraft.BitHelper;
import net.minecraft.Block;
import net.minecraft.BlockBreakInfo;
import net.minecraft.BlockConstants;
import net.minecraft.BlockGoldOre;
import net.minecraft.BlockOre;
import net.minecraft.DedicatedServer;
import net.minecraft.EnchantmentHelper;
import net.minecraft.Entity;
import net.minecraft.EnumFace;
import net.minecraft.Item;
import net.minecraft.ItemBlock;
import net.minecraft.ItemStack;
import net.minecraft.Material;
import net.minecraft.World;
import net.oilcake.mitelros.block.Blocks;
import net.oilcake.mitelros.enchantment.Enchantments;
import net.oilcake.mitelros.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({BlockOre.class})
public class BlockOreMixin extends Block {
   protected BlockOreMixin(int par1, Material par2Material, BlockConstants constants) {
      super(par1, par2Material, constants);
   }

   @Overwrite
   public int dropBlockAsEntityItem(BlockBreakInfo info) {
      int metadata_dropped = -1;
      int quantity_dropped = 1;
      boolean HasAbsorb;
      int id_dropped;
      if (info.wasExploded()) {
         if (this == Block.oreEmerald) {
            id_dropped = -1;
         } else if (this == Block.oreDiamond) {
            id_dropped = -1;
         } else if (this == Block.oreLapis) {
            id_dropped = -1;
         } else if (this == Block.oreNetherQuartz) {
            id_dropped = -1;
         } else if (this == Block.oreCoal) {
            id_dropped = -1;
         } else if (this == Block.oreRedstone) {
            id_dropped = -1;
         } else if (this == Blocks.blockAzurite) {
            id_dropped = -1;
         } else if (this == Blocks.blockSulphur) {
            id_dropped = Items.sulphur.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Block.oreCopper) {
            id_dropped = Items.pieceCopper.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Block.oreSilver) {
            id_dropped = Items.pieceSilver.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Block.oreGold) {
            id_dropped = BlockGoldOre.isGoldOreNetherrack(this, 1) ? Items.pieceGoldNether.itemID : Items.pieceGold.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Block.oreIron) {
            id_dropped = Items.pieceIron.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Blocks.oreNickel) {
            id_dropped = Items.pieceNickel.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Block.oreMithril) {
            id_dropped = Items.pieceMithril.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Blocks.oreTungsten) {
            id_dropped = Items.pieceTungsten.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Block.oreAdamantium) {
            id_dropped = Items.pieceAdamantium.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else if (this == Blocks.oreUru) {
            id_dropped = Items.pieceUru.itemID;
            quantity_dropped = 1 + info.world.rand.nextInt(2);
         } else {
            id_dropped = this.blockID;
         }
      } else {
         HasAbsorb = EnchantmentHelper.hasEnchantment(info.responsible_item_stack, Enchantments.enchantmentAbsorb);
         if (this == Block.oreEmerald) {
            id_dropped = HasAbsorb ? 0 : Item.shardEmerald.itemID;
            info.getResponsiblePlayer().triggerAchievement(AchievementList.emeralds);
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreNetherQuartz) {
            id_dropped = HasAbsorb ? 0 : Item.shardNetherQuartz.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreDiamond) {
            id_dropped = HasAbsorb ? 0 : Item.shardDiamond.itemID;
            info.getResponsiblePlayer().triggerAchievement(AchievementList.diamonds);
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreLapis) {
            id_dropped = HasAbsorb ? 0 : Items.lapis.itemID;
            quantity_dropped = 2 + info.world.rand.nextInt(2);
         } else if (this == Block.oreCoal) {
            id_dropped = Item.coal.itemID;
         } else if (this == Block.oreRedstone) {
            id_dropped = Item.redstone.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(2);
         } else if (this == Blocks.blockAzurite) {
            id_dropped = Items.shardAzurite.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Blocks.blockSulphur) {
            id_dropped = Items.sulphur.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreCopper) {
            id_dropped = Items.pieceCopper.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreSilver) {
            id_dropped = Items.pieceSilver.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreGold) {
            id_dropped = Items.pieceGold.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreIron) {
            id_dropped = Items.pieceIron.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Blocks.oreNickel) {
            id_dropped = Items.pieceNickel.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreMithril) {
            id_dropped = Items.pieceMithril.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Blocks.oreTungsten) {
            id_dropped = Items.pieceTungsten.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Block.oreAdamantium) {
            id_dropped = Items.pieceAdamantium.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else if (this == Blocks.oreUru) {
            id_dropped = Items.pieceUru.itemID;
            quantity_dropped = 3 + info.world.rand.nextInt(5);
         } else {
            id_dropped = this.blockID;
         }
      }

      if (metadata_dropped == -1) {
         metadata_dropped = id_dropped == this.blockID ? this.getItemSubtype(info.getMetadata()) : 0;
      }

      HasAbsorb = id_dropped == this.blockID && BitHelper.isBitSet(info.getMetadata(), 1);
      if (id_dropped != -1 && info.getMetadata() == 0) {
         DedicatedServer.incrementTournamentScoringCounter(info.getResponsiblePlayer(), Item.getItem(id_dropped));
      }

      float chance = HasAbsorb ? 1.0F : 1.0F + (float)info.getHarvesterFortune() * 0.2F;
      if (EnchantmentHelper.hasEnchantment(info.responsible_item_stack, Enchantments.enchantmentAbsorb)) {
         if (this == Block.oreDiamond) {
            this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int)(530.0F * chance));
         } else if (this == Block.oreEmerald) {
            this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int)(270.0F * chance));
         } else if (this == Blocks.blockAzurite) {
            this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int)((float)((3 + info.world.rand.nextInt(5)) * 6) * chance));
         } else if (this == Block.oreNetherQuartz) {
            this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int)(60.0F * chance));
         } else if (this == Block.oreLapis) {
            this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int)((float)((3 + info.world.rand.nextInt(3)) * 30) * chance));
         }
      }

      boolean HasMelting = EnchantmentHelper.hasEnchantment(info.responsible_item_stack, Enchantments.enchantmentMelting);
      if (HasMelting) {
         float melting_chance = EnchantmentHelper.getEnchantmentLevelFraction(Enchantments.enchantmentMelting, info.responsible_item_stack);
         melting_chance *= (float)(info.responsible_item_stack.getItemAsTool().getMaterialHarvestLevel() - this.getMinHarvestLevel(0));
         if (info.world.rand.nextFloat() < melting_chance) {
            if (this == Block.oreCopper) {
               id_dropped = Item.copperNugget.itemID;
            } else if (this == Block.oreSilver) {
               id_dropped = Item.silverNugget.itemID;
            } else if (this == Block.oreGold) {
               id_dropped = Item.goldNugget.itemID;
            } else if (this == Block.oreIron) {
               id_dropped = Items.ironNugget.itemID;
            } else if (this == Blocks.oreNickel) {
               id_dropped = Items.nickelNugget.itemID;
            } else if (this == Block.oreMithril) {
               id_dropped = Item.mithrilNugget.itemID;
            } else if (this == Blocks.oreTungsten) {
               id_dropped = Items.tungstenNugget.itemID;
            } else if (this == Block.oreAdamantium) {
               id_dropped = Item.adamantiumNugget.itemID;
            } else if (this == Blocks.oreUru) {
               id_dropped = Items.UruNugget.itemID;
            }
         }
      }

      return super.dropBlockAsEntityItem(info, id_dropped, metadata_dropped, quantity_dropped, chance);
   }

   @Shadow
   public String getMetadataNotes() {
      return "1";
   }

   @Shadow
   public boolean isValidMetadata(int metadata) {
      return metadata >= 0 && metadata < 2;
   }

   @Shadow
   public void addItemBlockMaterials(ItemBlock item_block) {
   }

   @Shadow
   public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
      return 1;
   }
}
