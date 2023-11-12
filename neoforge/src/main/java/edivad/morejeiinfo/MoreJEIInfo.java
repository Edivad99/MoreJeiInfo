package edivad.morejeiinfo;

import edivad.morejeiinfo.config.Config;
import edivad.morejeiinfo.data.MoreJeiInfoLanguageProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.network.NetworkConstants;

@Mod(Shared.ID)
public class MoreJEIInfo {

  public MoreJEIInfo(IEventBus modEventBus, Dist dist) {
    modEventBus.register(Config.class);
    modEventBus.addListener(this::handleGatherData);

    if (dist.isClient()) {
      NeoForge.EVENT_BUS.register(new TooltipEventHandler());
    }

    var modLoadingContext = ModLoadingContext.get();
    modLoadingContext.registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
    // Make sure the mod being absent on the other network side does not cause the client
    // to display the server as incompatible
    modLoadingContext.registerExtensionPoint(IExtensionPoint.DisplayTest.class,
        () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY,
            (a, b) -> true));
  }

  private void handleGatherData(GatherDataEvent event) {
    var generator = event.getGenerator();
    var packOutput = generator.getPackOutput();

    generator.addProvider(event.includeClient(), new MoreJeiInfoLanguageProvider(packOutput));
  }
}
