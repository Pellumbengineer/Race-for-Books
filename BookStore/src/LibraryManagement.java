import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class LibraryManagement {


    public static final BlockingQueue<Student> Queue = new ArrayBlockingQueue<>(28);
    public static List<Student> studentList;
    public static List<Thread> librarianThreadList;
    public static List<Book> bookCloset;
    public static int completedStudents;

    public static void main(String args[]) {
        completedStudents = 0;
        bookCloset = new ArrayList<>();
        studentList = new ArrayList<>();
        librarianThreadList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            bookCloset.add(new Book(i));
        }

        for (int i = 0; i < 28; i++) {
            studentList.add(new Student(i));
        }

        Collections.shuffle(studentList);

        for (int i = 0; i < 28; i++) {
            try {
                Queue.put(studentList.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Student i : Queue) {
            System.out.println("Student " + i.getStudent_id() + " is in queue.");
        }

        for (int i = 0; i < 3; i++) {
            Librarian librarian = new Librarian(i);
            librarianThreadList.add(new Thread(librarian));
            librarianThreadList.get(i).start();
        }
    }
}


