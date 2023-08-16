package edivad.morejeiinfo.informations;

import static edivad.morejeiinfo.Shared.DECIMALFORMAT;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Shared;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.platform.Services;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class BurnTime implements Information {

  private final Supplier<Mode> mode;

  public BurnTime(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack) {
    int burnTime = 0;
    try {
      burnTime = Services.PLATFORM.getItemStackHelper().getBurnTime(itemStack);
    } catch (Exception ex) {
      Shared.LOGGER.warn("Something went wrong!", ex);
    }

    if (burnTime > 0) {
      return List.of(
          Component.translatable(Translations.BURN_TIME, DECIMALFORMAT.format(burnTime)));
    }
    return List.of();
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
