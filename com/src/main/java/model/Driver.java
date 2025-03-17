package model;
// trying to see if i can commit this 

public class Driver {

    public static void main(String[]args ){

        User user = new User("username", "firstName", "lastName", "password", "email");
        Song song = new Song("Song Title", "Genre", "Difficulty");
        Lesson lesson = new Lesson;

        System.out.println("Welcome to Scale A Saurus!");

      
        System.out.println("Song details:");
        System.out.println(song.getSong());


        System.out.println("Starting lesson: " + lesson.getLesson());
        lesson.startLesson();

     
        lesson.completeLesson();
        System.out.println("Lesson Completed. " + lesson.getFeedback());


        user.recordProgress(lesson, 0); 

       /*
        * add methods for like actions within the program 
        */
    }
}
    }

}