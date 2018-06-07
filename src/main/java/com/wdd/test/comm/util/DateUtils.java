package com.wdd.test.comm.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{

        /**
         * 日期格式.
         */
        public enum Format {

            /** The format used is <tt>yyyy-MM-dd HH:mm:ss</tt>. */
            DATETIME("yyyy-MM-dd HH:mm:ss"),

            /** The format used is <tt>yyyy-MM-dd HH:mm:ssZZ</tt>. */
            DATETIME_TIME_ZONE("yyyy-MM-dd HH:mm:ssZZ"),

            /** The format used is <tt>yyyy-MM-dd</tt>. */
            DATE("yyyy-MM-dd"),

            /** The format used is <tt>HH:mm:ss</tt>. */
            TIME("HH:mm:ss"),

            /** The format used is <tt>HH:mm:ssZZ</tt>. */
            TIME_NO_T_TIME_ZONE("HH:mm:ssZZ"),

            /** The format used is <tt>yyyy</tt>. */
            YEAR("yyyy"),

            /** The format used is <tt>yy</tt>. */
            YEAR_TWO("yyyy"),

            /** The format used is <tt>MM</tt>. */
            MONTH("MM"),

            /** The format used is <tt>M</tt>. */
            MONTH_ONE("M"),

            /** The format used is <tt>yyyy-MM</tt>. */
            YEAR_MONTH("yyyy-MM"),

            /** The format used is <tt>yyyy-MM</tt>. */
            HOURE_MINUTE("HH:mm"),
            ;

            private String value;

            private Format(String value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return this.value;
            }
        }

        /**
         * 格式化日期为{@link DateFormat.DATETIME}格式.
         *
         * @param date
         * @param pattern
         * @return
         */
        public static String formatDatetime(Date date) {
            return formatDate(date, Format.DATETIME.toString());
        }

        /**
         * 格式化日期为{@link DateFormat.DATE}格式.
         *
         * @param date
         * @param pattern
         * @return
         */
        public static String formatDate(Date date) {
            return formatDate(date, Format.DATE.toString());
        }

        /**
         * 格式化日期为{@link DateFormat.TIME}格式.
         *
         * @param date
         * @param pattern
         * @return
         */
        public static String formatTime(Date date) {
            return formatDate(date, Format.TIME.toString());
        }

        /**
         * 按指定的格式格式化日期, 默认格式: {@link DateFormat.DATE}.
         *
         * @param date
         * @param pattern
         * @return string
         */
        public static String formatDate(Date date, String pattern) {
            if (date == null) {
                return null;
            }
            String formatDate = null;
            if (pattern == null) {
                pattern = Format.DATE.toString();
            }
            formatDate = DateFormatUtils.format(date, pattern);
            return formatDate;
        }

        /**
         * 日期型字符串转化为日期, 默认格式: {@link DateFormat.DATE}.
         *
         * @param str
         * @param pattern
         * @return date
         */
        public static Date parseDateTime(String str, String pattern) {
            if (str == null) {
                return null;
            }
            if (pattern == null || pattern.trim() == "") {
                pattern = Format.DATE.toString();
            }
            try {
                return parseDate(str.toString(), new String[] {pattern});
            } catch (ParseException e) {
                throw new RuntimeException("日期格式异常：["+str+"]",e);
            }
        }

        /**
         * 字符日期转换成格式为：{@link DateFormat.DATETIME}的日期.
         *
         * @param str
         * @return data
         */
        public static Date parseDatetime(String str) {
            return parseDateTime(str, Format.DATETIME.toString());
        }
        public static Date parseDate(String str) {
            return parseDateTime(str, Format.DATE.toString());
        }

        /**
         * 比较两个日期之间的大小
         *
         * @param d1
         * @param d2
         * @return 前者大于后者返回true 反之false
         */
        public static boolean compareDate(Date d1, Date d2) {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(d1);
            c2.setTime(d2);

            int result = c1.compareTo(c2);

            if (result > 0)
                return true;
            else
                return false;
        }


}
