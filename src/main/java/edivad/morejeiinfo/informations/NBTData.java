package edivad.morejeiinfo.informations;

import java.util.List;
import edivad.morejeiinfo.Config;
import edivad.morejeiinfo.Translations;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class NBTData implements Information {

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    var item = itemStack.getItem();
    var nbtData = item.getShareTag(itemStack);
    if (nbtData != null) {
      return List.of(Component.translatable(Translations.NBT_DATA, nbtData));
    }
    return List.of();
  }

  @Override
  public Config.Mode getMode() {
    return Config.CLIENT.nbtTooltipMode.get();
  }
}
