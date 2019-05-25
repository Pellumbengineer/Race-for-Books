# Race-for-Books
## Introduction

A group of students need to use the same books to perform their term project. There are 28 students in the class (they have consecutive school numbers from 1 to 28) and all need the same 6 books from the library. The students arrive at the library in random order. There is a Qmatic in the library to talk to one of the 3 librarians. The librarians always call the next number from the existing queue.
When a student shows in front of one of the librarians, he/she asks the book he/she needs. The book needed is generated randomly. The librarian should check if the book was borrowed by any other student. If not, that book is assigned to that student for a random time period in milliseconds. If the book is borrowed by someone else the student should leave and go to the Qmatic once more.
Each student needs to read all of the 6 books to complete his/her term project.

## Evaluation

Below I have discribed the project.

![Screenshot from 2019-05-25 14-17-33](https://user-images.githubusercontent.com/26312757/58368634-28064700-7ef8-11e9-9d43-9e8449332a9c.png)

So to make the three Librarians to work at the same time I have used Threads and also while the student is reading the book we dont want the librarian to wait untill the student returns the book.



![Screenshot from 2019-05-25 14-17-49](https://user-images.githubusercontent.com/26312757/58368636-2b99ce00-7ef8-11e9-8d3b-d56f1c826d1c.png)

I used blocking queue to synchronize threads. Blocking Queue supports flow control by introducing blocking if either Blocking Queue is full or empty. A thread trying to put an element in a full queue is blocked until some other thread takes an elemnt from the  queue, either by taking one or more element or clearing the queue completely. Similarly it blocks a thread trying to delete from an empty queue until some other treads puts an item.
