package bgu.spl.net.srv;

import java.util.LinkedList;
import java.util.List;

public class Course {
    
    private short num;
    private String name;
    private Short[] kdamCourses;
    private int maxStuds;
    private int numStuds;
    private int index;
    private List<String> students;

    public Course(short _num, String _name, Short[] _kdam, int _maxStuds, int _index)
    {
        num = _num;
        name = _name;
        kdamCourses = _kdam;
        maxStuds = _maxStuds;
        index = _index;
        numStuds = 0;
        students = new LinkedList<>();
    }

    public String getName()
    {
        return name;
    }

    public short getNum()
    {
        return num;
    }

    public Short[] getKdam()
    {
        return kdamCourses;
    }

    public int getMaxStudents()
    {
        return maxStuds;
    }

    public int getNumStudents()
    {
        return numStuds;
    }

    public int getIndex()
    {
        return index;
    }

    public boolean register(String name)
    {
        if (numStuds < maxStuds)
        {
            numStuds++;
            students.add(name);
            return true;
        }
        return false;
    }

    public void unregister(String name)
    {
        int ind = students.indexOf(name);
        students.remove(ind);
        numStuds--;
    }

    public List<String> getStudents()
    {
        return students;
    }
}
