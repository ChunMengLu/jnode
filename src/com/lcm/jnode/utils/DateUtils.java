package com.lcm.jnode.utils;

import java.sql.Timestamp;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * 格式化 Timestamp
 * @author L.cm
 * @date 2013-5-15 下午1:52:03
 */
public class DateUtils {
    
    public static final FastDateFormat DATE_FORMAT_CN = FastDateFormat.getInstance("yyyy年 MM月 dd日");
    
    public static String formatCn(Timestamp tamp) {
        return DATE_FORMAT_CN.format(tamp);
    }
}
