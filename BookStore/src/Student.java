import java.util.ArrayList;
import java.util.Random;

class Student implements Runnable {

    private int student_id;
    private Book book;
    public ArrayList<Book> bookList;

    public Student(int student_id) {
        this.student_id = student_id;
        bookList = new ArrayList<>();
    }

    @Override
    public void run() {

        System.out.println("Student " + student_id + " reading book " + book.getBook_id());
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Student " + student_id + " is returning the book " + this.book.getBook_id());
        this.book.setUsed(false);
        this.setBook(null);

        try {
            LibraryManagement.Queue.put(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int wantBook() {
        if (bookList.size() == 6) {
            LibraryManagement.completedStudents++;
            return -1;
        }

        int book_id;
        Random rand = new Random(System.currentTimeMillis());
        while (true) {

            book_id = rand.nextInt(6);
            boolean flag = false;
            for (Book i : bookList) {
                if (i.getBook_id() == book_id) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return book_id;
    }

    public Book getBook() {

        return book;
    }

    public void setBook(Book book) {

        this.book = book;
    }

    public int getStudent_id() {

        return student_id;
    }

    public void setStudent_id(int student_id) {

        this.student_id = student_id;
    }

}