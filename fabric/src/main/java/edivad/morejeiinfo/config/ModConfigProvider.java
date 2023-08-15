package edivad.morejeiinfo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.mojang.datafixers.util.Pair;
import edivad.morejeiinfo.tooltip.Mode;

public class ModConfigProvider implements SimpleConfig.DefaultConfig {

  private static final String ALLOWED_VALUES = "Allowable values: " + getNames(Mode.class);
  private final List<Pair<String, ?>> configsList = new ArrayList<>();
  private String configContents = "";

  private static String getNames(Class<? extends Enum<?>> e) {
    return Arrays.stream(e.getEnumConstants())
        .map(Enum::name)
        .collect(Collectors.joining(", "));
  }

  public List<Pair<String, ?>> getConfigsList() {
    return configsList;
  }

  public void addKeyValuePair(Pair<String, Mode> keyValuePair) {
    configsList.add(keyValuePair);
    var fst = keyValuePair.getFirst();
    var snd = keyValuePair.getSecond();

    configContents += fst + "=" + snd + " #" + ALLOWED_VALUES + " | default: " + snd + "\n";
  }

  @Override
  public String get(String namespace) {
    return configContents;
  }
}