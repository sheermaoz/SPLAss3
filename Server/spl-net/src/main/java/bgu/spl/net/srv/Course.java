package bgu.spl.net.srv;

public class Course {
    
    private short num;
    private String name;
    private Short[] kdamCourses;
    private int maxStuds;
    private int numStuds;
    private int index;

    public Course(short _num, String _name, Short[] _kdam, int _maxStuds, int _index)
    {
        num = _num;
        name = _name;
        kdamCourses = _kdam;
        maxStuds = _maxStuds;
        index = _index;
        numStuds = 0;
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

    public int getNumStudents()
    {
        return maxStuds;
    }

    public int getIndex()
    {
        return index;
    }

    public boolean register()
    {
        if (numStuds < maxStuds)
        {
            numStuds++;
            return true;
        }
        return false;
    }

    public void unregister()
    {
        numStuds--;
    }
}
