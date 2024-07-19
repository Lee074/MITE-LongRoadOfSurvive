package net.oilcake.mitelros.world.biome;

import java.util.List;
import java.util.Random;
import net.minecraft.BiomeGenBase;
import net.minecraft.BiomeGenUnderworld;
import net.minecraft.Block;
import net.minecraft.BlockMushroomCap;
import net.minecraft.ChunkPost;
import net.minecraft.ChunkPostField;
import net.minecraft.EntityBoneLord;
import net.minecraft.EntityCreeper;
import net.minecraft.EntityGhoul;
import net.minecraft.EntityRevenant;
import net.minecraft.EntitySkeleton;
import net.minecraft.EntityZombie;
import net.minecraft.MathHelper;
import net.minecraft.Minecraft;
import net.minecraft.SpawnListEntry;
import net.minecraft.World;
import net.oilcake.mitelros.entity.EntityBoneBodyguard;
import net.oilcake.mitelros.entity.EntityRetinueZombie;
import net.oilcake.mitelros.entity.EntitySpiderKing;
import net.oilcake.mitelros.entity.EntityStalkerCreeper;
import net.oilcake.mitelros.world.WorldGenAzurite;
import net.oilcake.mitelros.world.WorldGenUnderworldCastle;

public class BiomeGenUnderworldInFreeze extends BiomeGenUnderworld {
   public BiomeGenUnderworldInFreeze(int id) {
      super(id);
      this.removeEntityFromSpawnableLists(EntitySkeleton.class);
      this.removeEntityFromSpawnableLists(EntityZombie.class);
      this.removeEntityFromSpawnableLists(EntityGhoul.class);
      this.removeEntityFromSpawnableLists(EntityRevenant.class);
      this.removeEntityFromSpawnableLists(EntityBoneLord.class);
      this.removeEntityFromSpawnableLists(EntityCreeper.class);
      this.removeEntityFromSpawnableLists(EntityBoneBodyguard.class);
      this.removeEntityFromSpawnableLists(EntityRetinueZombie.class);
      this.spawnableMonsterList.add(new SpawnListEntry(EntityStalkerCreeper.class, 100, 1, 2));
      this.spawnableMonsterList.add(new SpawnListEntry(EntitySpiderKing.class, 5, 1, 1));
      this.setColor(10526880);
      this.setBiomeName("Underworld?");
      this.setEnableSnow();
      this.setMinMaxHeight(0.9F, 4.0F);
      this.setTemperatureRainfall(0.0F, 0.5F);
   }

   private void placeMycelium(World world, int chunk_origin_x, int chunk_origin_z) {
      ChunkPostField mycelium_posts = world.getMyceliumPostField();
      Random random = new Random();

      for(int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
         for(int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
            List posts = mycelium_posts.getNearbyPostsForBlockCoords(x, z);

            for(int i = 0; i < posts.size(); ++i) {
               ChunkPost post = (ChunkPost)posts.get(i);
               if (!(post.getDistanceSqFromBlockCoords(x, z) > (double)(mycelium_posts.getPostMaxRadiusOfEffectSq() + 4))) {
                  random.setSeed(post.getSeed());
                  random.nextInt();
                  int y = random.nextInt(random.nextBoolean() ? 16 : 72) + 24;
                  y += world.underworld_y_offset;
                  int height = random.nextInt(5) + 1;

                  for(int dy = 0; dy < height; ++dy) {
                     if (world.isAirBlock(x, y + 1, z)) {
                        Block block = world.getBlock(x, y, z);
                        if (block != null && block.isAlwaysSolidOpaqueStandardFormCube() && !(block instanceof BlockMushroomCap)) {
                           block = world.getBlock(x, y - 1, z);
                           if (block != null && block.isAlwaysSolidOpaqueStandardFormCube() && world.setBlock(x, y, z, Block.mycelium.blockID, 0, 2)) {
                              world.getChunkFromBlockCoords(x, z).setHadNaturallyOccurringMycelium();
                              random.setSeed(post.getSeed() + (long)MathHelper.getIntPairHash(x, z));
                              random.nextInt();
                           }
                        }
                        break;
                     }

                     ++y;
                  }
               }
            }
         }
      }

   }

   public void decorate(World par1World, Random par2Random, int par3, int par4) {
      this.placeMycelium(par1World, par3, par4);
      super.decorate(par1World, par2Random, par3, par4);
      int var5;
      int var6;
      if (par2Random.nextInt(256) == 0) {
         if (par2Random.nextInt(16) == 0) {
            var5 = par3 + par2Random.nextInt(16) + 8;
            var6 = par4 + par2Random.nextInt(16) + 8;
            WorldGenUnderworldCastle var7 = new WorldGenUnderworldCastle();
            if (var7.generate(par1World, par2Random, var5, par1World.getHeightValue(var5, var6) + 1, var6) && Minecraft.inDevMode()) {
               System.out.println("Generate Castle at " + var5 + " " + var6 + ".");
            }
         } else {
            var5 = par3 + par2Random.nextInt(16) + 8;
            var6 = par4 + par2Random.nextInt(16) + 8;
            WorldGenAzurite var7 = new WorldGenAzurite();
            if (par2Random.nextInt(8) == 0) {
               var7.setSuperLarge();
               if (var7.generate(par1World, par2Random, var5, par1World.getHeightValue(var5, var6) + 1, var6) && Minecraft.inDevMode()) {
                  System.out.println("Generate Azurite at " + var5 + " " + var6 + " , superlarge.");
               }
            } else if (var7.generate(par1World, par2Random, var5, par1World.getHeightValue(var5, var6) + 1, var6) && Minecraft.inDevMode()) {
               System.out.println("Generate Azurite at " + var5 + " " + var6);
            }
         }
      }

      var5 = 3 + par2Random.nextInt(6);

      for(var6 = 0; var6 < var5; ++var6) {
         int count = par3 + par2Random.nextInt(4);
         int temp = par2Random.nextInt(255);
         int x = par4 + par2Random.nextInt(16);
         int y = par1World.getBlockId(count, temp, x);
         if (y == Block.stone.blockID) {
            par1World.setBlock(count, temp, x, Block.oreEmerald.blockID, 0, 2);
         }
      }

   }

   private BiomeGenBase setMinMaxHeight(float par1, float par2) {
      this.minHeight = par1;
      this.maxHeight = par2;
      return this;
   }

   private BiomeGenBase setTemperatureRainfall(float par1, float par2) {
      if (par1 > 0.1F && par1 < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      } else {
         this.temperature = par1;
         this.rainfall = par2;
         return this;
      }
   }
}
