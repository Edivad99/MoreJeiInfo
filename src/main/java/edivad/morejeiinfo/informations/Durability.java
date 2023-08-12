package edivad.morejeiinfo.informations;

import java.util.List;
import edivad.morejeiinfo.Config;
import edivad.morejeiinfo.Translations;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Durability implements Information {

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    int maxDamage = itemStack.getMaxDamage();
    int currentDamage = maxDamage - itemStack.getDamageValue();
    if (maxDamage > 0) {
      return List.of(Component.translatable(Translations.DURABILITY, currentDamage, maxDamage));
    }
    return List.of();
  }

  @Override
  public Config.Mode getMode() {
    return Config.CLIENT.durabilityTooltipMode.get();
  }
}
