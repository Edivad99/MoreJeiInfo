package edivad.morejeiinfo;

public class Translations {

  public static final String BURN_TIME = makeKey("tooltip", "burnTime");
  public static final String DURABILITY = makeKey("tooltip", "durability");
  public static final String ENCHANTABILITY = makeKey("tooltip", "enchantability");
  public static final String FOOD = makeKey("tooltip", "hunger");
  public static final String NBT_DATA = makeKey("tooltip", "nbtData");
  public static final String REGISTRY_NAME = makeKey("tooltip", "registryName");
  public static final String STACKSIZE = makeKey("tooltip", "stackSize");
  public static final String TAGS = makeKey("tooltip", "tags");
  public static final String TRANSLATION_KEY = makeKey("tooltip", "translationKey");

  public static final String BURN_TIME_MODE = makeKey("config", "burnTimeMode");
  public static final String DURABILITY_MODE = makeKey("config", "durabilityMode");
  public static final String ENCHANTABILITY_MODE = makeKey("config", "enchantabilityMode");
  public static final String FOOD_MODE = makeKey("config", "foodMode");
  public static final String NBT_DATA_MODE = makeKey("config", "nbtDataMode");
  public static final String REGISTRY_NAME_MODE = makeKey("config", "registryNameMode");
  public static final String STACKSIZE_MODE = makeKey("config", "stackSizeMode");
  public static final String TAGS_MODE = makeKey("config", "tagsMode");
  public static final String TRANSLATION_KEY_MODE = makeKey("config", "translationKeyMode");


  public static String makeKey(String type, String name) {
    return type + "." + MoreJEIInfo.ID + "." + name;
  }
}
