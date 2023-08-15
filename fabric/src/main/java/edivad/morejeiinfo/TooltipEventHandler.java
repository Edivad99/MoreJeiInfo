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
import edivad.morejeiinfo.tooltip.Mode;
import edivad.morejeiinfo.tooltip.TooltipUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class TooltipEventHandler {
  public static List<Information> INFORMATION = new ArrayList<>();

  static {
    INFORMATION.add(new BurnTime(() -> Config.burnTimeTooltipMode));
    INFORMATION.add(new Durability(() -> Config.durabilityTooltipMode));
    INFORMATION.add(new Enchantability(() -> Config.enchantabilityTooltipMode));
    INFORMATION.add(new Food(() -> Config.foodTooltipMode));
    INFORMATION.add(new NBTData(() -> Config.nbtTooltipMode));
    INFORMATION.add(new RegistryName(() -> Config.registryNameTooltipMode));
    INFORMATION.add(new MaxStackSize(() -> Config.maxStackSizeTooltipMode));
    INFORMATION.add(new Tags(() -> Config.tagsTooltipMode));
    INFORMATION.add(new TranslationKey(() -> Config.translationKeyTooltipMode));
  }

  private static void extracted(List<Component> lines, Mode mode,
      List<Component> component) {
    if (TooltipUtils.isVisible(mode)) {
      for (var tooltip : component) {
        lines.add(tooltip.copy().withStyle(ChatFormatting.DARK_GRAY));
      }
    }
  }

  public static void onItemTooltip(ItemStack itemStack, TooltipFlag flag,
      List<Component> tooltTipList) {

    if (itemStack.isEmpty()) {
      return;
    }

    for (var information : INFORMATION) {
      var component = information.addInformation(itemStack, null);
      if (!component.isEmpty()) {
        extracted(tooltTipList, information.getMode(), component);
      }
    }
  }
}
