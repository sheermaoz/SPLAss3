package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.Course;

public class MyCourses extends Message <Course> {

    public MyCourses(Course[] courses)
    {
        super((short)11);
        args = courses;
    }
    
}
