package edivad.morejeiinfo.data;

import edivad.morejeiinfo.Shared;
import edivad.morejeiinfo.Translations;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class MoreJeiInfoLanguageProvider extends LanguageProvider {

  public MoreJeiInfoLanguageProvider(PackOutput packOutput) {
    super(packOutput, Shared.ID, "en_us");
  }

  @Override
  protected void addTranslations() {
    for(var line: Translations.TRANSLATIONS) {
      this.add(line.getFirst(), line.getSecond());
    }
  }
}
