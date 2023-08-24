package com.baizhi.converter;

import org.springframework.core.convert.converter.Converter;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter<String, Date> {
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /*
            convert方法作用：String --->Date
                            SimpleDateFormat.parset("")
            param:source 代表的是配置文件中的 日期字符串 <value>2020-1-2</value>
            return：当把转换好的Date作为convert方法的返回值后，Spring自动为birthday属性进行注入(赋值)
         */
    @Override
    public Date convert(String source) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
