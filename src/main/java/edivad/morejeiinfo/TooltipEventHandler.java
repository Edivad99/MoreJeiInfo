package edivad.morejeiinfo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.glfw.GLFW;
import com.mojang.blaze3d.platform.InputConstants;
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
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TooltipEventHandler {

  public static final DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");

  public static List<Information> INFORMATION = new ArrayList<>();

  static {
    DECIMALFORMAT.setGroupingUsed(true);
    DECIMALFORMAT.setGroupingSize(3);

    INFORMATION.add(new BurnTime());
    INFORMATION.add(new Durability());
    INFORMATION.add(new Enchantability());
    INFORMATION.add(new Food());
    INFORMATION.add(new NBTData());
    INFORMATION.add(new RegistryName());
    INFORMATION.add(new MaxStackSize());
    INFORMATION.add(new Tags());
    INFORMATION.add(new TranslationKey());
  }

  private static boolean isDebugMode() {
    return Minecraft.getInstance().options.advancedItemTooltips;
  }

  private static boolean isShiftKeyDown() {
    long window = Minecraft.getInstance().getWindow().getWindow();
    return InputConstants.isKeyDown(window, GLFW.GLFW_KEY_LEFT_SHIFT) ||
        InputConstants.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_SHIFT);
  }

  private void registerTooltip(ItemTooltipEvent e, List<Component> tooltips, Config.Mode mode) {
    boolean isEnabled = switch (mode) {
      case DISABLED -> false;
      case ENABLED -> true;
      case ON_SHIFT -> isShiftKeyDown();
      case ON_DEBUG -> isDebugMode();
      case ON_SHIFT_AND_DEBUG -> isShiftKeyDown() && isDebugMode();
    };
    if (isEnabled) {
      var tooltTipList = e.getToolTip();
      for (var tooltip : tooltips) {
        tooltTipList.add(tooltip.copy().withStyle(ChatFormatting.DARK_GRAY));
      }
    }
  }

  @SubscribeEvent
  public void onItemTooltip(ItemTooltipEvent e) {
    var itemStack = e.getItemStack();
    var player = e.getEntity();

    if (itemStack.isEmpty()) {
      return;
    }

    for (var information : INFORMATION) {
      var component = information.addInformation(itemStack, player);
      if (!component.isEmpty()) {
        registerTooltip(e, component, information.getMode());
      }
    }
  }
}
