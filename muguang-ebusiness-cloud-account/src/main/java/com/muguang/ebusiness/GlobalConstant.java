package com.muguang.ebusiness;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muguang
 * @date 2017/3/6 14:42.
 */
public class GlobalConstant {

    public static Map<String, Long> tokencache;
    static {
        tokencache = new HashMap<>();
    }
}
