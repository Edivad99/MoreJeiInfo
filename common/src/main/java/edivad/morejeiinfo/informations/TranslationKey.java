package edivad.morejeiinfo.informations;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class TranslationKey implements Information {

  private final Supplier<Mode> mode;

  public TranslationKey(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    return List.of(
        Component.translatable(Translations.TRANSLATION_KEY, itemStack.getDescriptionId()));
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
