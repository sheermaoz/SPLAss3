package bgu.spl.net.srv;

import java.util.Comparator;

public class CourseComparator implements Comparator<Course>{

    @Override
    public int compare(Course c1, Course c2) {
        if (c1.getIndex() > c2.getIndex())
        {
            return 1;
        }
        else if(c1.getIndex() < c2.getIndex())
        {
            return -1;
        }
        return 0;
    }

    
    
}
