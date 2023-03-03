package net.oilcake.mitelros.block;

import net.minecraft.*;

import java.util.Random;

public class BlockFlowerExtend extends BlockFlower {
    private BlockSubtypes subtypes = new BlockSubtypes(new String[]{"luminescent_herb","azure_bluet","cornflower","lily_of_the_valley","pink_tulip","white_tulip","red_tulip"});;
    protected BlockFlowerExtend(int id, Material material) {
        super(id, material);
    }
    public static final int LUMINESCENT_HERB = 1;
    public static final int AZURE_BLUET = 2;
    public static final int CORNFLOWER = 3;
    public static final int LILY_OF_THE_VALLEY = 4;
    public static final int TULIP_PINK = 5;
    public static final int TULIP_WHITE = 6;
    public static final int TULIP_RED = 7;

    public static final String[] types = new String[]{"luminescent_herb","azure_bluet","cornflower","lily_of_the_valley","pink_tulip","white_tulip","red_tulip"};

    private IIcon[] icons;
    private static int[] candidates;

    protected BlockFlowerExtend(int id) {
        this(id, Material.plants);
    }

    public void a(mt par1IconRegister) {
        this.subtypes.setIcons(this.registerIcons(par1IconRegister, this.getTextures(), "flowers/"));
    }

    public IIcon a(int side, int metadata) {
        return this.subtypes.getIcon(this.getBlockSubtype(metadata));
    }
    public String[] getTextures() {
        return this.subtypes.getTextures();
    }

    public String getMetadataNotes() {
        String[] array = new String[types.length];

        for(int i = 0; i < types.length; ++i) {
            if (types[i] != null) {
                array[i] = i + "=" + StringHelper.capitalize(types[i]);
            }
        }

        return StringHelper.implode(array, ", ", true, false);
    }

    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < types.length && types[metadata] != null;
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata;
    }

    public boolean canBeReplacedBy(int metadata, Block other_block, int other_block_metadata) {
        return other_block == this ? other_block_metadata != metadata : super.canBeReplacedBy(metadata, other_block, other_block_metadata);
    }
    public void setBlockBoundsBasedOnStateAndNeighbors(IBlockAccess block_access, int x, int y, int z) {
        int metadata = block_access.getBlockMetadata(x, y, z);
        float width = 0.2F;
        if (metadata == 0) {
            this.setBlockBoundsForCurrentThread((double)(0.5F - width), 0.0, (double)(0.5F - width), (double)(0.5F + width), 0.75, (double)(0.5F + width));;
        } else if (metadata == 1) {
            this.setBlockBoundsForCurrentThread((double)(0.5F - width), 0.0, (double)(0.5F - width), (double)(0.5F + width), 0.75, (double)(0.5F + width));
        } else if (metadata == 2) {
            this.setBlockBoundsForCurrentThread((double)(0.5F - width), 0.0, (double)(0.5F - width), (double)(0.5F + width), 0.75, (double)(0.5F + width));
        } else if (metadata == 3) {
            this.setBlockBoundsForCurrentThread((double)(0.5F - width), 0.0, (double)(0.5F - width), (double)(0.5F + width), 0.75, (double)(0.5F + width));
        } else if (metadata == 4) {
            this.setBlockBoundsForCurrentThread((double)(0.5F - width), 0.0, (double)(0.5F - width), (double)(0.5F + width), 0.75, (double)(0.5F + width));
        } else if (metadata == 5) {
            this.setBlockBoundsForCurrentThread((double)(0.5F - width), 0.0, (double)(0.5F - width), (double)(0.5F + width), 0.75, (double)(0.5F + width));
        } else if (metadata == 6) {
            this.setBlockBoundsForCurrentThread((double)(0.5F - width), 0.0, (double)(0.5F - width), (double)(0.5F + width), 0.75, (double)(0.5F + width));
        } else if (metadata == 7) {
            this.setBlockBoundsForCurrentThread((double)(0.5F - width), 0.0, (double)(0.5F - width), (double)(0.5F + width), 0.75, (double)(0.5F + width));
        } else {
            Minecraft.setErrorMessage("setBlockBoundsBasedOnStateAndNeighbors: unhandled case");
        }

    }

    public int getRandomSubtypeForBiome(Random random, BiomeBase biome) {
        if (biome == BiomeBase.plains && random.nextInt(2) == 0) {
            return 1;
        } else {
            int num_candidates = 0;

            for(int i = 0; i < types.length; ++i) {
                if (types[i] != null && this.isBiomeSuitable(biome, i)) {
                    candidates[num_candidates++] = i;
                }
            }

            return num_candidates == 0 ? -1 : candidates[random.nextInt(num_candidates)];
        }
    }

    public int getRandomSubtypeThatCanOccurAt(World world, int x, int y, int z) {
        BiomeBase biome = world.getBiomeGenForCoords(x, z);
        int subtype = this.getRandomSubtypeForBiome(world.rand, biome);
        if (subtype < 0) {
            return -1;
        } else {
            while(!this.canOccurAt(world, x, y, z, subtype)) {
                subtype = this.getRandomSubtypeForBiome(world.rand, biome);
            }

            return subtype;
        }
    }

    public boolean isBiomeSuitable(BiomeBase biome, int metadata) {
        if (!this.isValidMetadata(metadata)) {
            Minecraft.setErrorMessage("isBiomeSuitable: invalid metadata " + metadata);
            return false;
        } else {
            int subtype = this.getBlockSubtype(metadata);
            if (types[subtype] == null) {
                Minecraft.setErrorMessage("isBiomeSuitable: invalid subtype " + subtype);
                return false;
            }else if (biome.isSwampBiome()) {
                return false;
            } else if (subtype == 1 && biome.temperature < BiomeBase.plains.temperature) {
                return false;
            } else if (subtype != 1 && biome.temperature < BiomeBase.forestHills.temperature) {
                return false;
            } else {
                return !biome.isJungleBiome();
            }
        }
    }

    public boolean canOccurAt(World world, int x, int y, int z, int metadata) {
        return this.isBiomeSuitable(world.getBiomeGenForCoords(x, z), metadata) && super.canOccurAt(world, x, y, z, metadata);
    }

    public int getPatchSize(int metadata, BiomeBase biome) {
        if (!this.isValidMetadata(metadata)) {
            Minecraft.setErrorMessage("getPatchSize: invalid metadata " + metadata);
        }

        int subtype = this.getBlockSubtype(metadata);
        if (subtype == 1) {
            return 8;
        } else {
            return biome != BiomeBase.plains && !biome.isJungleBiome() ? 16 : 64;
        }
    }

    public boolean isLegalAt(World world, int x, int y, int z, int metadata) {
        return this.isBiomeSuitable(world.getBiomeGenForCoords(x, z), metadata) && super.isLegalAt(world, x, y, z, metadata);
    }

    static {
        candidates = new int[types.length];
    }
}