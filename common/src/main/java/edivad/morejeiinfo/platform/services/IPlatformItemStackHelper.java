package edivad.morejeiinfo.platform.services;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public interface IPlatformItemStackHelper {

  int getBurnTime(ItemStack itemStack);

  int getEnchantmentValue(ItemStack stack);

  CompoundTag getNBTData(ItemStack stack);

  String getRegistryName(ItemStack itemStack);
}

