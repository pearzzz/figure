package com.red.result;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:25 2022-07-27
 */
public class YearTagResult {
    private long userid;
    private String yearTag;
    private String timeString;
    private String groupField;
    private long numbers;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getYearTag() {
        return yearTag;
    }

    public void setYearTag(String yearTag) {
        this.yearTag = yearTag;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public long getNumbers() {
        return numbers;
    }

    public void setNumbers(long numbers) {
        this.numbers = numbers;
    }
}
