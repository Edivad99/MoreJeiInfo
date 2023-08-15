package edivad.morejeiinfo.platform;

import java.util.Objects;
import edivad.morejeiinfo.platform.services.IPlatformItemStackHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class ItemStackHelper implements IPlatformItemStackHelper {

  @Override
  public int getBurnTime(ItemStack itemStack) {
    return Objects.requireNonNullElse(FuelRegistry.INSTANCE.get(itemStack.getItem()), 0);
  }

  @Override
  public int getEnchantmentValue(ItemStack stack) {
    return stack.getItem().getEnchantmentValue();
  }

  @Override
  public CompoundTag getNBTData(ItemStack stack) {
    return ItemVariant.of(stack).getNbt();
  }

  @Override
  public String getItemKey(ItemStack itemStack) {
    return itemStack.getItem().getDescriptionId(itemStack);
  }
}
