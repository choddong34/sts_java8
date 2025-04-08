package kr.re.kepri.pcm.common.util;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import org.apache.commons.text.StringEscapeUtils;

/**
 * XSS 치환 클래스
 */
public class XssCharacterEscapes extends CharacterEscapes {
    private static final long serialVersionUID = 1L;

    private final int[] asciiEscapes;
    private static final char ZERO_WIDTH_JOINER = 0x200D;

    public XssCharacterEscapes() {
        asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
        asciiEscapes['<'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['>'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\"'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['('] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes[')'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['#'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM;
    }

    @Override
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }

    @Override
    public SerializableString getEscapeSequence(int character) {
        char charAt = (char) character;
        if (Character.isHighSurrogate(charAt) || Character.isLowSurrogate(charAt) || charAt == ZERO_WIDTH_JOINER) {
            StringBuilder sb = new StringBuilder();
            sb.append("\\u");
            sb.append(String.format("%04x", character));
            return new SerializedString(sb.toString());
        } else {
            return new SerializedString(StringEscapeUtils.escapeHtml4(Character.toString(charAt)));
        }
    }

}
