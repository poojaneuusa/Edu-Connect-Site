package com.educonnect.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonnect.main.entities.Course;
import com.educonnect.main.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourseDetails() {
		return courseRepository.findAll();
	}
}
