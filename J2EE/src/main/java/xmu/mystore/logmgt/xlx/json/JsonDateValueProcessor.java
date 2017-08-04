package xmu.mystore.logmgt.xlx.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
/**
 *用于对象转换成json的时候，遇到timstamp类型就转换程固定format的字符串
 * @author XingLX
 *
 */


public class JsonDateValueProcessor implements JsonValueProcessor {
	 /**
     * datePattern
     */
    private String datePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * JsonDateValueProcessor
     */
    public JsonDateValueProcessor() {
        super();
    }

    /**
     * @param format
     */
    public JsonDateValueProcessor(String format) {
        super();
        this.datePattern = format;
    }

    /**
     * @param value
     * @param jsonConfig
     * @return Object
     */
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    /**
     * @param key
     * @param value
     * @param jsonConfig
     * @return Object
     */
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    /**
     * process
     *
     * @param value
     * @return
     */
    private Object process(Object value) {
        try {
                SimpleDateFormat sdf = new SimpleDateFormat(datePattern);               
                return sdf.format(value);
        } catch (Exception e) {
            return "";
        }

    }

    
}
