package net.oilcake.mitelros.mixins.item.food;

import net.minecraft.*;
import net.oilcake.mitelros.item.Materials;
import net.oilcake.mitelros.util.StuckTagConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Random;

@Mixin(ItemFood.class)
public class ItemFoodMixin extends Item {

    @Shadow
    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {}

    public void onItemUseFinish(ItemStack item_stack, World world, EntityPlayer player) {
        if (player.onServer()) {
            if (this.hasMaterial(Material.fruit) && item_stack != Item.appleGold.getItemStackForStatsIcon()) {
                this.setWater(StuckTagConfig.TagConfig.TagDryDilemma.ConfigValue ? 1 : 3);
            }else if (this.hasMaterial(Material.vegetable) && item_stack!=Item.bakedPotato.getItemStackForStatsIcon() && item_stack!=Item.poisonousPotato.getItemStackForStatsIcon() || this.hasMaterial(Materials.mashedCactus)) {
                this.setWater(StuckTagConfig.TagConfig.TagDryDilemma.ConfigValue ? 1 : 2);
            }else if (this.hasMaterial(Materials.glowberries)) {
                Random rand = new Random();
                if(rand.nextDouble()<=(StuckTagConfig.TagConfig.TagDryDilemma.ConfigValue ? 0.5 : 1)){
                    this.setWater(1);
                } else{
                    this.setWater(0);
                }
            }else if(this.hasMaterial(Material.meat) || this.hasMaterial(Material.cheese)){
                this.setWater(-1);
            }else if(this.hasMaterial(Material.bread) || this.hasMaterial(Material.desert)){
                this.setWater(-2);
            }else if(this.hasMaterial(Materials.agave)){
                Random rand = new Random();
                if(rand.nextDouble()<=(StuckTagConfig.TagConfig.TagDryDilemma.ConfigValue ? 0.2 : 0.4)){
                    this.setWater(1);
                } else{
                    this.setWater(0);
                }
            }else{
                this.setWater(0);
            }

            player.addFoodValue(this);
            world.playSoundAtEntity(player, "random.burp", 0.5F, player.getRand().nextFloat() * 0.1F + 0.9F);
            this.onEaten(item_stack, world, player);
        }

        super.onItemUseFinish(item_stack, world, player);
    }
//    @Inject(method = "<init>",at = @At("RETURN"))
//    private void injectInit(CallbackInfo callback){
//        if (this.hasMaterial(Material.fruit)) {
//            this.setWater(2);
//        }else if(this.hasMaterial(Material.bread)){
//            this.setWater(-2);
//        }else if(this.hasMaterial(Material.desert)){
//            this.setWater(-2);
//        }else{
//            this.setWater(0);
//        }
//    }

}
