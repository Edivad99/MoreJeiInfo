package edivad.morejeiinfo.informations;

import java.util.List;
import edivad.morejeiinfo.Config;
import edivad.morejeiinfo.Translations;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class TranslationKey implements Information {

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    return List.of(
        Component.translatable(Translations.TRANSLATION_KEY, itemStack.getDescriptionId()));
  }

  @Override
  public Config.Mode getMode() {
    return Config.CLIENT.translationKeyTooltipMode.get();
  }
}
