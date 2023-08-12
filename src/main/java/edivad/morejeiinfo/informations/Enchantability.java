package edivad.morejeiinfo.informations;

import java.util.List;
import edivad.morejeiinfo.Config;
import edivad.morejeiinfo.Translations;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Enchantability implements Information {

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    int enchantability = itemStack.getEnchantmentValue();
    if (enchantability > 0) {
      return List.of(Component.translatable(Translations.ENCHANTABILITY, enchantability));
    }
    return List.of();
  }

  @Override
  public Config.Mode getMode() {
    return Config.CLIENT.enchantabilityTooltipMode.get();
  }
}
