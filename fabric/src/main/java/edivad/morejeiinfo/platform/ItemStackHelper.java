package edivad.morejeiinfo.platform;

import edivad.morejeiinfo.platform.services.IPlatformItemStackHelper;
import net.minecraft.world.item.ItemStack;

public class ItemStackHelper implements IPlatformItemStackHelper {

  @Override
  public int getBurnTime(ItemStack itemStack) {
    //TODO: Implement
    //return Objects.requireNonNullElse(FuelRegistry.INSTANCE.get(itemStack.getItem()), 0);
    return 0;
  }
}
