package edivad.morejeiinfo.informations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;

public class Tags implements Information {

  private final Supplier<Mode> mode;

  public Tags(Supplier<Mode> mode) {
    this.mode = mode;
  }

  @Override
  public List<Component> addInformation(ItemStack itemStack) {
    if (itemStack.getTags().findAny().isPresent()) {
      var result = new ArrayList<Component>();
      result.add(Component.translatable(Translations.TAGS));

      itemStack.getTags()
          .map(TagKey::location)
          .sorted((rl1, rl2) -> {
            String namespaceRl1 = rl1.getNamespace();
            String namespaceRl2 = rl2.getNamespace();
            if (namespaceRl1.equals("minecraft") && !namespaceRl2.equals("minecraft")) {
              return -1;
            }
            if (namespaceRl2.equals("minecraft") && !namespaceRl1.equals("minecraft")) {
              return 1;
            }
            return rl1.toString().compareTo(rl2.toString());
          })
          .map(tag -> Component.literal(StringUtils.repeat(' ', 4) + tag))
          .collect(Collectors.toCollection(() -> result));
      return result;
    }
    return List.of();
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
