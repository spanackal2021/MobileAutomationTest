package com.utils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;

public class UtilConstants {

    public static HashMap<String, String> calculatedDaysAndTime = new HashMap<>();
    public static HashMap<String, Integer> calculatedMonths = new HashMap<>();

    private static Properties env_properties = null;

    public static Properties ENV_PROPERTIES() throws Exception {
        if(env_properties == null){
            try{
                env_properties = PropertiesFileReader.getInstance().getProperties("env.properties");
            }
            catch (Exception ex){
                ex.printStackTrace();
                throw new Exception(ex.getMessage());
            }
        }
        return env_properties;
    }


    private static String GetPropertyValue(String propName) {
        String propertyValue = "";
        try{
            propertyValue = PropertiesFileReader.getInstance().getPropertyValue(ENV_PROPERTIES(), propName);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return propertyValue;
    }

    public static String getMeetingTitle(){
        return GetPropertyValue("meetingTitle");
    }

    public static String getMeetingStartTime(){
        return GetPropertyValue("meetingStartTime");
    }

    public static String getStartDay(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return dateTimeFormatter.format(localDate.with(TemporalAdjusters.next(DayOfWeek.valueOf(calculatedDaysAndTime.get("firstDay").toUpperCase()))));
    }

    public static void getAlternateDays(String startDay){
        LocalDate localDate = LocalDate.now();
        calculatedDaysAndTime.put("currentDay",localDate.getDayOfWeek().toString());
        calculatedMonths.put("currentMonth",localDate.getMonthValue());
        LocalDate startWeekdayDate = localDate.with(TemporalAdjusters.next(DayOfWeek.valueOf(startDay.toUpperCase())));
        calculatedMonths.put("firstDayMonth",startWeekdayDate.getMonthValue());
        calculatedDaysAndTime.put("firstDay",startDay.toUpperCase());
        calculatedDaysAndTime.put("secondDay",startWeekdayDate.plusDays(2).getDayOfWeek().toString());
        calculatedDaysAndTime.put("thirdDay",startWeekdayDate.plusDays(4).getDayOfWeek().toString());
    }

    public static String getEndTime(String meetingHourDuration, String meetingMinuteDuration){
        SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("hh:mm aa");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, Integer.parseInt(getMeetingStartTime().split(":")[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(getMeetingStartTime().split(":")[1].split(" ")[0]));
        String amPmMarker = getMeetingStartTime().split(":")[1].split(" ")[1];

        if(amPmMarker.contentEquals("AM")){
            calendar.set(Calendar.AM_PM, 0);
        }
        else if (amPmMarker.contentEquals("PM")){
            calendar.set(Calendar.AM_PM, 1);
        }

        calendar.add(Calendar.HOUR, Integer.parseInt(meetingHourDuration));
        calendar.add(Calendar.MINUTE, Integer.parseInt(meetingMinuteDuration));

        calculatedDaysAndTime.put("meetingEndTime",simpleDateFormat.format(calendar.getTime()));

        return calculatedDaysAndTime.get("meetingEndTime");
    }


    public static String getPlatformName(){
        return GetPropertyValue("platformName");
    }

    public static String getPlatformVersion(){
        return GetPropertyValue("platformVersion");
    }

    public static String getAppPackage(){
        return GetPropertyValue("appPackage");
    }

    public static String getAppActivity(){
        return GetPropertyValue("appActivity");
    }

    public static String getBaseUrl(){
        return GetPropertyValue("baseUrl");
    }

    public static String getPort(){
        return GetPropertyValue("port");
    }


    public static String getCurrentTimeStamp(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss").format(LocalDateTime.now());
    }
}
