package net.oilcake.mitelros.item;

import net.oilcake.mitelros.block.Blocks;
import net.oilcake.mitelros.mixins.util.PotionBrewerMixin;
import net.oilcake.mitelros.util.Constant;
import net.oilcake.mitelros.util.RecipeRegister;
import net.oilcake.mitelros.util.ReflectHelper;
import net.minecraft.*;

import static net.xiaoyu233.fml.util.ReflectHelper.createInstance;

public class Items extends Item {
    public static final ItemArmor nickelHelmet = new ItemHelmet(Constant.getNextItemID(),Materials.nickel,false);
    public static final ItemArmor nickelChestplate = new ItemCuirass(Constant.getNextItemID(),Materials.nickel,false);
    public static final ItemArmor nickelLeggings = new ItemLeggings(Constant.getNextItemID(),Materials.nickel,false);
    public static final ItemArmor nickelBoots = new ItemBoots(Constant.getNextItemID(),Materials.nickel,false);
    public static final ItemArmor nickelHelmetChain = new ItemHelmet(Constant.getNextItemID(),Materials.nickel,true);
    public static final ItemArmor nickelChestplateChain = new ItemCuirass(Constant.getNextItemID(),Materials.nickel,true);
    public static final ItemArmor nickelLeggingsChain = new ItemLeggings(Constant.getNextItemID(),Materials.nickel,true);
    public static final ItemArmor nickelBootsChain = new ItemBoots(Constant.getNextItemID(),Materials.nickel,true);
    public static final ItemNugget nickelNugget = createInstance(ItemNugget.class, new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemAxe nickelAxe = createInstance(ItemAxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemBattleAxe nickelBattleAxe = createInstance(ItemBattleAxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemDagger nickelDagger = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final Item nickelIngot = createInstance(ItemIngot.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel).setXPReward(15);
    public static final ItemPickaxe nickelPickaxe = createInstance(ItemPickaxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemShovel nickelShovel = createInstance(ItemShovel.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemSword nickelSword = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Constant.getNextItemID(), Materials.nickel);
    public static final ItemWarHammer nickelWarHammer = createInstance(ItemWarHammer.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemHatchet nickelHatchet = createInstance(ItemHatchet.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemHoe nickelHoe = createInstance(ItemHoe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemKnife nickelKnife = createInstance(ItemKnife.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemMattock nickelMattock = createInstance(ItemMattock.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemScythe nickelScythe = createInstance(ItemScythe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemShears nickelShears = createInstance(ItemShears.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final Item doorNickel= new ItemDoor(Constant.getNextItemID(), Materials.nickel);
    public static final ItemChain nickelChain = createInstance(ItemChain.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.nickel);
    public static final ItemCoin nickelCoin = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, Constant.getNextItemID(), Materials.nickel);
    //public static final ItemArrow arrowNickel = new ItemArrow(Constant.getNextItemID(), Materials.nickel);
    public static final ItemArmor tungstenHelmet = new ItemHelmet(Constant.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor tungstenChestplate = new ItemCuirass(Constant.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor tungstenLeggings = new ItemLeggings(Constant.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor tungstenBoots = new ItemBoots(Constant.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor tungstenHelmetChain = new ItemHelmet(Constant.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor tungstenChestplateChain = new ItemCuirass(Constant.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor tungstenLeggingsChain = new ItemLeggings(Constant.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor tungstenBootsChain = new ItemBoots(Constant.getNextItemID(),Materials.tungsten,true);
    public static final ItemNugget tungstenNugget = createInstance(ItemNugget.class, new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemAxe tungstenAxe = createInstance(ItemAxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemBattleAxe tungstenBattleAxe = createInstance(ItemBattleAxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemDagger tungstenDagger = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final Item tungstenIngot = createInstance(ItemIngot.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten).setXPReward(75);
    public static final ItemPickaxe tungstenPickaxe = createInstance(ItemPickaxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemShovel tungstenShovel = createInstance(ItemShovel.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemSword tungstenSword = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Constant.getNextItemID(), Materials.tungsten);
    public static final ItemWarHammer tungstenWarHammer = createInstance(ItemWarHammer.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemHatchet tungstenHatchet = createInstance(ItemHatchet.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemHoe tungstenHoe = createInstance(ItemHoe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemKnife tungstenKnife = createInstance(ItemKnife.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemMattock tungstenMattock = createInstance(ItemMattock.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemScythe tungstenScythe = createInstance(ItemScythe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemShears tungstenShears = createInstance(ItemShears.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final Item doorTungsten= new ItemDoor(Constant.getNextItemID(), Materials.tungsten);
    public static final ItemChain tungstenChain = createInstance(ItemChain.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.tungsten);
    public static final ItemCoin tungstenCoin = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, Constant.getNextItemID(), Materials.tungsten);
    //public static final ItemArrow arrowTungsten = new ItemArrow(Constant.getNextItemID(), Materials.tungsten);

    public static final ItemBowl porkchopStew = (ItemBowl)(new ItemBowl(Constant.getNextItemID(), Materials.porkchop_stew, "porkchop_stew")).setFoodValue(14, 14, true, false, true).setPlantProduct().setAnimalProduct().setUnlocalizedName("porkchopStew");
    public static final ItemBowl chestnutSoup = (ItemBowl)(new ItemBowl(Constant.getNextItemID(), Materials.chestnut_soup, "lampchop_stew")).setFoodValue(12, 12, true, false, true).setPlantProduct().setAnimalProduct().setUnlocalizedName("lampchopStew");

    public static final ItemPieces pieceCopper = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceCopper").setXPReward(1));
    public static final ItemPieces pieceSilver = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceSilver").setXPReward(1));
    public static final ItemPieces pieceGold = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceGold").setXPReward(2));
    public static final ItemPieces pieceGoldNether = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceGoldNether").setXPReward(2));
    public static final ItemPieces pieceIron = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceIron").setXPReward(1));
    public static final ItemPieces pieceNickel = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceNickel").setXPReward(1));
    public static final ItemPieces pieceMithril = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceMithril").setXPReward(4));
    public static final ItemPieces pieceTungsten = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceTungsten").setXPReward(7));
    public static final ItemPieces pieceAdamantium = (ItemPieces) (new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceAdamantium").setXPReward(10));
//    public static PotionBrewer potionBrewer;
//    public static final Item test = (ItemPieces) new ItemPieces(Constant.getNextItemID(), Materials.orePieces, "pieceTungsten1").setPotionEffectC(potionBrewer.getAttackEffect());





        public static void registerItems() {
        register("armor/nickel_helmet", nickelHelmet);
        register("armor/nickel_chestplate", nickelChestplate);
        register("armor/nickel_leggings", nickelLeggings);
        register("armor/nickel_boots", nickelBoots);
        register("armor/nickel_chainmail_helmet", nickelHelmetChain);
        register("armor/nickel_chainmail_chestplate", nickelChestplateChain);
        register("armor/nickel_chainmail_leggings", nickelLeggingsChain);
        register("armor/nickel_chainmail_boots", nickelBootsChain);
        register("ingot/nickel", nickelIngot);
        register("ingot/nugget/nickel", nickelNugget);
        register("tool/nickel/nickel_axe", nickelAxe);
        register("tool/nickel/nickel_battle_axe", nickelBattleAxe);
        register("tool/nickel/nickel_dagger", nickelDagger);
        register("tool/nickel/nickel_hatchet", nickelHatchet);
        register("tool/nickel/nickel_hoe", nickelHoe);
        register("tool/nickel/nickel_knife", nickelKnife);
        register("tool/nickel/nickel_pickaxe", nickelPickaxe);
        register("tool/nickel/nickel_mattock", nickelMattock);
        register("tool/nickel/nickel_scythe", nickelScythe);
        register("tool/nickel/nickel_shears", nickelShears);
        register("tool/nickel/nickel_shovel", nickelShovel);
        register("tool/nickel/nickel_sword", nickelSword);
        register("tool/nickel/nickel_war_hammer", nickelWarHammer);
        register("door/nickel", doorNickel);
        register("chain/nickel", nickelChain);
        register("coin/nickel", nickelCoin);
        //register("arrows/nickel_arrow", arrowNickel);
        register("armor/tungsten_helmet", tungstenHelmet);
        register("armor/tungsten_chestplate", tungstenChestplate);
        register("armor/tungsten_leggings", tungstenLeggings);
        register("armor/tungsten_boots", tungstenBoots);
        register("armor/tungsten_chainmail_helmet", tungstenHelmetChain);
        register("armor/tungsten_chainmail_chestplate", tungstenChestplateChain);
        register("armor/tungsten_chainmail_leggings", tungstenLeggingsChain);
        register("armor/tungsten_chainmail_boots", tungstenBootsChain);
        register("ingot/tungsten", tungstenIngot);
        register("ingot/nugget/tungsten", tungstenNugget);
        register("tool/tungsten/tungsten_axe", tungstenAxe);
        register("tool/tungsten/tungsten_battle_axe", tungstenBattleAxe);
        register("tool/tungsten/tungsten_dagger", tungstenDagger);
        register("tool/tungsten/tungsten_hatchet", tungstenHatchet);
        register("tool/tungsten/tungsten_hoe", tungstenHoe);
        register("tool/tungsten/tungsten_knife", tungstenKnife);
        register("tool/tungsten/tungsten_pickaxe", tungstenPickaxe);
        register("tool/tungsten/tungsten_mattock", tungstenMattock);
        register("tool/tungsten/tungsten_scythe", tungstenScythe);
        register("tool/tungsten/tungsten_shears", tungstenShears);
        register("tool/tungsten/tungsten_shovel", tungstenShovel);
        register("tool/tungsten/tungsten_sword", tungstenSword);
        register("tool/tungsten/tungsten_war_hammer", tungstenWarHammer);
        register("door/tungsten", doorTungsten);
        register("chain/tungsten", tungstenChain);
        register("coin/tungsten", tungstenCoin);
        //register("arrows/tungsten_arrow", arrowTungsten);
        register("bowls/porkchop_stew",porkchopStew);
        register("bowls/lampchop_stew",chestnutSoup);
        register("pieces/copper",pieceCopper);
        register("pieces/silver",pieceSilver);
        register("pieces/gold",pieceGold);
        register("pieces/gold_nether",pieceGoldNether);
        register("pieces/iron",pieceIron);
        register("pieces/nickel",pieceNickel);
        register("pieces/tungsten",pieceTungsten);
        register("pieces/mithril",pieceMithril);
        register("pieces/adamantium",pieceAdamantium);



        Constant.initItemArray();
    }

    public static void registerRecipes(RecipeRegister register) {
//        register.registerShapedRecipe(new ItemStack(arrowNickel), false,
//                " C ",
//                " B ",
//                " A ",
//                'A', Item.feather,
//                'B', Item.stick,
//                'C', nickelNugget);
        register.registerShapedRecipe(new ItemStack(nickelChain), false,
                " A ",
                "A A",
                " A ",
                'A', nickelNugget);
        register.registerShapedRecipe(new ItemStack(nickelShears), false,
                " A ",
                "  A",
                "   ",
                'A', nickelIngot);
//        register.registerShapedRecipe(new ItemStack(nickelShears), false,
//                "  ",
//                "  A",
//                " A ",
//                'A', nickelIngot);
        register.registerShapedRecipe(new ItemStack(nickelScythe), false,
                "BA ",
                "B A",
                "B  ",
                'A', nickelIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelMattock), false,
                "AAA",
                " BA",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
//        register.registerShapedRecipe(new ItemStack(nickelKnife), false,
//                "AA",
//                " B ",
//                " B ",
//                'A', nickelIngot,
//                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelHoe), false,
                "AA ",
                " B ",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
//        register.registerShapedRecipe(new ItemStack(nickelHoe), false,
//                " AA",
//                " B ",
//                " B ",
//                'A', nickelIngot,
//                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelHatchet), false,
                "   ",
                " BA",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelWarHammer), false,
                "AAA",
                "ABA",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelSword), false,
                " A ",
                " A ",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelShovel), false,
                " A ",
                " B ",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelPickaxe), false,
                "AAA",
                " B ",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelDagger), false,
                "   ",
                " A ",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
//        register.registerShapedRecipe(new ItemStack(nickelDagger), false,
//                "   ",
//                " A ",
//                " B ",
//                'A', nickelIngot,
//                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelBattleAxe), false,
                "A A",
                "ABA",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(nickelAxe), false,
                "AA ",
                "AB ",
                " B ",
                'A', nickelIngot,
                'B', Item.stick);
//        register.registerShapedRecipe(new ItemStack(nickelAxe), false,
//                " AA",
//                " BA",
//                " B ",
//                'A', nickelIngot,
//                'B', Item.stick);
        register.registerShapelessRecipe(new ItemStack(nickelIngot, 9), false,
                Blocks.blockNickel);
        register.registerShapelessRecipe(new ItemStack(nickelNugget, 9), false,
                nickelIngot);
//        register.registerShapedRecipe(new ItemStack(nickelBootsChain), false,
//                "A A",
//                "A A",
//                "   ",
//                'A', nickelChain);
        register.registerShapedRecipe(new ItemStack(nickelBootsChain), false,
                "   ",
                "A A",
                "A A",
                'A', nickelChain);
        register.registerShapedRecipe(new ItemStack(nickelLeggingsChain), false,
                "AAA",
                "A A",
                "A A",
                'A', nickelChain);
        register.registerShapedRecipe(new ItemStack(nickelChestplateChain), false,
                "A A",
                "AAA",
                "AAA",
                'A', nickelChain);
        register.registerShapedRecipe(new ItemStack(nickelHelmetChain), false,
                "AAA",
                "A A",
                "   ",
                'A', nickelChain);
//        register.registerShapedRecipe(new ItemStack(nickelHelmetChain), false,
//                "   ",
//                "AAA",
//                "A A",
//                'A', nickelChain);
//        register.registerShapedRecipe(new ItemStack(nickelBoots), false,
//                "A A",
//                "A A",
//                "   ",
//                'A', nickelIngot);
        register.registerShapedRecipe(new ItemStack(nickelBoots), false,
                "   ",
                "A A",
                "A A",
                'A', nickelIngot);
        register.registerShapedRecipe(new ItemStack(nickelLeggings), false,
                "AAA",
                "A A",
                "A A",
                'A', nickelIngot);
        register.registerShapedRecipe(new ItemStack(nickelChestplate), false,
                "A A",
                "AAA",
                "AAA",
                'A', nickelIngot);
//        register.registerShapedRecipe(new ItemStack(nickelHelmet), false,
//                "AAA",
//                "A A",
//                "   ",
//                'A', nickelIngot);
        register.registerShapedRecipe(new ItemStack(nickelHelmet), false,
                "   ",
                "AAA",
                "A A",
                'A', nickelIngot);
        register.registerShapedRecipe(new ItemStack(doorNickel), false,
                " AA",
                " AA",
                " AA",
                'A', nickelIngot);
//        register.registerShapedRecipe(new ItemStack(arrowTungsten), false,
//                " C ",
//                " B ",
//                " A ",
//                'A', Item.feather,
//                'B', Item.stick,
//                'C', tungstenNugget);
        register.registerShapedRecipe(new ItemStack(tungstenChain), false,
                " A ",
                "A A",
                " A ",
                'A', tungstenNugget);
        register.registerShapedRecipe(new ItemStack(tungstenShears), false,
                " A ",
                "  A",
                "   ",
                'A', tungstenIngot);
        register.registerShapedRecipe(new ItemStack(tungstenScythe), false,
                "BA ",
                "B A",
                "B  ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenMattock), false,
                "AAA",
                " BA",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenHoe), false,
                "AA ",
                " B ",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenHatchet), false,
                "   ",
                " BA",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenWarHammer), false,
                "AAA",
                "ABA",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenSword), false,
                " A ",
                " A ",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenShovel), false,
                " A ",
                " B ",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenPickaxe), false,
                "AAA",
                " B ",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenDagger), false,
                "   ",
                " A ",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenBattleAxe), false,
                "A A",
                "ABA",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(tungstenAxe), false,
                "AA ",
                "AB ",
                " B ",
                'A', tungstenIngot,
                'B', Item.stick);
        register.registerShapelessRecipe(new ItemStack(tungstenIngot, 9), false,
                Blocks.blockTungsten);
        register.registerShapelessRecipe(new ItemStack(tungstenNugget, 9), false,
                tungstenIngot);
        register.registerShapedRecipe(new ItemStack(tungstenBootsChain), false,
                "   ",
                "A A",
                "A A",
                'A', tungstenChain);
        register.registerShapedRecipe(new ItemStack(tungstenLeggingsChain), false,
                "AAA",
                "A A",
                "A A",
                'A', tungstenChain);
        register.registerShapedRecipe(new ItemStack(tungstenChestplateChain), false,
                "A A",
                "AAA",
                "AAA",
                'A', tungstenChain);
        register.registerShapedRecipe(new ItemStack(tungstenHelmetChain), false,
                "AAA",
                "A A",
                "   ",
                'A', tungstenChain);
        register.registerShapedRecipe(new ItemStack(tungstenBoots), false,
                "   ",
                "A A",
                "A A",
                'A', tungstenIngot);
        register.registerShapedRecipe(new ItemStack(tungstenLeggings), false,
                "AAA",
                "A A",
                "A A",
                'A', tungstenIngot);
        register.registerShapedRecipe(new ItemStack(tungstenChestplate), false,
                "A A",
                "AAA",
                "AAA",
                'A', tungstenIngot);
        register.registerShapedRecipe(new ItemStack(tungstenHelmet), false,
                "   ",
                "AAA",
                "A A",
                'A', tungstenIngot);
        register.registerShapedRecipe(new ItemStack(doorTungsten), false,
                " AA",
                " AA",
                " AA",
                'A', tungstenIngot);

        register.registerShapelessRecipe(new ItemStack(porkchopStew,1),false,
                Item.bowlWater,Item.porkCooked,Item.carrot,Item.potato,Block.mushroomBrown
                );
        register.registerShapelessRecipe(new ItemStack(chestnutSoup,1),false,
                Item.bowlWater,Item.lambchopCooked,Item.onion,Item.potato
        );

        ItemCoin[] coins = new ItemCoin[]{Item.coinCopper, Item.coinSilver, Item.coinGold, Item.coinAncientMetal, Item.coinMithril, Item.coinAdamantium, nickelCoin, tungstenCoin};
        for (ItemCoin coin : coins) {
            for (int plank_subtype = 1; plank_subtype <= 9; ++plank_subtype) {
                register.registerShapelessRecipe(new ItemStack(coin.getNuggetPeer(), plank_subtype), true, new Object[]{new ItemStack(coin, plank_subtype)});
            }
            register.registerShapelessRecipe(new ItemStack(coin), true, new ItemStack(coin.getNuggetPeer()));
        }


        //RecipesFurnace.smelting().addSmelting(???.itemID, new ItemStack(Items.));
        RecipesFurnace.smelting().addSmelting(pieceAdamantium.itemID, new ItemStack(Items.adamantiumNugget));
        RecipesFurnace.smelting().addSmelting(pieceCopper.itemID, new ItemStack(Items.copperNugget));
        RecipesFurnace.smelting().addSmelting(pieceGold.itemID, new ItemStack(Items.goldNugget));
        RecipesFurnace.smelting().addSmelting(pieceGoldNether.itemID, new ItemStack(Items.goldNugget));
        RecipesFurnace.smelting().addSmelting(pieceSilver.itemID, new ItemStack(Items.silverNugget));
        RecipesFurnace.smelting().addSmelting(pieceIron.itemID, new ItemStack(Items.ironNugget));
        RecipesFurnace.smelting().addSmelting(pieceNickel.itemID, new ItemStack(Items.nickelNugget));
        RecipesFurnace.smelting().addSmelting(pieceMithril.itemID, new ItemStack(Items.mithrilNugget));
        RecipesFurnace.smelting().addSmelting(pieceTungsten.itemID, new ItemStack(Items.tungstenNugget));
    }
    private static Item register(String resourceLocation, Item item, CreativeModeTab tab) {
        item.setResourceLocation(item.getResourceLocationPrefix() + resourceLocation);
        item.setUnlocalizedName(resourceLocation);
        item.setCreativeTab(tab);
        return item;
    }
    private static Item register(String resourceLocation, Item item) {
        item.setResourceLocation(item.getResourceLocationPrefix() + resourceLocation);
        item.setUnlocalizedName(resourceLocation);
        return item;
    }


}
