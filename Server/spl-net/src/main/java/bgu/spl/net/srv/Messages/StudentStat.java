package bgu.spl.net.srv.Messages;

import bgu.spl.net.srv.Course;

public class StudentStat extends Message<Course> {

    public StudentStat(Course[] courses)
    {
        super((short)8);
        args = courses;
    }
    
}
