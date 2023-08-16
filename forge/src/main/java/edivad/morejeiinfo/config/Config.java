package edivad.morejeiinfo.config;

import edivad.morejeiinfo.Shared;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Shared.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

  public static final ForgeConfigSpec CLIENT_SPEC;
  public static final Config.Client CLIENT;

  static {
    final var specPair = new ForgeConfigSpec.Builder().configure(Config.Client::new);
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
