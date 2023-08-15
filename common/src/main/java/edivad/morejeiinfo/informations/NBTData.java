package edivad.morejeiinfo.informations;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.platform.Services;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class NBTData implements Information {

  private final Supplier<Mode> mode;

  public NBTData(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack) {
    CompoundTag nbtData = Services.PLATFORM.getItemStackHelper().getNBTData(itemStack);
    if (nbtData != null) {
      return List.of(Component.translatable(Translations.NBT_DATA, nbtData));
    }
    return List.of();
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
