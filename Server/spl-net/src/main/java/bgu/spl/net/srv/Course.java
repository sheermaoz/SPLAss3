package bgu.spl.net.srv;

public class Course {
    
    private short num;
    private String name;
    private short[] kdamCourses;
    private int numStudents;

    public Course(short _num, String _name, short[] _kdam, int _numStud)
    {
        num = _num;
        name = _name;
        kdamCourses = _kdam;
        numStudents = _numStud;
    }

    public String getName()
    {
        return name;
    }

    public short getNum()
    {
        return num;
    }

    public short[] getKdam()
    {
        return kdamCourses;
    }

    public int getNumStudents()
    {
        return numStudents;
    }
}
