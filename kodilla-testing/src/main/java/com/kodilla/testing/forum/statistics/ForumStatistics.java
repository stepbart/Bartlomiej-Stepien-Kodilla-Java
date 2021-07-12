package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    int numberOfUsers;
    int numberOfPosts;
    int numberOfComments;
    double averageNumberOfUserPosts;
    double averageNumberOfUserComments;
    double averageNumberOfPostComments;

    public void calculateAdvStatistics(Statistics statistics){
        this.numberOfUsers = statistics.usersNames().size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();

        if (statistics.usersNames().size() > 0) {
            this.averageNumberOfUserPosts = statistics.postsCount() / statistics.usersNames().size();
            this.averageNumberOfUserComments = statistics.commentsCount() / statistics.usersNames().size();
        }
        else {
            this.averageNumberOfUserPosts = 0;
            this.averageNumberOfUserComments = 0;
        }
        if (statistics.postsCount() > 0) {
            this.averageNumberOfPostComments = statistics.commentsCount() / statistics.postsCount();
        }
        else {
            this.averageNumberOfPostComments = 0;
        }
        showStatistics();
    }

    public void showStatistics(){
        System.out.println("Statystyki: ");
        System.out.println("Liczba użytkowników: "+numberOfUsers);
        System.out.println("Liczba postów: "+numberOfPosts);
        System.out.println("Liczba komentarzy: "+numberOfComments);
        System.out.println("Średnia liczba postów na użytkownika: "+averageNumberOfUserPosts);
        System.out.println("Średnia liczba komentarzy na użytkownika: "+averageNumberOfUserComments);
        System.out.println("Średnia liczba komentarzy na post: "+averageNumberOfPostComments+'\n');
    }
}
