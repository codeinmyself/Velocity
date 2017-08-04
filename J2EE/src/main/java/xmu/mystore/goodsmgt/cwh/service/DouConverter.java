package xmu.mystore.goodsmgt.cwh.service;

import org.springframework.core.convert.converter.Converter;

public class DouConverter implements Converter<String, Double> {

    @Override
    public Double convert(String text) {
        if (text == null || "".equals(text)) {
            return 0.0;
        } else {
            try {
            	Double value = Double.parseDouble(text);
                return value;
            } catch (Exception e) {
                return 0.0;
            }
        }
    }

}
