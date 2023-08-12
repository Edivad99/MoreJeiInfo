package edivad.morejeiinfo;

import static net.minecraftforge.common.ForgeHooks.getBurnTime;

import java.text.DecimalFormat;
import org.lwjgl.glfw.GLFW;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class TooltipEventHandler {

  private static final DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");

  static {
    DECIMALFORMAT.setGroupingUsed(true);
    DECIMALFORMAT.setGroupingSize(3);
  }

  private static boolean isDebugMode() {
    return Minecraft.getInstance().options.advancedItemTooltips;
  }

  private static boolean isShiftKeyDown() {
    long window = Minecraft.getInstance().getWindow().getWindow();
    return InputConstants.isKeyDown(window, GLFW.GLFW_KEY_LEFT_SHIFT) ||
        InputConstants.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_SHIFT);
  }

  private void registerTooltip(ItemTooltipEvent e, Component tooltip, Config.Mode mode) {
    boolean isEnabled = switch (mode) {
      case DISABLED -> false;
      case ENABLED -> true;
      case ON_SHIFT -> isShiftKeyDown();
      case ON_DEBUG -> isDebugMode();
      case ON_SHIFT_AND_DEBUG -> isShiftKeyDown() && isDebugMode();
    };
    if (isEnabled) {
      e.getToolTip().add(tooltip);
    }
  }

  @SubscribeEvent
  public void onItemTooltip(ItemTooltipEvent e) {
    var itemStack = e.getItemStack();
    var item = itemStack.getItem();
    var player = e.getEntity();

    if (itemStack.isEmpty()) {
      return;
    }

    // Tooltip - Burn Time
    int burnTime = 0;
    try {
      burnTime = getBurnTime(itemStack, RecipeType.SMELTING);
    } catch (Exception ex) {
      MoreJEIInfo.LOGGER.warn("Something went wrong!", ex);
    }

    if (burnTime > 0) {
      var burnTooltip =
          Component.translatable(Translations.BURN_TIME, DECIMALFORMAT.format(burnTime))
          .withStyle(ChatFormatting.DARK_GRAY);
      registerTooltip(e, burnTooltip, Config.CLIENT.burnTimeTooltipMode.get());
    }

    // Durability
    int maxDamage = itemStack.getMaxDamage();
    int currentDamage = maxDamage - itemStack.getDamageValue();
    if (maxDamage > 0) {
      var durabilityTooltip =
          Component.translatable(Translations.DURABILITY, currentDamage, maxDamage)
          .withStyle(ChatFormatting.DARK_GRAY);
      registerTooltip(e, durabilityTooltip, Config.CLIENT.durabilityTooltipMode.get());
    }

    // Enchantability
    int enchantability = itemStack.getEnchantmentValue();
    if (enchantability > 0) {
      var enchantabilityTooltip =
          Component.translatable(Translations.ENCHANTABILITY, enchantability)
          .withStyle(ChatFormatting.DARK_GRAY);
      registerTooltip(e, enchantabilityTooltip, Config.CLIENT.enchantabilityTooltipMode.get());
    }

    // Tooltip - Hunger / Saturation
    var foodProperties = item.getFoodProperties(itemStack, player);
    if (item.isEdible() && foodProperties != null) {
      int healVal = foodProperties.getNutrition();
      float satVal = healVal * (foodProperties.getSaturationModifier() * 2);

      var foodTooltip =
          Component.translatable(Translations.FOOD, healVal, DECIMALFORMAT.format(satVal))
          .withStyle(ChatFormatting.DARK_GRAY);
      registerTooltip(e, foodTooltip, Config.CLIENT.foodTooltipMode.get());
    }

    // NBT Data
    var nbtData = item.getShareTag(itemStack);
    if (nbtData != null) {
      var nbtDataTooltip = Component.translatable(Translations.NBT_DATA, nbtData)
          .withStyle(ChatFormatting.DARK_GRAY);
      registerTooltip(e, nbtDataTooltip, Config.CLIENT.nbtTooltipMode.get());
    }

    // Registry Name
    var registryTooltip =
        Component.translatable(Translations.REGISTRY_NAME, ForgeRegistries.ITEMS.getKey(item))
        .withStyle(ChatFormatting.DARK_GRAY);
    registerTooltip(e, registryTooltip, Config.CLIENT.registryNameTooltipMode.get());

    // Max Stack Size
    int stackSize = itemStack.getMaxStackSize();
    if (stackSize > 0) {
      var stackSizeTooltip = Component.translatable(Translations.STACKSIZE, stackSize)
          .withStyle(ChatFormatting.DARK_GRAY);
      registerTooltip(e, stackSizeTooltip, Config.CLIENT.maxStackSizeTooltipMode.get());
    }

    // Tags
    if (itemStack.getTags().findAny().isPresent()) {
      var mode = Config.CLIENT.tagsTooltipMode.get();

      var tagsTooltip = Component.translatable(Translations.TAGS)
          .withStyle(ChatFormatting.DARK_GRAY);
      registerTooltip(e, tagsTooltip, mode);

      itemStack.getTags()
          .map(TagKey::location)
          .sorted((rl1, rl2) -> {
            String namespaceRl1 = rl1.getNamespace();
            String namespaceRl2 = rl2.getNamespace();
            if (namespaceRl1.equals("minecraft") && !namespaceRl2.equals("minecraft")) {
              return -1;
            }
            if (namespaceRl2.equals("minecraft") && !namespaceRl1.equals("minecraft")) {
              return 1;
            }
            return rl1.toString().compareTo(rl2.toString());
          })
          .map(tag -> Component.literal("    " + tag))
          .map(tag -> tag.withStyle(ChatFormatting.DARK_GRAY))
          .forEachOrdered(tooltip -> registerTooltip(e, tooltip, mode));
    }

    // Translation Key
    var translationKeyTooltip =
        Component.translatable(Translations.TRANSLATION_KEY, itemStack.getDescriptionId())
        .withStyle(ChatFormatting.DARK_GRAY);
    registerTooltip(e, translationKeyTooltip, Config.CLIENT.translationKeyTooltipMode.get());
  }
}
