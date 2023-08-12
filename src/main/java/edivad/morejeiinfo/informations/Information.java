package edivad.morejeiinfo.informations;

import java.util.List;
import edivad.morejeiinfo.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface Information {

  List<Component> addInformation(ItemStack itemStack, Player player);

  Config.Mode getMode();
}
