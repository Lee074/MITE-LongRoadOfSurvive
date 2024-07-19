package net.oilcake.mitelros.mixins.block;

import net.minecraft.BlockVine;
import net.minecraft.IBlockAccess;
import net.oilcake.mitelros.util.SeasonColorizer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({BlockVine.class})
public class BlockVineMixin {
   @Overwrite
   public final int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      int OriColor = par1IBlockAccess.getBiomeGenForCoords(par2, par4).getBiomeFoliageColor();
      int MixedColor = SeasonColorizer.getSeasonColorizerModifierRed(par1IBlockAccess.getWorld(), OriColor >> 16);
      int FinalColor = '\uffff' & OriColor;
      FinalColor += MixedColor << 16;
      return FinalColor;
   }
}
