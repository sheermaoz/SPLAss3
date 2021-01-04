package bgu.spl.net;

import bgu.spl.net.srv.Course;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;
import bgu.spl.net.srv.CourseComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Passive object representing the Database where all courses and users are stored.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add private fields and methods to this class as you see fit.
 */
public class Database {

    private Map<Short, Course> courses;
    private Map<String, User> users;
    //to prevent user from creating new Database
    private Database() {
        courses = new ConcurrentHashMap<>();
        users = new ConcurrentHashMap<>();
        initialize("spl-net/src/main/java/bgu/spl/net/Courses.txt");
    }

    private static class DatabaseHolder
    {
        private static Database singleton = new Database();
    }

    /**
     * Retrieves the single instance of this class.
     */
    public static Database getInstance() {
        return DatabaseHolder.singleton;
    }
    
    /**
     * loades the courses from the file path specified 
     * into the Database, returns true if successful.
     */
    boolean initialize(String coursesFilePath) {
        try
        {
            File myFile = new File(coursesFilePath);
            Scanner reader = new Scanner(myFile);
            int index = 0;
            while(reader.hasNextLine())
            {
                String data = reader.nextLine();
                String[] splitData = data.split("\\|");
                short courseNum = Short.valueOf(splitData[0]);
                String courseName = splitData[1];
                Short[] kdam = parseKdam(splitData[2]);
                int studNum = Integer.valueOf(splitData[3]);
                courses.put(courseNum, new Course(courseNum, courseName, kdam, studNum, index));
                index++;
            }
            reader.close();
            return true;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    private Short[] parseKdam(String kdamCourse)
    {
        if (kdamCourse.equals("[]"))
        {
            return new Short [0];
        }
        String[] splitKdam = kdamCourse.substring(1, kdamCourse.length()-1).split(",");
        Short[] courses = new Short[splitKdam.length];
        for (int i = 0; i < courses.length; i++)
        {
            
            courses[i] = Short.valueOf(splitKdam[i]);
            
        }
        return courses;
    }

    public void print()
    {
        for (Course course : courses.values())
        {
            System.out.println(course.getNum() + "|" + course.getName() + "|" + 
                Arrays.toString(course.getKdam()) + "|" + course.getNumStudents());
        }
    }

    public Boolean register(String name, Type type, String password)
    {
        if (users.get(name) != null)
        {
            return null;
        }
        users.put(name, new User(name, type, password));
        return true;
    }

    public User login (String name, String password)
    {
        User user = users.get(name);
        if (user == null)
        {
            return null;
        }
        if (user.getPassword().equals(password))
        {
            return user;
        }
        return null;
    }

    public Boolean courseRegister(String name, short course)
    {
        for (Short num : courses.get(course).getKdam())
        {
            if (!users.get(name).getCourses().contains(num))
            {
                return null;
            }
        }
        if (courses.get(course).register(name))
        {
            users.get(name).register(course);
            return true;
        }
        return null;
    }

    public Short[] checkKdam(Short course)
    {
        Short[] kdam = courses.get(course).getKdam();
        
        return sort(kdam);
    }

    public boolean isRegistered(String name, Short course)
    {
        return users.get(name).contains(course);
    }

    public Boolean unregister(String name, Short course)
    {
        if (!users.get(name).contains(course))
        {
            return null;
        }
        users.get(name).unregister(course);
        courses.get(course).unregister(name);
        return true;
    }

    private Short[] sort(Short[] toSort)
    {
        Course[] temp = new Course[toSort.length];
        Short[] sorted = new Short[toSort.length];
        for (int i = 0 ; i < toSort.length; i++)
        {
            temp[i] = courses.get(toSort[i]);
        }
        Comparator<Course> comp = new CourseComparator();
        Arrays.sort(temp, comp);
        for (int i = 0 ; i < toSort.length; i++)
        {
            sorted[i] = temp[i].getNum();
        }
        return sorted;

    }

    public Short[] myCourses(String name)
    {
        Short[] myCourses =  users.get(name).getCourses().toArray(new Short[0]);
        return sort(myCourses);
    }

    public String courseStatus(Short num)
    {
        Course course = courses.get(num);
        if (course == null)
        {
            return null;
        }
        String [] usersReg = course.getStudents().toArray(new String[0]);
        Arrays.sort(usersReg);
        String status = "Course: (" + num + ") " + course.getName() + "\nSeats Available: " +
            course.getNumStudents() + "/" + course.getMaxStudents() + "\nStudents Registered: "
            + Arrays.toString(usersReg);
        return status;
    }

    public Course getCourse(Short num)
    {
        return courses.get(num);
    }

}
