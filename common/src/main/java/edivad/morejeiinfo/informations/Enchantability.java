package edivad.morejeiinfo.informations;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.platform.Services;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Enchantability implements Information {

  private final Supplier<Mode> mode;

  public Enchantability(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    int enchantability = Services.PLATFORM.getItemStackHelper().getEnchantmentValue(itemStack);
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
