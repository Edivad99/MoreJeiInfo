package edivad.morejeiinfo;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = MoreJEIInfo.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

  public static final ForgeConfigSpec CLIENT_SPEC;
  public static final Config.Client CLIENT;
  private static final String CATEGORY_TOOLTIPS = "Tooltip Settings";
  private static final Mode defaultBurnTimeTooltipMode = Mode.ON_DEBUG;
  private static final Mode defaultDurabilityTooltipMode = Mode.ON_DEBUG;
  private static final Mode defaultEnchantabilityTooltipMode = Mode.ON_DEBUG;
  private static final Mode defaultFoodTooltipMode = Mode.ON_DEBUG;
  private static final Mode defaultMaxStackSizeTooltipMode = Mode.ON_DEBUG;
  private static final Mode defaultNbtTooltipMode = Mode.ON_DEBUG;
  private static final Mode defaultRegistryNameTooltipMode = Mode.DISABLED;
  private static final Mode defaultTagsTooltipMode = Mode.ON_DEBUG;
  private static final Mode defaultTranslationKeyTooltipMode = Mode.ON_DEBUG;

  static {
    final var specPair = new ForgeConfigSpec.Builder().configure(Config.Client::new);
    CLIENT_SPEC = specPair.getRight();
    CLIENT = specPair.getLeft();
  }

  @SubscribeEvent
  public static void onLoad(final ModConfigEvent.Loading configEvent) {
    MoreJEIInfo.LOGGER.debug("Loaded MoreJeiInfo config file {}",
        configEvent.getConfig().getFileName());
  }

  @SubscribeEvent
  public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
    MoreJEIInfo.LOGGER.debug("MoreJeiInfo config just got changed on the file system!");
  }

  public enum Mode {
    DISABLED, ENABLED, ON_SHIFT, ON_DEBUG, ON_SHIFT_AND_DEBUG
  }

  public static class Client {

    public final ForgeConfigSpec.EnumValue<Mode> burnTimeTooltipMode;
    public final ForgeConfigSpec.EnumValue<Mode> durabilityTooltipMode;
    public final ForgeConfigSpec.EnumValue<Mode> enchantabilityTooltipMode;
    public final ForgeConfigSpec.EnumValue<Mode> foodTooltipMode;
    public final ForgeConfigSpec.EnumValue<Mode> maxStackSizeTooltipMode;
    public final ForgeConfigSpec.EnumValue<Mode> nbtTooltipMode;
    public final ForgeConfigSpec.EnumValue<Mode> registryNameTooltipMode;
    public final ForgeConfigSpec.EnumValue<Mode> tagsTooltipMode;
    public final ForgeConfigSpec.EnumValue<Mode> translationKeyTooltipMode;

    Client(ForgeConfigSpec.Builder builder) {
      builder.comment(CATEGORY_TOOLTIPS)
          .comment("Tooltip Options")
          .push("tooltipOptions");

      burnTimeTooltipMode = builder
          .comment("Configure tooltip for burn time.")
          .translation(Translations.BURN_TIME_MODE)
          .defineEnum("burnTimeTooltipMode", defaultBurnTimeTooltipMode);

      durabilityTooltipMode = builder
          .comment("Configure tooltip for durability.")
          .translation(Translations.DURABILITY_MODE)
          .defineEnum("durabilityTooltipMode", defaultDurabilityTooltipMode);

      enchantabilityTooltipMode = builder
          .comment("Configure tooltip for enchantability")
          .translation(Translations.ENCHANTABILITY_MODE)
          .defineEnum("enchantabilityTooltipMode", defaultEnchantabilityTooltipMode);

      foodTooltipMode = builder
          .comment("Configure tooltip for hunger and saturation.")
          .translation(Translations.FOOD_MODE)
          .defineEnum("foodTooltipMode", defaultFoodTooltipMode);

      maxStackSizeTooltipMode = builder
          .comment("Configure tooltip for max stack size.")
          .translation(Translations.STACKSIZE_MODE)
          .defineEnum("maxStackSizeTooltipMode", defaultMaxStackSizeTooltipMode);

      nbtTooltipMode = builder
          .comment("Configure tooltip for NBT data.")
          .translation(Translations.NBT_DATA_MODE)
          .defineEnum("nbtTooltipMode", defaultNbtTooltipMode);

      registryNameTooltipMode = builder
          .comment("Configure tooltip for registry name. E.g. minecraft:stone")
          .translation(Translations.REGISTRY_NAME_MODE)
          .defineEnum("registryNameTooltipMode", defaultRegistryNameTooltipMode);

      tagsTooltipMode = builder
          .comment("Configure tooltip for tags. E.g. forge:ingot, minecraft:planks")
          .translation(Translations.TAGS_MODE)
          .defineEnum("tagsTooltipMode", defaultTagsTooltipMode);

      translationKeyTooltipMode = builder
          .comment("Configure tooltip for translation key. E.g. block.minecraft.stone")
          .translation(Translations.TRANSLATION_KEY_MODE)
          .defineEnum("translationKeyTooltipMode", defaultTranslationKeyTooltipMode);

      builder.pop();
    }
  }
}
