package edivad.morejeiinfo;

import edivad.morejeiinfo.config.Config;
import edivad.morejeiinfo.data.MoreJeiInfoLanguageProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(Shared.ID)
public class MoreJEIInfo {

  public MoreJEIInfo(ModContainer modContainer, Dist dist) {

    var modEventBus = modContainer.getEventBus();
    modEventBus.register(Config.class);
    modEventBus.addListener(this::handleGatherData);

    if (dist.isClient()) {
      NeoForge.EVENT_BUS.register(new TooltipEventHandler());
    }

    modContainer.registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
  }

  private void handleGatherData(GatherDataEvent.Client event) {
    event.createProvider(MoreJeiInfoLanguageProvider::new);
  }
}
