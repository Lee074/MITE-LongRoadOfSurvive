package net.oilcake.mitelros.mixins.entity;

import net.minecraft.Damage;
import net.minecraft.EntityAnimal;
import net.minecraft.EntityLivestock;
import net.minecraft.NBTTagCompound;
import net.minecraft.World;
import net.oilcake.mitelros.util.DamageSourceExtend;
import net.oilcake.mitelros.util.ExperimentalConfig;
import net.xiaoyu233.fml.reload.transform.util.EntityLivestockAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityLivestock.class})
public abstract class EntityLivestockMixin extends EntityAnimal implements EntityLivestockAccessor {
   private int illnessToDeathCounter;

   public EntityLivestockMixin(World par1World) {
      super(par1World);
   }

   @Shadow
   private boolean isWell() {
      return false;
   }

   @Inject(
      method = {"onLivingUpdate()V"},
      at = {@At(
   value = "FIELD",
   shift = Shift.AFTER,
   target = "Lnet/minecraft/World;isRemote:Z",
   ordinal = 0
)}
   )
   private void injectIllnessToDeath(CallbackInfo c) {
      if (!this.isWell()) {
         if ((Boolean)ExperimentalConfig.TagConfig.Realistic.ConfigValue) {
            ++this.illnessToDeathCounter;
         }

         if (this.illnessToDeathCounter >= 12000) {
            this.attackEntityFrom(new Damage(DamageSourceExtend.malnourished, 1.0F));
            this.illnessToDeathCounter = 0;
         }
      } else if (this.illnessToDeathCounter > 0) {
         --this.illnessToDeathCounter;
      }

   }

   @Inject(
      method = {"readNBT"},
      at = {@At("RETURN")}
   )
   public void injectReadNBT(NBTTagCompound par1NBTTagCompound, CallbackInfo callbackInfo) {
      this.illnessToDeathCounter = par1NBTTagCompound.getInteger("illnessToDeathCounter");
   }

   @Inject(
      method = {"writeNBT"},
      at = {@At("RETURN")}
   )
   public void injectWriteNBT(NBTTagCompound par1NBTTagCompound, CallbackInfo callbackInfo) {
      par1NBTTagCompound.setInteger("illnessToDeathCounter", this.illnessToDeathCounter);
   }
}
