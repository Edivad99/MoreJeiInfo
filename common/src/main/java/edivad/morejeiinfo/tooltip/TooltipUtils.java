package edivad.morejeiinfo.tooltip;

import java.util.List;
import org.lwjgl.glfw.GLFW;
import com.mojang.blaze3d.platform.InputConstants;
import edivad.morejeiinfo.informations.Information;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class TooltipUtils {

  private static boolean isDebugMode() {
    return Minecraft.getInstance().options.advancedItemTooltips;
  }

  private static boolean isShiftKeyDown() {
    long window = Minecraft.getInstance().getWindow().getWindow();
    return InputConstants.isKeyDown(window, GLFW.GLFW_KEY_LEFT_SHIFT) ||
        InputConstants.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_SHIFT);
  }

  private static boolean isVisible(Mode mode) {
    return switch (mode) {
      case DISABLED -> false;
      case ENABLED -> true;
      case ON_SHIFT -> isShiftKeyDown();
      case ON_DEBUG -> isDebugMode();
      case ON_SHIFT_AND_DEBUG -> isShiftKeyDown() && isDebugMode();
    };
  }

  public static void addTooltips(List<Component> tooltips, List<Information> information,
      ItemStack itemStack) {
    if (itemStack.isEmpty()) {
      return;
    }

    for (var current : information) {
      var newTooltips = current.addInformation(itemStack);
      if (!newTooltips.isEmpty()) {
        if (isVisible(current.getMode())) {
          for (var tooltip : newTooltips) {
            tooltips.add(tooltip.copy().withStyle(ChatFormatting.DARK_GRAY));
          }
        }
      }
    }
  }
}
