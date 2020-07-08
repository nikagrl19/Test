package com.course.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import com.course.Course;
import com.course.UniversityGraph;

public class CoursesPathService {

    public static void createCourseList(int totalNumberOfNodes, LinkedList<Course> courseList) {
	for (int i = 0; i < totalNumberOfNodes; ++i) {
	    Course userProvidedNode = new Course(i);
	    courseList.add(userProvidedNode);
	}
    }

    public static int enterCourse(BufferedReader bufferReader) throws IOException, NumberFormatException {
	System.out.println("Enter number of course in university");
	String totalNodes = bufferReader.readLine();
	int totalNumberOfNodes = 0;
	if (totalNodes != null) {
	    totalNumberOfNodes = Integer.parseInt(totalNodes);
	}
	return totalNumberOfNodes;
    }

    public static int enterEdge(BufferedReader bufferReader) throws IOException, NumberFormatException {
	String inputNumberOfEdges;
	inputNumberOfEdges = bufferReader.readLine();
	int noOfEdges = 0;
	if (inputNumberOfEdges != null) {

	    noOfEdges = Integer.parseInt(inputNumberOfEdges);

	}
	return noOfEdges;
    }

    public static Course getCourse(LinkedList<Course> inputList, int value) {
	for (int i = 0; i < inputList.size(); i++) {
	    Course course = inputList.get(i);
	    if (course.getCourseValue() == value) {
		return course;
	    }
	}
	return null;
    }

    public static void main(String args[]) throws Exception {

	BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

	int totalNumberOfNodes = enterCourse(bufferReader);

	LinkedList<Course> courseList = new LinkedList<Course>();
	UniversityGraph userProvidedgraph = new UniversityGraph();

	createCourseList(totalNumberOfNodes, courseList);

	System.out.println("Enter number of edges");

	int noOfEdges = enterEdge(bufferReader);

	for (int i = 0; i < noOfEdges; ++i) {

	    System.out.println("Enter parent course");

	    int parentCourseValue = 0;
	    int childCourseValue = 0;

	    parentCourseValue = readCourses(bufferReader, parentCourseValue);

	    Course parentCourse = getCourse(courseList, parentCourseValue);

	    System.out.println("Enter the connected immediate child course  ");
	    childCourseValue = readCourses(bufferReader, childCourseValue);
	    Course childNode = getCourse(courseList, childCourseValue);

	    if (childNode != null) {
		parentCourse.getCourseChildList().add(childNode);
	    }
	}

	for (int i = 0; i < courseList.size(); ++i) {
	    Course currentNode = courseList.get(i);
	    for (Course n : currentNode.getCourseChildList()) {
		int key = n.getCourseKey() + 1;
		n.setCourseKey(key);
	    }
	}

	for (int i = 0; i < courseList.size(); ++i) {
	    Course inputNode = courseList.get(i);
	    int currentCourseKey = inputNode.getCourseKey();
	    if (currentCourseKey == 0) {
		userProvidedgraph.getRootList().add(new UniversityService(inputNode));
	    }
	}

	for (UniversityService university : userProvidedgraph.getRootList()) {
	    university.pathPrint(university.getRoot());
	}

    }

    public static int readCourses(BufferedReader bufferReader, int parentCourseValue)
	    throws IOException, NumberFormatException {
	String courseValue = bufferReader.readLine();
	if (courseValue != null) {
	    parentCourseValue = Integer.parseInt(courseValue);
	}
	return parentCourseValue;
    }
}
