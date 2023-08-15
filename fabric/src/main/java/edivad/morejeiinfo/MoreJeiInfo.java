package edivad.morejeiinfo;

import edivad.morejeiinfo.config.Config;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class MoreJeiInfo implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    Config.registerConfigs();
    ItemTooltipCallback.EVENT.register(TooltipEventHandler::onItemTooltip);
  }
}
