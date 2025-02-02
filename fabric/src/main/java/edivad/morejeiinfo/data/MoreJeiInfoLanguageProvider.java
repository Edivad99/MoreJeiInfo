package edivad.morejeiinfo.data;

import java.util.concurrent.CompletableFuture;
import edivad.morejeiinfo.Translations;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

public class MoreJeiInfoLanguageProvider extends FabricLanguageProvider {

  protected MoreJeiInfoLanguageProvider(FabricDataOutput dataOutput,
      CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(dataOutput, "en_us", registryLookup);
  }

  @Override
  public void generateTranslations(HolderLookup.Provider provider,
      TranslationBuilder translationBuilder) {
    for (var line : Translations.TRANSLATIONS) {
      translationBuilder.add(line.getFirst(), line.getSecond());
    }
  }
}
