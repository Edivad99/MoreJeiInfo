package edivad.morejeiinfo.platform;

import java.util.function.Supplier;
import edivad.morejeiinfo.platform.services.IPlatformHelper;
import edivad.morejeiinfo.platform.services.IPlatformItemStackHelper;
import edivad.morejeiinfo.util.LazySupplier;

public class FabricPlatformHelper implements IPlatformHelper {

  private final Supplier<ItemStackHelper> itemStackHelper =
      new LazySupplier<>(ItemStackHelper::new);

  @Override
  public IPlatformItemStackHelper getItemStackHelper() {
    return this.itemStackHelper.get();
  }
}
