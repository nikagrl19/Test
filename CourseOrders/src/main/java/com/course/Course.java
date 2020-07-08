package com.course;

import java.util.LinkedList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Course {

    private int courseValue;

    private int courseKey;

    private LinkedList<Course> courseChildList;

    public Course(int value) {
	this.courseValue = value;
	this.courseKey = 0;
	this.courseChildList = new LinkedList<Course>();
    }

}
