package bgu.spl.net;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        //for testing database
        Database database = Database.getInstance();
        database.initialize("spl-net/src/main/java/bgu/spl/net/Courses.txt");
        database.print();
        System.out.println(database.getClass().equals(Database.class));
        short a = 101;
        System.out.println(Arrays.toString(database.checkKdam(Short.valueOf(a))));
        
    }
}
