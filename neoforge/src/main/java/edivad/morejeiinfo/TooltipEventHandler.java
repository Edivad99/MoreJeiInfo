package edivad.morejeiinfo;

import java.util.ArrayList;
import java.util.List;
import edivad.morejeiinfo.config.Config;
import edivad.morejeiinfo.informations.BurnTime;
import edivad.morejeiinfo.informations.Durability;
import edivad.morejeiinfo.informations.Enchantability;
import edivad.morejeiinfo.informations.Food;
import edivad.morejeiinfo.informations.Information;
import edivad.morejeiinfo.informations.MaxStackSize;
import edivad.morejeiinfo.informations.NBTData;
import edivad.morejeiinfo.informations.RegistryName;
import edivad.morejeiinfo.informations.Tags;
import edivad.morejeiinfo.informations.TranslationKey;
import edivad.morejeiinfo.tooltip.TooltipUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public class TooltipEventHandler {

  public static List<Information> INFORMATION = new ArrayList<>();

  static {
    INFORMATION.add(new BurnTime(Config.CLIENT.burnTimeTooltipMode));
    INFORMATION.add(new Durability(Config.CLIENT.durabilityTooltipMode));
    INFORMATION.add(new Enchantability(Config.CLIENT.enchantabilityTooltipMode));
    INFORMATION.add(new Food(Config.CLIENT.foodTooltipMode));
    INFORMATION.add(new NBTData(Config.CLIENT.nbtTooltipMode));
    INFORMATION.add(new RegistryName(Config.CLIENT.registryNameTooltipMode));
    INFORMATION.add(new MaxStackSize(Config.CLIENT.maxStackSizeTooltipMode));
    INFORMATION.add(new Tags(Config.CLIENT.tagsTooltipMode));
    INFORMATION.add(new TranslationKey(Config.CLIENT.translationKeyTooltipMode));
  }

  @SubscribeEvent
  public void onItemTooltip(ItemTooltipEvent e) {
    TooltipUtils.addTooltips(e.getToolTip(), INFORMATION, e.getItemStack());
  }
}
