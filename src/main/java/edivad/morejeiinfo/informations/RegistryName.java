package edivad.morejeiinfo.informations;

import java.util.List;
import edivad.morejeiinfo.Config;
import edivad.morejeiinfo.Translations;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryName implements Information {

  @Override
  public List<Component> addInformation(ItemStack itemStack, Player player) {
    var item = itemStack.getItem();
    return List.of(
        Component.translatable(Translations.REGISTRY_NAME, ForgeRegistries.ITEMS.getKey(item)));
  }

  @Override
  public Config.Mode getMode() {
    return Config.CLIENT.registryNameTooltipMode.get();
  }
}
