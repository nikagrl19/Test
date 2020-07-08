package com.course.service;

import com.course.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UniversityService {

    Course root;
    private static final int SIZE = 2345;

    public boolean isLeaf(Course node) {
	if (node.getCourseChildList().size() == 0) {
	    return true;
	}
	return false;
    }

    public void pathPrint(Course node) {
	int path[] = new int[SIZE];
	this.util(node, path, 0);
    }

    public void printRootToLeafPath(int path[], int length) {
	for (int i = 0; i < length; i++) {
	    System.out.print(path[i]);
	    if (i != length - 1) {
		System.out.print("->");
	    }
	}
	System.out.println("");
    }

    public void util(Course node, int path[], int length) {

	if (node == null) {
	    return;
	}

	path[length] = node.getCourseValue();
	length++;

	if (this.isLeaf(node)) {
	    this.printRootToLeafPath(path, length);
	} else {
	    int size = node.getCourseChildList().size();
	    for (int i = 0; i < size; ++i) {
		this.util(node.getCourseChildList().get(i), path, length);
	    }
	}

    }
}
