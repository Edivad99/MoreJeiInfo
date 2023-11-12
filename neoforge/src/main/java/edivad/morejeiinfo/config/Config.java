package edivad.morejeiinfo.config;

import edivad.morejeiinfo.Shared;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@Mod.EventBusSubscriber(modid = Shared.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

  public static final ModConfigSpec CLIENT_SPEC;
  public static final Config.Client CLIENT;

  static {
    final var specPair = new ModConfigSpec.Builder().configure(Config.Client::new);
    CLIENT_SPEC = specPair.getRight();
    CLIENT = specPair.getLeft();
  }

  @SubscribeEvent
  public static void onLoad(final ModConfigEvent.Loading configEvent) {
    Shared.LOGGER.debug("Loaded MoreJeiInfo config file {}",
        configEvent.getConfig().getFileName());
  }

  @SubscribeEvent
  public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
    Shared.LOGGER.debug("MoreJeiInfo config just got changed on the file system!");
  }

  public static class Client {

    public final ModConfigSpec.EnumValue<Mode> burnTimeTooltipMode;
    public final ModConfigSpec.EnumValue<Mode> durabilityTooltipMode;
    public final ModConfigSpec.EnumValue<Mode> enchantabilityTooltipMode;
    public final ModConfigSpec.EnumValue<Mode> foodTooltipMode;
    public final ModConfigSpec.EnumValue<Mode> maxStackSizeTooltipMode;
    public final ModConfigSpec.EnumValue<Mode> nbtTooltipMode;
    public final ModConfigSpec.EnumValue<Mode> registryNameTooltipMode;
    public final ModConfigSpec.EnumValue<Mode> tagsTooltipMode;
    public final ModConfigSpec.EnumValue<Mode> translationKeyTooltipMode;

    Client(ModConfigSpec.Builder builder) {
      builder.comment("Tooltip Settings")
          .comment("Tooltip Options")
          .push("tooltipOptions");

      burnTimeTooltipMode = builder
          .comment("Configure tooltip for burn time.")
          .translation(Translations.BURN_TIME_MODE)
          .defineEnum("burnTimeTooltipMode", Mode.ON_DEBUG);

      durabilityTooltipMode = builder
          .comment("Configure tooltip for durability.")
          .translation(Translations.DURABILITY_MODE)
          .defineEnum("durabilityTooltipMode", Mode.ON_DEBUG);

      enchantabilityTooltipMode = builder
          .comment("Configure tooltip for enchantability")
          .translation(Translations.ENCHANTABILITY_MODE)
          .defineEnum("enchantabilityTooltipMode", Mode.ON_DEBUG);

      foodTooltipMode = builder
          .comment("Configure tooltip for hunger and saturation.")
          .translation(Translations.FOOD_MODE)
          .defineEnum("foodTooltipMode", Mode.ON_DEBUG);

      maxStackSizeTooltipMode = builder
          .comment("Configure tooltip for max stack size.")
          .translation(Translations.STACK_SIZE_MODE)
          .defineEnum("maxStackSizeTooltipMode", Mode.ON_DEBUG);

      nbtTooltipMode = builder
          .comment("Configure tooltip for NBT data.")
          .translation(Translations.NBT_DATA_MODE)
          .defineEnum("nbtTooltipMode", Mode.ON_DEBUG);

      registryNameTooltipMode = builder
          .comment("Configure tooltip for registry name. E.g. minecraft:stone")
          .translation(Translations.REGISTRY_NAME_MODE)
          .defineEnum("registryNameTooltipMode", Mode.DISABLED);

      tagsTooltipMode = builder
          .comment("Configure tooltip for tags. E.g. forge:ingot, minecraft:planks")
          .translation(Translations.TAGS_MODE)
          .defineEnum("tagsTooltipMode", Mode.ON_DEBUG);

      translationKeyTooltipMode = builder
          .comment("Configure tooltip for translation key. E.g. block.minecraft.stone")
          .translation(Translations.TRANSLATION_KEY_MODE)
          .defineEnum("translationKeyTooltipMode", Mode.ON_DEBUG);

      builder.pop();
    }
  }
}
