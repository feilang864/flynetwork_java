/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sz.pool;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 *
 * @author Administrator
 */
public class TimeUtil {

    //<editor-fold desc=" 验证时间 返回倒计时 :[*][*][20/22][*][10:00-11:59/16:00-17:59] static public long verifyDateTime(String timeStr)">
    /// <summary>
    /// 验证时间:[*][*][20/22][*][10:00-11:59/16:00-17:59]
    /// <para>第一个是年，，第二个是月，第三个是日期，第四个是星期，第五个是时间，</para>
    /// <para>每一个参数，"-" 表示 到 如：“2015-2017”表示 2015 到 2017, "/"  表示 或者 如： “2015/2017”表示2015 或者 2017</para>
    /// <para>返回值 -1 表示永久过期，0 表示在时间规则内，大于 0 表示倒计时</para>
    /// </summary>
    /**
     * 验证时间:[*][*][20/22][*][10:00-11:59/16:00-17:59]
     * <\br>第一个是年，，第二个是月，第三个是日期，第四个是星期，第五个是时间，
     * <\br>每一个参数，"-" 表示 到 如：“2015-2017”表示 2015 到 2017, "/" 表示 或者 如：
     * “2015/2017”表示2015 或者 2017
     * <\br>返回值 -1 表示永久过期，0 表示在时间规则内，大于 0 表示倒计时
     *
     * @param timeStr
     * @return
     */
    static public long verifyDateTime(String timeStr) {
        String[] items = timeStr.split(";|；");
        Calendar calendar = Calendar.getInstance();
        for (String item : items) {
            //验证时间匹配
            if (verifyConfigTimeStr(calendar, item)) {
                return 0;
            }
            //未通过时间匹配，检查返回剩余时间
            String[] timeStrs = item.replace("[", "").split("]");

            String times = timeStrs[4];
            String weeks = timeStrs[3];
            String days = timeStrs[2];
            String months = timeStrs[1];
            String years = timeStrs[0];

            int hour = 0, minute = 0, second = 0;

            ArrayList<Integer> tempYears = getConfigDate(calendar, calendar.get(Calendar.YEAR), years);
            ArrayList<Integer> tempMonths = getConfigDate(calendar, calendar.get(Calendar.MONTH) + 1, months);
            ArrayList<Integer> tempDays = getConfigDate(calendar, calendar.get(Calendar.DATE), days);
            //由于星期比较特殊所以获取与星期相关的日期的时候有点诡异。
            if (!"*".equals(weeks)) {
                if (weeks.indexOf("-") > 0) {
                    //星期的间隔模式
                    String[] weeksplit = weeks.split("-");
                    int weekmin = Integer.parseInt(weeksplit[0]);
                    int weekmax = Integer.parseInt(weeksplit[1]);
                    actionWeekDay(weekmin, weekmax, tempDays, tempMonths, tempYears);
                } else if (weeks.indexOf("/") > 0) {
                    //星期的或模式
                    String[] weekssplit = weeks.split("/");
                    int tempWeek;
                    for (String weekssplit1 : weekssplit) {
                        tempWeek = Integer.parseInt(weekssplit1);
                        if (0 <= tempWeek && tempWeek <= 7) {
                            actionWeekDay(tempWeek, tempWeek, tempDays, tempMonths, tempYears);
                        }
                    }
                } else {
                    //特定星期的模式
                    int tempweek = Integer.parseInt(weeks);
                    actionWeekDay(tempweek, tempweek, tempDays, tempMonths, tempYears);
                }
            } else {
                //未指定星期的模式
                actionWeekDay(1, 7, tempDays, tempMonths, tempYears);
            }

            ArrayList<String> tempHHMMs = getConfigTimeStr(times);

            //进行简单的排序
            Collections.sort(tempYears);
            Collections.sort(tempMonths);
            Collections.sort(tempDays);
            Collections.sort(tempHHMMs);

            //接下来这里是天坑，就是构造时间器比较，然后计算出倒计时
            for (int y = 0; y < tempYears.size(); y++) {
                for (int m = 0; m < tempMonths.size(); m++) {
                    for (int d = 0; d < tempDays.size(); d++) {
                        if (tempYears.get(y) < calendar.get(Calendar.YEAR)) {
                            continue;
                        }
                        if (tempYears.get(y) == calendar.get(Calendar.YEAR) && tempMonths.get(m) - 1 < calendar.get(Calendar.MONTH)) {
                            continue;
                        }
                        if (tempYears.get(y) == calendar.get(Calendar.YEAR) && tempMonths.get(m) - 1 == calendar.get(Calendar.MONTH) && tempDays.get(d) < calendar.get(Calendar.DATE)) {
                            continue;
                        }
                        for (int h = 0; h < tempHHMMs.size(); h++) {
                            String[] hhmm = tempHHMMs.get(h).split(":|：");
                            hour = Integer.parseInt(hhmm[0]);
                            minute = Integer.parseInt(hhmm[1]);
                            Calendar calendar1 = Calendar.getInstance();
                            calendar1.set(tempYears.get(y), (tempMonths.get(m) - 1), tempDays.get(d), hour, minute, second);
//                            System.out.println(DF2.format(calendar1.getTime()) + "   " + DF2.format(calendar.getTime()));
//                            System.out.println(calendar1.getTimeInMillis() + "   " + calendar.getTimeInMillis());
                            if (calendar1.getTimeInMillis() > calendar.getTimeInMillis()) {
                                if (verifyConfigTimeStr(calendar1, item)) {
                                    return calendar1.getTimeInMillis() - calendar.getTimeInMillis();
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    //</editor-fold>

    //<editor-fold desc=" 处理星期包含的日期 日 static void actionWeekDay(int weekmin, int weekmax, ArrayList<Integer> days, ArrayList<Integer> months, ArrayList<Integer> years)">
    /**
     * 处理星期包含的日期 日
     *
     * @param weekmin
     * @param weekmax
     * @param days
     * @param months
     * @param years
     */
    static void actionWeekDay(int weekmin, int weekmax, ArrayList<Integer> days, ArrayList<Integer> months, ArrayList<Integer> years) {
        Calendar nowWeekDate = Calendar.getInstance();
        Integer[] tempMonths, tempYears;
        tempYears = years.toArray(new Integer[0]);
        tempMonths = months.toArray(new Integer[0]);
        for (int itemYear : tempYears) {
            for (int itemMonth : tempMonths) {
                int itemDay = 1;
                if (nowWeekDate.get(Calendar.MONTH) + 1 == itemMonth) {
                    itemDay = nowWeekDate.get(Calendar.DATE);
                }
                Calendar date = Calendar.getInstance();
                date.set(itemYear, itemMonth - 1, itemDay);
                for (int i = 0; i < 7; i++) {
                    int week = date.get(Calendar.DAY_OF_WEEK) - 1;
                    if (week < 1) {
                        week = 7;
                    }
                    if (weekmin <= week && week <= weekmax) {
                        if (!days.contains(date.get(Calendar.DATE))) {
                            days.add(date.get(Calendar.DATE));
                        }
                        if (!months.contains(date.get(Calendar.MONTH) + 1)) {
                            months.add(date.get(Calendar.MONTH) + 1);
                        }
                        if (!years.contains(date.get(Calendar.YEAR))) {
                            years.add(date.get(Calendar.YEAR));
                        }
                    }
                    date.add(Calendar.DATE, 1);
                }
            }
        }
    }
 //</editor-fold>

    //<editor-fold desc="验证时间:[*][*][20/22][*][10:00-11:59/16:00-17:59] static public boolean verifyConfigTimeStr(String timeStr)">
    /**
     * 验证时间:[*][*][20/22][*][10:00-11:59/16:00-17:59]
     * <para>第一个是年，，第二个是月，第三个是日期，第四个是星期，第五个是时间，</para>
     * <para>每一个参数，"-" 表示 到 如：“2015-2017”表示 2015 到 2017, "/" 表示 或者 如：
     * “2015/2017”表示2015 或者 2017</para>
     *
     */
    static public boolean verifyConfigTimeStr(String timeStr) {
        return verifyConfigTimeStr(Calendar.getInstance(), timeStr);
    }
    //</editor-fold>

    //<editor-fold desc="验证时间:[*][*][20/22][*][10:00-11:59/16:00-17:59] static boolean verifyConfigTimeStr(Calendar date, String timeStr)">
    /**
     * 验证时间:[*][*][20/22][*][10:00-11:59/16:00-17:59]
     * <para>第一个是年，，第二个是月，第三个是日期，第四个是星期，第五个是时间，</para>
     * <para>每一个参数，"-" 表示 到 如：“2015-2017”表示 2015 到 2017, "/" 表示 或者 如：
     * “2015/2017”表示2015 或者 2017</para>
     *
     */
    static boolean verifyConfigTimeStr(Calendar date, String timeStr) {
        String[] timeStrs = timeStr.replace("[", "").split("]");
        if (verifyDate(date.get(Calendar.YEAR), timeStrs[0])) {
            if (verifyDate(date.get(Calendar.MONTH) + 1, timeStrs[1])) {
                // {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
                int week = date.get(Calendar.DAY_OF_WEEK) - 1;
                if (week < 1) {
                    week = 7;
                }//星期天
                if (verifyDate(week, timeStrs[3])) {
                    if (verifyDate(date.get(Calendar.DATE), timeStrs[2])) {
                        if (verifyTime(date, timeStrs[4])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold desc=" 验证当前时间 年，月，日，星期，是否符合 static boolean verifyDate(int nowItem, String items)">
    /**
     * 验证当前时间 年，月，日，星期，是否符合
     *
     * @param nowItem 参数
     * @param items 1-7;表示 1 到 7 , 1/7 表示 1 或者 7
     * @return
     */
    static boolean verifyDate(int nowItem, String items) {
        String nowItemStr = String.valueOf(nowItem);
        if ("*".equals(items) || nowItemStr.equals(items)) {
            return true;
        } else if (items.indexOf("-") > 0) {//区间划分
            String[] itemsplit = items.split("-");
            int item1 = Integer.parseInt(itemsplit[0]);
            int item2 = Integer.parseInt(itemsplit[1]);
            if (item1 <= nowItem && nowItem <= item2) {
                return true;
            }
        } else if (items.indexOf("/") > 0) {//或划分
            String[] weekssplit = items.split("/");
            for (String item : weekssplit) {
                if (nowItemStr.equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold desc="验证当期时间格式 static boolean verifyTime(Calendar date, String itemTime)">
    /**
     * 验证当期时间格式
     *
     * @param date
     * @param itemTime
     * @return
     */
    static boolean verifyTime(Calendar date, String itemTime) {
        boolean ret = false;
        if (!"*".equals(itemTime)) {
            String[] items = itemTime.split("/");
            for (String item : items) {
                String[] itemTimes = item.split("-");
                String[] hhmm = itemTimes[0].split(":|：");
                int hh = Integer.parseInt(hhmm[0]);
                int mm = Integer.parseInt(hhmm[1]);
                if (date.get(Calendar.HOUR_OF_DAY) > hh || (date.get(Calendar.HOUR_OF_DAY) == hh && date.get(Calendar.MINUTE) >= mm)) {
                    if (itemTimes.length > 1) {
                        String[] hhmm1 = itemTimes[1].split(":|：");
                        int hh1 = Integer.parseInt(hhmm1[0]);
                        int mm1 = Integer.parseInt(hhmm1[1]);
                        if (date.get(Calendar.HOUR_OF_DAY) < hh1 || (date.get(Calendar.HOUR_OF_DAY) == hh1 && date.get(Calendar.MINUTE) < mm1)) {
                            ret = true;
                        } else {
                            ret = false;
                        }
                    } else {
                        ret = true;
                    }
                } else {
                    ret = false;
                }
                if (ret) {
                    break;
                }
            }
        } else {
            ret = true;
        }
        return ret;
    }
    //</editor-fold>

    //<editor-fold desc="获取配置的年月日星期等信息  static ArrayList<Integer> getConfigDate(Calendar calendar, int p1, String p3)">
    static ArrayList<Integer> getConfigDate(Calendar calendar, int p1, String p3) {
        ArrayList<Integer> rets = new ArrayList<Integer>();
        String p1Str = String.valueOf(p1);
        if ("*".equals(p3) || p1Str.equals(p3)) {
            rets.add(p1);
            rets.add(p1 + 1);
        } else if (p3.indexOf("-") > 0) {
            String[] weeksplit = p3.split("-");
            int k1 = Integer.parseInt(weeksplit[0]);
            int k2 = Integer.parseInt(weeksplit[0]);
            for (int i = k1; i <= k2 + 1; i++) {
                rets.add(i);
            }
        } else if (p3.indexOf("/") > 0) {
            String[] weekssplit = p3.split("/");
            for (String item : weekssplit) {
                int temp = Integer.parseInt(item);
                rets.add(temp);
            }
        } else {
            rets.add(Integer.parseInt(p3));
        }
        return rets;
    }
    //</editor-fold>

    //<editor-fold desc="获取配置的时间字符串 static ArrayList<String> getConfigTimeStr(String itemTime)">
    /**
     * 必须类似的格式 单条 00:00-23:59 多条00:00-23:59/00:00-23:59
     *
     * @param itemTime
     * @return
     */
    static ArrayList<String> getConfigTimeStr(String itemTime) {
        ArrayList<String> retObjs = new ArrayList<String>();
        // 00:00-23:59
        if (!"*".equals(itemTime)) {
            String[] items = itemTime.split("/");
            for (String item : items) {
                String[] itemTimes = item.split("-");
                retObjs.add(itemTimes[0]);
            }
        } else {
            retObjs.add("00:00");
        }
        return retObjs;
    }
    //</editor-fold>
}
