package com.supermarket.api.util;

import java.math.BigDecimal;
import org.apache.commons.lang3.ObjectUtils;

public final class MoneyUtil {

    private static final String BR_MONEY_SYMBOL = "R$ ";
    public static String moneyConverter(final BigDecimal value) {
        if (ObjectUtils.isEmpty(value)) return "";

        return BR_MONEY_SYMBOL.concat(value.toString()).replace(".",",");
    }
}
