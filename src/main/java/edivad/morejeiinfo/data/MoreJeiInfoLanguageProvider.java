package edivad.morejeiinfo.data;

import edivad.morejeiinfo.MoreJEIInfo;
import edivad.morejeiinfo.Translations;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class MoreJeiInfoLanguageProvider extends LanguageProvider {

  public MoreJeiInfoLanguageProvider(PackOutput packOutput) {
    super(packOutput, MoreJEIInfo.ID, "en_us");
  }

  @Override
  protected void addTranslations() {
    this.add(Translations.BURN_TIME, "Burn Time: %s ticks");
    this.add(Translations.DURABILITY, "Durability: %s/%s");
    this.add(Translations.ENCHANTABILITY, "Enchantability: %s");
    this.add(Translations.FOOD, "Hunger: %s Saturation: %s");
    this.add(Translations.STACKSIZE, "Max stack size: %s");
    this.add(Translations.NBT_DATA, "NBT: %s");
    this.add(Translations.REGISTRY_NAME, "Registry name: %s");
    this.add(Translations.TAGS, "Tags:");
    this.add(Translations.TRANSLATION_KEY, "Translation key: %s");
    this.add(Translations.BURN_TIME_MODE, "Burn Time Tooltip");
    this.add(Translations.DURABILITY_MODE, "Durability Tooltip");
    this.add(Translations.ENCHANTABILITY_MODE, "Enchantability Tooltip");
    this.add(Translations.FOOD_MODE, "Hunger/Saturation Tooltip");
    this.add(Translations.NBT_DATA_MODE, "NBT Tooltip");
    this.add(Translations.REGISTRY_NAME_MODE, "Registry name Tooltip");
    this.add(Translations.STACKSIZE_MODE, "Max stack size Tooltip");
    this.add(Translations.TAGS_MODE, "Tags Tooltip");
    this.add(Translations.TRANSLATION_KEY_MODE, "Translation key Tooltip");
  }
}
