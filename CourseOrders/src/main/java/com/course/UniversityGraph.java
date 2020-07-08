package com.course;

import java.util.LinkedList;

import com.course.service.UniversityService;

public class UniversityGraph {

    private LinkedList<UniversityService> rootList;

    public UniversityGraph() {
	this.rootList = new LinkedList<UniversityService>();
    }

    public UniversityGraph(LinkedList<UniversityService> rootList) {
	this.rootList = rootList;
    }

    public LinkedList<UniversityService> getRootList() {
	return this.rootList;
    }

}
