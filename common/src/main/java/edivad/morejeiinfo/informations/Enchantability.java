package edivad.morejeiinfo.informations;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class Enchantability implements Information {

  private final Supplier<Mode> mode;

  public Enchantability(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack) {
    var enchantable = itemStack.getComponents().get(DataComponents.ENCHANTABLE);
    if (enchantable == null) {
      return List.of();
    }
    int enchantability = enchantable.value();
    if (enchantability > 0) {
      return List.of(Component.translatable(Translations.ENCHANTABILITY, enchantability));
    }
    return List.of();
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
