package com.leekyu.study.common.util;

import org.apache.commons.text.StringEscapeUtils;

/**
 * XssUtil 클래스
 */
public class XssUtil {

    public static String charEscape(String value) {
        return value == null ? value : StringEscapeUtils.escapeHtml4(value);
    }
}
