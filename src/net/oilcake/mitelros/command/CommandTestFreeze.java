package net.oilcake.mitelros.command;

import net.minecraft.*;

public class CommandTestFreeze extends CommandAbstract {
    public CommandTestFreeze(){
    }
    @Override
    public String getCommandName() {
        return "testfreeze";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    @Override
    public String getCommandUsage(ICommandListener iCommandListener) {
        return "commands.testfreeze.usage";
    }

    @Override
    public void processCommand(ICommandListener iCommandListener, String[] strings) {
        EntityPlayer player = getCommandSenderAsPlayer(iCommandListener);
        BiomeBase biome = player.worldObj.getBiomeGenForCoords(player.getBlockPosX(), player.getBlockPosZ());
        iCommandListener.sendChatToPlayer(ChatMessage.createFromText("当前温度为:"+biome.temperature+"，玩家体温为"+player.BodyTemperature + ".").setColor(EnumChatFormat.WHITE));
    }
}
