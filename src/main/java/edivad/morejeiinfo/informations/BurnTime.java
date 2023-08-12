package edivad.morejeiinfo.informations;

import static edivad.morejeiinfo.TooltipEventHandler.DECIMALFORMAT;
import static net.minecraftforge.common.ForgeHooks.getBurnTime;

import java.util.List;
import edivad.morejeiinfo.Config;
import edivad.morejeiinfo.MoreJEIInfo;
import edivad.morejeiinfo.Translations;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class BurnTime implements Information {

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    int burnTime = 0;
    try {
      burnTime = getBurnTime(itemStack, RecipeType.SMELTING);
    } catch (Exception ex) {
      MoreJEIInfo.LOGGER.warn("Something went wrong!", ex);
    }

    if (burnTime > 0) {
      return List.of(
          Component.translatable(Translations.BURN_TIME, DECIMALFORMAT.format(burnTime)));
    }
    return List.of();
  }

  @Override
  public Config.Mode getMode() {
    return Config.CLIENT.burnTimeTooltipMode.get();
  }
}
