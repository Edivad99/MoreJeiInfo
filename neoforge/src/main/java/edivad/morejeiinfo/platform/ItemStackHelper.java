package edivad.morejeiinfo.platform;

import edivad.morejeiinfo.platform.services.IPlatformItemStackHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class ItemStackHelper implements IPlatformItemStackHelper {

  @Override
  public int getBurnTime(ItemStack itemStack) {
    return itemStack.getBurnTime(RecipeType.SMELTING, Minecraft.getInstance().level.fuelValues());
  }

}
