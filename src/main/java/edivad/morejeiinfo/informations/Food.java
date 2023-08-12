package edivad.morejeiinfo.informations;

import static edivad.morejeiinfo.TooltipEventHandler.DECIMALFORMAT;

import java.util.List;
import edivad.morejeiinfo.Config;
import edivad.morejeiinfo.Translations;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Food implements Information {

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    var item = itemStack.getItem();
    var foodProperties = item.getFoodProperties(itemStack, player);
    if (item.isEdible() && foodProperties != null) {
      int healVal = foodProperties.getNutrition();
      float satVal = healVal * (foodProperties.getSaturationModifier() * 2);

      return List.of(
          Component.translatable(Translations.FOOD, healVal, DECIMALFORMAT.format(satVal)));
    }
    return List.of();
  }

  @Override
  public Config.Mode getMode() {
    return Config.CLIENT.foodTooltipMode.get();
  }
}
