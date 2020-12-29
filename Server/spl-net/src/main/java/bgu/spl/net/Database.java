package bgu.spl.net;

import bgu.spl.net.srv.Course;
import bgu.spl.net.srv.Type;
import bgu.spl.net.srv.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Passive object representing the Database where all courses and users are stored.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add private fields and methods to this class as you see fit.
 */
public class Database {

    private List<Course> courses;
    private List<User> users;
    //to prevent user from creating new Database
    private Database() {
        courses = new LinkedList<>();
        users = new LinkedList<>();
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
            while(reader.hasNextLine())
            {
                String data = reader.nextLine();
                String[] splitData = data.split("\\|");
                short courseNum = Short.valueOf(splitData[0]);
                String courseName = splitData[1];
                short[] kdam = parseKdam(splitData[2]);
                int studNum = Integer.valueOf(splitData[3]);
                courses.add(new Course(courseNum, courseName, kdam, studNum));
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

    private short[] parseKdam(String kdamCourse)
    {
        if (kdamCourse.equals("[]"))
        {
            return new short [0];
        }
        String[] splitKdam = kdamCourse.substring(1, kdamCourse.length()-1).split(",");
        short[] courses = new short[splitKdam.length];
        for (int i = 0; i < courses.length; i++)
        {
            
            courses[i] = Short.valueOf(splitKdam[i]);
            
        }
        return courses;
    }

    public void print()
    {
        for (Course course : courses)
        {
            System.out.println(course.getNum() + "|" + course.getName() + "|" + 
                Arrays.toString(course.getKdam()) + "|" + course.getNumStudents());
        }
    }

    public boolean register(String name, Type type, String password)
    {
        if (getUser(name) != null)
        {
            return false;
        }
        users.add(new User(name, type, password));
        return true;
    }

    public boolean login (String name, String password)
    {
        User user = getUser(name);
        if (user == null)
        {
            return false;
        }
        if (user.getPassword().equals(password))
        {
            return true;
        }
        return false;
    }

    
    private User getUser(String name)
    {
        for (User user : users)
        {
            if (user.getName().equals(name))
            {
                return user;
            }
        }
        return null;
    }

    private Course getCourse(String name)
    {
        for (Course course : courses)
        {
            if (course.getName().equals(name))
            {
                return course;
            }
        }
        return null;
    }

    private Course getCourse(short num)
    {
        for (Course course : courses)
        {
            if (course.getNum() == num)
            {
                return course;
            }
        }
        return null;
    }


}
