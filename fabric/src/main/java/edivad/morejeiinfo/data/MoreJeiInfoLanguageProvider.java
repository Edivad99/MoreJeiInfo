package edivad.morejeiinfo.data;

import edivad.morejeiinfo.Translations;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class MoreJeiInfoLanguageProvider extends FabricLanguageProvider {

  public MoreJeiInfoLanguageProvider(FabricDataOutput dataOutput) {
    super(dataOutput, "en_us");
  }

  @Override
  public void generateTranslations(TranslationBuilder translationBuilder) {
    for (var line : Translations.TRANSLATIONS) {
      translationBuilder.add(line.getFirst(), line.getSecond());
    }
  }
}
