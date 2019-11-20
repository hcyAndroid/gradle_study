package com.hcy.utilslib.date_utils

import com.hcy.utilslib.app_utils.AppUtils
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

/**
 *@创建人：hcy
 *@创建时间：2019-11-01
 *@作用描述：Function
 *@email:384317693@qq.com
 **/
object DateUtils {
    val TIME_FORMAT_6 = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    /**
     * 计算两个日期之间的天数
     */
    fun countDaysByTwoCalendar(ca1: Calendar, ca2: Calendar): Int {
        val ca1Str = date2String(ca1.time, TIME_FORMAT_6)
        val ca2Str = date2String(ca2.time, TIME_FORMAT_6)
        val ca1Date = TIME_FORMAT_6.parse(ca1Str)
        val ca2Date = TIME_FORMAT_6.parse(ca2Str)
        return abs(n = ((ca2Date.time - ca1Date.time) / 1000 / 60 / 60 / 24).toInt())
    }

    /**
     * 计算两个日期之间的天数,并把日期存在集合中
     */
    fun getAllCalendarsyTwoCalendar(ca1: Calendar, ca2: Calendar): ArrayList<Calendar> {
        val arrayListDates = arrayListOf<Calendar>()
        val a = countDaysByTwoCalendar(ca1, ca2)
        val lastChooseEndDateByByMonths = if (ca1.time.time > ca2.time.time) ca1 else ca2
        for (index in (a) downTo 0 step 1) {
            val instance = Calendar.getInstance()
            instance.time = lastChooseEndDateByByMonths!!.time
            instance.add(Calendar.DATE, -index)
            //instance.set(Calendar.DAY_OF_YEAR, lastChooseEndDateByByWeeks!!.get(Calendar.DAY_OF_YEAR) - index)
            arrayListDates.add(instance)
        }
        return arrayListDates
    }

    /**
     * Date转String
     */
    fun date2String(date: Date, format: DateFormat): String {
        return format.format(date)
    }


    /**
     * String转date
     */
    fun string2Date(date: String, format: DateFormat): Date {
        return format.parse(date)
    }

    /**
     * Calendar转String
     */
    fun date2String(ca: Calendar, format: DateFormat): String {
        return format.format(ca.time)
    }

    /**
     * 获得月
     */
    fun getMonth(ca: Calendar): Int {
        return ca.get(Calendar.MONTH) + 1
    }

    /**
     * 获取月的最后一天
     */
    fun getLastDayByMonth(ca: Calendar): Calendar {
        var lastDayOfMonth = Calendar.getInstance()
        lastDayOfMonth.time = ca.time
        lastDayOfMonth.set(
            Calendar.DAY_OF_MONTH,
            lastDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH)
        )
        return lastDayOfMonth
    }

    /**
     * 获取月的第一天
     */
    fun getFirstDayByMonth(ca: Calendar): Calendar {
        var firstDayOfMonth = Calendar.getInstance()
        firstDayOfMonth.time = ca.time
        firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1)
        return firstDayOfMonth
    }

    /**
     * 获取前x月
     */
    fun Calendar.getXMonthBefore(ca: Calendar, x: Int): Calendar {
        var init = Calendar.getInstance()
        init.time = ca.time
        //获取前i个月
        init.add(Calendar.MONTH, -x)
        return init
    }

    /**
     * 获取周日
     */
    fun getSunday(ca: Calendar): Calendar {
        val caEd = Calendar.getInstance()
        caEd.time = ca.time
        caEd.add(Calendar.WEEK_OF_YEAR, 1)// 增加一个星期，才是我们中国人理解的本周日的日期
        caEd.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
        return caEd
    }

    /**
     * 获取x周前
     */
    fun getXWeekBefore(ca: Calendar, x: Int): Calendar {
        var init = Calendar.getInstance()
        init.time = ca.time
        //获取前i个月
        init.add(Calendar.DATE, -x * 7 + 1)
        return init
    }
}