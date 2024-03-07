package edivad.morejeiinfo.informations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import edivad.morejeiinfo.Translations;
import edivad.morejeiinfo.tooltip.Mode;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
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
      result.add(Component.translatable(Translations.ITEM_TAGS));
      result.addAll(getTags(itemStack.getTags()));

      if (itemStack.getItem() instanceof BlockItem blockItem) {
        var block = blockItem.getBlock();
        result.add(Component.translatable(Translations.BLOCK_TAGS));
        result.addAll(getTags(block.builtInRegistryHolder().tags()));
      }
      return result;
    }
    return List.of();
  }

  private <T> List<Component> getTags(Stream<TagKey<T>> tags) {
    return tags
        .map(TagKey::location)
        .sorted(Tags::compare)
        .map(tag -> Component.literal(StringUtils.repeat(' ', 4) + tag))
        .collect(Collectors.toList());
  }

  private static int compare(ResourceLocation rl1, ResourceLocation rl2) {
    var namespaceRl1 = rl1.getNamespace();
    var namespaceRl2 = rl2.getNamespace();
    if (namespaceRl1.equals("minecraft") && !namespaceRl2.equals("minecraft")) {
      return -1;
    }
    if (namespaceRl2.equals("minecraft") && !namespaceRl1.equals("minecraft")) {
      return 1;
    }
    return rl1.toString().compareTo(rl2.toString());
  }

  @Override
  public Mode getMode() {
    return this.mode.get();
  }
}
