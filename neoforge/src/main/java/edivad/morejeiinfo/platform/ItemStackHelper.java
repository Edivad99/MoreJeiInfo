package edivad.morejeiinfo.platform;

import edivad.morejeiinfo.platform.services.IPlatformItemStackHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.common.CommonHooks;

public class ItemStackHelper implements IPlatformItemStackHelper {

  @Override
  public int getBurnTime(ItemStack itemStack) {
    return CommonHooks.getBurnTime(itemStack, RecipeType.SMELTING);
  }

  @Override
  public int getEnchantmentValue(ItemStack stack) {
    return stack.getEnchantmentValue();
  }

  @Override
  public CompoundTag getNBTData(ItemStack stack) {
    return stack.getTag();
  }

  @Override
  public String getRegistryName(ItemStack itemStack) {
    return BuiltInRegistries.ITEM.getKey(itemStack.getItem()).toString();
  }
}
