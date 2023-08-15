package edivad.morejeiinfo.informations;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class Durability implements Information {

  private final Supplier<Mode> mode;

  public Durability(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack) {
    int maxDamage = itemStack.getMaxDamage();
    int currentDamage = maxDamage - itemStack.getDamageValue();
    if (maxDamage > 0) {
      return List.of(Component.translatable(Translations.DURABILITY, currentDamage, maxDamage));
    }
    return List.of();
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
