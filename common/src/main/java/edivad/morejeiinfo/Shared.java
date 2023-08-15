package edivad.morejeiinfo;

import java.text.DecimalFormat;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

public class Shared {

  public static final String ID = "morejeiinfo";
  public static final String NAME = "MoreJeiInfo";
  public static final Logger LOGGER = LogUtils.getLogger();

  public static final DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");

  static {
    DECIMALFORMAT.setGroupingUsed(true);
    DECIMALFORMAT.setGroupingSize(3);
  }
}