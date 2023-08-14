package edivad.morejeiinfo;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import edivad.morejeiinfo.data.MoreJeiInfoLanguageProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;

@Mod(MoreJEIInfo.ID)
public class MoreJEIInfo {

  public static final String ID = "morejeiinfo";
  public static final Logger LOGGER = LogUtils.getLogger();

  public MoreJEIInfo() {
    var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    modEventBus.register(Config.class);
    modEventBus.addListener(this::handleGatherData);

    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> MinecraftForge.EVENT_BUS.register(new TooltipEventHandler()));

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
