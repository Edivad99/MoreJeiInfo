package edivad.morejeiinfo.informations;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class MaxStackSize implements Information {

  private final Supplier<Mode> mode;

  public MaxStackSize(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack) {
    int stackSize = itemStack.getMaxStackSize();
    if (stackSize > 0) {
      return List.of(Component.translatable(Translations.STACK_SIZE, stackSize));
    }
    return List.of();
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
