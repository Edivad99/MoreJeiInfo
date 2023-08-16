package edivad.morejeiinfo.config;

import com.mojang.datafixers.util.Pair;
import edivad.morejeiinfo.Shared;
import edivad.morejeiinfo.tooltip.Mode;

public class Config {

  public static Mode burnTimeTooltipMode;
  public static Mode durabilityTooltipMode;
  public static Mode enchantabilityTooltipMode;
  public static Mode foodTooltipMode;
  public static Mode maxStackSizeTooltipMode;
  public static Mode nbtTooltipMode;
  public static Mode registryNameTooltipMode;
  public static Mode tagsTooltipMode;
  public static Mode translationKeyTooltipMode;
  private static SimpleConfig CONFIG;
  private static ModConfigProvider configs;

  public static void registerConfigs() {
    configs = new ModConfigProvider();
    createConfigs();

    CONFIG = SimpleConfig.of(Shared.ID + "_config").provider(configs).request();

    assignConfigs();
  }

  private static void createConfigs() {
    configs.addKeyValuePair(new Pair<>("enum.burnTime", Mode.ON_DEBUG));
    configs.addKeyValuePair(new Pair<>("enum.durability", Mode.ON_DEBUG));
    configs.addKeyValuePair(new Pair<>("enum.enchantability", Mode.ON_DEBUG));
    configs.addKeyValuePair(new Pair<>("enum.foodTooltip", Mode.ON_DEBUG));
    configs.addKeyValuePair(new Pair<>("enum.maxStackSize", Mode.ON_DEBUG));
    configs.addKeyValuePair(new Pair<>("enum.nbtTooltip", Mode.ON_DEBUG));
    configs.addKeyValuePair(new Pair<>("enum.registryName", Mode.DISABLED));
    configs.addKeyValuePair(new Pair<>("enum.tags", Mode.ON_DEBUG));
    configs.addKeyValuePair(new Pair<>("enum.translationKey", Mode.ON_DEBUG));
  }

  private static void assignConfigs() {
    burnTimeTooltipMode = CONFIG.getEnumOrDefault("enum.burnTime", Mode.ON_DEBUG, Mode.class);
    durabilityTooltipMode = CONFIG.getEnumOrDefault("enum.durability", Mode.ON_DEBUG, Mode.class);
    enchantabilityTooltipMode =
        CONFIG.getEnumOrDefault("enum.enchantability", Mode.ON_DEBUG, Mode.class);
    foodTooltipMode = CONFIG.getEnumOrDefault("enum.foodTooltip", Mode.ON_DEBUG, Mode.class);
    maxStackSizeTooltipMode =
        CONFIG.getEnumOrDefault("enum.maxStackSize", Mode.ON_DEBUG, Mode.class);
    nbtTooltipMode = CONFIG.getEnumOrDefault("enum.nbtTooltip", Mode.ON_DEBUG, Mode.class);
    registryNameTooltipMode =
        CONFIG.getEnumOrDefault("enum.registryName", Mode.DISABLED, Mode.class);
    tagsTooltipMode = CONFIG.getEnumOrDefault("enum.tags", Mode.ON_DEBUG, Mode.class);
    translationKeyTooltipMode =
        CONFIG.getEnumOrDefault("enum.translationKey", Mode.ON_DEBUG, Mode.class);

    Shared.LOGGER.debug("All " + configs.getConfigsList().size() + " have been set properly");
  }
}