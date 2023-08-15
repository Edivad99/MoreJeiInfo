package edivad.morejeiinfo.informations;

import java.util.List;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public interface Information {

  List<Component> addInformation(ItemStack itemStack);

  Mode getMode();
}
