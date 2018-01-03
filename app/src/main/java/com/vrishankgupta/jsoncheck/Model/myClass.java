package com.vrishankgupta.jsoncheck.Model;

/**
 * Created by vrishankgupta on 03/01/18.
 */

public class myClass {
    public static final String NAME = "name";
    public static final String COLLEGE = "college";
    public static final String COURSE = "course";
    public static final String BRANCH = "branch";
    public static final String ROLL_NUMBER = "roll_number";

    private String name,college,course,branch;
    private int roll_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

}
