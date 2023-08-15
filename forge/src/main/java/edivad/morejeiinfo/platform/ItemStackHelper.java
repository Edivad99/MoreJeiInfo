package edivad.morejeiinfo.platform;

import edivad.morejeiinfo.platform.services.IPlatformItemStackHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemStackHelper implements IPlatformItemStackHelper {

  @Override
  public int getBurnTime(ItemStack itemStack) {
    return ForgeHooks.getBurnTime(itemStack, RecipeType.SMELTING);
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
  public String getItemKey(ItemStack itemStack) {
    return ForgeRegistries.ITEMS.getKey(itemStack.getItem()).toString();
  }
}
