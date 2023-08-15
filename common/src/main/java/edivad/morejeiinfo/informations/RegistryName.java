package edivad.morejeiinfo.informations;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.platform.Services;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class RegistryName implements Information {

  private final Supplier<Mode> mode;

  public RegistryName(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack) {
    var key = Services.PLATFORM.getItemStackHelper().getItemKey(itemStack);
    return List.of(Component.translatable(Translations.REGISTRY_NAME, key));
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
