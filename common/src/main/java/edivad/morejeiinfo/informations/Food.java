package edivad.morejeiinfo.informations;

import static edivad.morejeiinfo.Shared.DECIMALFORMAT;

import java.util.List;
import java.util.function.Supplier;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Food implements Information {

  private final Supplier<Mode> mode;

  public Food(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    var item = itemStack.getItem();
    var foodProperties = item.getFoodProperties();
    if (item.isEdible() && foodProperties != null) {
      int healVal = foodProperties.getNutrition();
      float satVal = healVal * (foodProperties.getSaturationModifier() * 2);

      return List.of(
          Component.translatable(Translations.FOOD, healVal, DECIMALFORMAT.format(satVal)));
    }
    return List.of();
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
