package kr.re.kepri.pcm.common.util;

import org.apache.commons.collections4.map.ListOrderedMap;

/**
 * 결과 맵 클래스
 * @author 동준
 *
 */
@SuppressWarnings("rawtypes")
public class ResultMap extends ListOrderedMap {

    /**
     *
     */
    private static final long serialVersionUID = -4987540987453533564L;

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {

        return super.put(CamelUtil.convert2CamelCase((String) key) , value);
    }
}
