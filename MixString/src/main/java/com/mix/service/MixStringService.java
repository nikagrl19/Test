package com.mix.service;

import org.springframework.stereotype.Service;

@Service
public class MixStringService {

    public String createString(String s1, String s2, String s3) {

	StringBuilder result = new StringBuilder();

	char[] s1Char = s1.toCharArray();
	char[] s2Char = s2.toCharArray();
	char[] s3Char = s3.toCharArray();

	int limit = s1.length();
	int counter = 0;

	//
	result = this.pairStar(result, s1Char, s2Char, s3Char, counter, limit);

	return result.toString();

    }

    public StringBuilder pairStar(StringBuilder result, char[] s1Char, char[] s2Char, char[] s3Char, int counter,
	    int limit) {

	if (counter == limit) {
	    return result;
	}

	if (limit - counter < 2) {
	    result.append(s1Char[counter]).append(s2Char[counter]).append(s3Char[counter]);
	} else {
	    result.append(s1Char[counter]).append(s1Char[counter + 1]).append(s2Char[counter])
		    .append(s2Char[counter + 1]).append(s3Char[counter]).append(s3Char[counter + 1]);

	}
	counter = counter + 2;

	return this.pairStar(result, s1Char, s2Char, s3Char, counter, limit);

    }
}