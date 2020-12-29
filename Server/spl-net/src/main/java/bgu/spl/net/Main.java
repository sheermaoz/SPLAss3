package bgu.spl.net;


public class Main {
    public static void main(String[] args) {
        //for testing database
        Database database = Database.getInstance();
        database.initialize("spl-net/src/main/java/bgu/spl/net/Courses.txt");
        database.print();
    }
}
