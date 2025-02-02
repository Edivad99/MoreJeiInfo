package edivad.morejeiinfo.informations;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class NBTData implements Information {

  private final Supplier<Mode> mode;

  public NBTData(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack) {
    var customData = itemStack.get(DataComponents.CUSTOM_DATA);
    if (customData != null) {
      var tag = customData.copyTag();
      return List.of(Component.translatable(Translations.NBT_DATA, tag));
    }
    return List.of();
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
