package net.oilcake.mitelros.block;

import java.util.Random;
import net.minecraft.BiomeGenBase;
import net.minecraft.BitHelper;
import net.minecraft.Block;
import net.minecraft.BlockBreakInfo;
import net.minecraft.BlockConstants;
import net.minecraft.CreativeTabs;
import net.minecraft.EnchantmentHelper;
import net.minecraft.Material;
import net.minecraft.World;
import net.oilcake.mitelros.enchantment.Enchantments;
import net.oilcake.mitelros.item.Items;

public class BlockCaveMisc extends Block {
   protected BlockCaveMisc(int id, Material material) {
      this(id, material, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
      this.setTickRandomly(true);
   }

   protected BlockCaveMisc(int id, Material material, BlockConstants constants) {
      super(id, material, constants);
      this.setTickRandomly(true);
      float var3 = 0.2F;
      this.setBlockBoundsForAllThreads((double)(0.5F - var3), 0.0, (double)(0.5F - var3), (double)(0.5F + var3), (double)(var3 * 3.0F), (double)(0.5F + var3));
      this.setMaxStackSize(32);
      this.setCreativeTab(CreativeTabs.tabDecorations);
   }

   public int getPatchSize(BiomeGenBase biome) {
      return 64;
   }

   public boolean isSolid(boolean[] is_solid, int metadata) {
      return false;
   }

   public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata) {
      return false;
   }

   public boolean onNotLegal(World world, int x, int y, int z, int metadata) {
      if (world.getClosestPlayer((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), 16.0, false) == null) {
         world.setBlockToAir(x, y, z);
         return true;
      } else {
         return super.onNotLegal(world, x, y, z, metadata);
      }
   }

   public int getRenderType() {
      return 1;
   }

   public boolean isLegalAt(World world, int x, int y, int z, int metadata) {
      return super.isLegalAt(world, x, y, z, metadata);
   }

   public boolean isLegalOn(int metadata, Block block_below, int block_below_metadata) {
      return block_below == dirt || block_below == stone || block_below == Blocks.blockAzurite;
   }

   public int dropBlockAsEntityItem(BlockBreakInfo info) {
      int metadata_dropped = 0;
      int quantity_dropped = 1;
      boolean HasAbsorb;
      int id_dropped;
      if (info.wasExploded()) {
         id_dropped = -1;
      } else {
         HasAbsorb = EnchantmentHelper.hasEnchantment(info.responsible_item_stack, Enchantments.enchantmentAbsorb);
         if (this == Blocks.azuriteCluster) {
            id_dropped = HasAbsorb ? 0 : Items.shardAzurite.itemID;
         } else {
            id_dropped = this.blockID;
         }
      }

      HasAbsorb = BitHelper.isBitSet(info.getMetadata(), 1);
      float chance = HasAbsorb ? 0.5F : 0.5F + (float)info.getHarvesterFortune() * 0.1F;
      if (EnchantmentHelper.hasEnchantment(info.responsible_item_stack, Enchantments.enchantmentAbsorb) && this == Blocks.azuriteCluster) {
         this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int)(6.0F * chance));
      }

      return super.dropBlockAsEntityItem(info, id_dropped, metadata_dropped, quantity_dropped, chance);
   }

   public boolean updateTick(World world, int x, int y, int z, Random random) {
      if (super.updateTick(world, x, y, z, random)) {
         return true;
      } else {
         int ran = random.nextInt(512);
         if (ran == 0) {
            boolean growable = true;

            int i;
            int j;
            for(i = -1; i < 1; i += 2) {
               for(j = -1; j < 1; j += 2) {
                  if (world.getBlockId(x + i, y, z + j) != this.blockID && random.nextInt(8) != 0) {
                     growable = false;
                  }
               }
            }

            if (growable) {
               for(i = -1; i < 1; i += 2) {
                  for(j = -1; j < 1; j += 2) {
                     if (world.getBlockId(x + i, y, z + j) == this.blockID) {
                        world.setBlockToAir(x + i, y, z + j);
                     }
                  }
               }

               world.setBlock(x, y, z, Blocks.blockAzurite.blockID, 0, 2);
            }
         }

         return false;
      }
   }
}
