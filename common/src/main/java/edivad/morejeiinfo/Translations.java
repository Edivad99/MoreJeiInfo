package edivad.morejeiinfo;

import java.util.ArrayList;
import java.util.List;
import com.mojang.datafixers.util.Pair;

public class Translations {

  public static final String BURN_TIME = makeKey("tooltip", "burnTime");
  public static final String DURABILITY = makeKey("tooltip", "durability");
  public static final String ENCHANTABILITY = makeKey("tooltip", "enchantability");
  public static final String FOOD = makeKey("tooltip", "hunger");
  public static final String NBT_DATA = makeKey("tooltip", "nbtData");
  public static final String REGISTRY_NAME = makeKey("tooltip", "registryName");
  public static final String STACK_SIZE = makeKey("tooltip", "stackSize");
  public static final String TAGS = makeKey("tooltip", "tags");
  public static final String TRANSLATION_KEY = makeKey("tooltip", "translationKey");

  public static final String BURN_TIME_MODE = makeKey("config", "burnTimeMode");
  public static final String DURABILITY_MODE = makeKey("config", "durabilityMode");
  public static final String ENCHANTABILITY_MODE = makeKey("config", "enchantabilityMode");
  public static final String FOOD_MODE = makeKey("config", "foodMode");
  public static final String NBT_DATA_MODE = makeKey("config", "nbtDataMode");
  public static final String REGISTRY_NAME_MODE = makeKey("config", "registryNameMode");
  public static final String STACK_SIZE_MODE = makeKey("config", "stackSizeMode");
  public static final String TAGS_MODE = makeKey("config", "tagsMode");
  public static final String TRANSLATION_KEY_MODE = makeKey("config", "translationKeyMode");


  public static String makeKey(String type, String name) {
    return type + "." + Shared.ID + "." + name;
  }

  public static List<Pair<String, String>> TRANSLATIONS = new ArrayList<>();

  static {
    TRANSLATIONS.add(new Pair<>(Translations.BURN_TIME, "Burn Time: %s ticks"));
    TRANSLATIONS.add(new Pair<>(Translations.DURABILITY, "Durability: %s/%s"));
    TRANSLATIONS.add(new Pair<>(Translations.ENCHANTABILITY, "Enchantability: %s"));
    TRANSLATIONS.add(new Pair<>(Translations.FOOD, "Hunger: %s Saturation: %s"));
    TRANSLATIONS.add(new Pair<>(Translations.STACK_SIZE, "Max stack size: %s"));
    TRANSLATIONS.add(new Pair<>(Translations.NBT_DATA, "NBT: %s"));
    TRANSLATIONS.add(new Pair<>(Translations.REGISTRY_NAME, "Registry name: %s"));
    TRANSLATIONS.add(new Pair<>(Translations.TAGS, "Tags:"));
    TRANSLATIONS.add(new Pair<>(Translations.TRANSLATION_KEY, "Translation key: %s"));
    TRANSLATIONS.add(new Pair<>(Translations.BURN_TIME_MODE, "Burn Time Tooltip"));
    TRANSLATIONS.add(new Pair<>(Translations.DURABILITY_MODE, "Durability Tooltip"));
    TRANSLATIONS.add(new Pair<>(Translations.ENCHANTABILITY_MODE, "Enchantability Tooltip"));
    TRANSLATIONS.add(new Pair<>(Translations.FOOD_MODE, "Hunger/Saturation Tooltip"));
    TRANSLATIONS.add(new Pair<>(Translations.NBT_DATA_MODE, "NBT Tooltip"));
    TRANSLATIONS.add(new Pair<>(Translations.REGISTRY_NAME_MODE, "Registry name Tooltip"));
    TRANSLATIONS.add(new Pair<>(Translations.STACK_SIZE_MODE, "Max stack size Tooltip"));
    TRANSLATIONS.add(new Pair<>(Translations.TAGS_MODE, "Tags Tooltip"));
    TRANSLATIONS.add(new Pair<>(Translations.TRANSLATION_KEY_MODE, "Translation key Tooltip"));
  }
}
