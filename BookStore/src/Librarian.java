class Librarian implements Runnable {

    private int librarian_id;

    public Librarian(int librarian_id) {
        System.out.println("Librarian " + librarian_id + " started.");
        this.librarian_id = librarian_id;
    }

    @Override
    public void run() {

        while (true) {
            if (LibraryManagement.completedStudents == 28) {
                System.out.println("Librarian " + librarian_id + " finished he gave the permission to be graduated.");
                return;
            }
            if (LibraryManagement.Queue.size() == 0) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            Student student = null;
            try {
                student = LibraryManagement.Queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (student == null) {
                System.out.println("null student");
                continue;
            }

            int bookId = student.wantBook();
            if (bookId == -1) {
                continue;
            }

            Book book = LibraryManagement.bookCloset.get(bookId);
            if (book.isUsed()) {
                try {
                    LibraryManagement.Queue.put(student);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            book.setUsed(true);
            System.out.println("Librarian " + getLibrarian_id() + " acquired book id " + bookId);

            student.bookList.add(book);
            student.setBook(book);

            System.out.println("Student " + student.getStudent_id() + " accessed to book " + book.getBook_id());


            new Thread(student).start();
        }
    }

    public int getLibrarian_id() {

        return librarian_id;
    }

    public void setLibrarian_id(int librarian_id) {

        this.librarian_id = librarian_id;
    }

}

