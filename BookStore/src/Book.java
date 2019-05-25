

class Book {

    private boolean used;
    private int book_id;

    Book(int book_id) {
        this.used = false;
        this.book_id = book_id;
    }

    public synchronized boolean isUsed() {

        return used;
    }

    public void setUsed(boolean used) {

        this.used = used;
    }

    public int getBook_id() {

        return book_id;
    }

    public void setBook_id(int book_id) {

        this.book_id = book_id;
    }
}