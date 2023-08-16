package edivad.morejeiinfo.tooltip;

import org.lwjgl.glfw.GLFW;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;

public class TooltipUtils {

  private static boolean isDebugMode() {
    return Minecraft.getInstance().options.advancedItemTooltips;
  }

  private static boolean isShiftKeyDown() {
    long window = Minecraft.getInstance().getWindow().getWindow();
    return InputConstants.isKeyDown(window, GLFW.GLFW_KEY_LEFT_SHIFT) ||
        InputConstants.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_SHIFT);
  }

  public static boolean isVisible(Mode mode) {
    return switch (mode) {
      case DISABLED -> false;
      case ENABLED -> true;
      case ON_SHIFT -> isShiftKeyDown();
      case ON_DEBUG -> isDebugMode();
      case ON_SHIFT_AND_DEBUG -> isShiftKeyDown() && isDebugMode();
    };
  }
}
