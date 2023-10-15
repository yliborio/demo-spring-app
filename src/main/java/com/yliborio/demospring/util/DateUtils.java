package com.yliborio.demospring.util;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DateUtils {

    public Date createDateFromDateString(String dateString){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        LocalDate localDate = LocalDate.now();
        if(StringUtils.hasText(dateString)){
                date = Date.valueOf(dateString);
        }else{
            date = Date.valueOf(localDate);
        }
        return date;
    }
}