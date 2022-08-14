package view;

import controller.SingerController;
import controller.SongController;
import model.Singer;
import model.Song;

import java.util.Scanner;

public class SongView {
    private final Scanner sc = new Scanner(System.in);
    private final SongController songController = new SongController();
    private final SingerController singerController = new SingerController();

    public void menu(){
        System.out.println("SONG MENU");
        System.out.println("1. Show List Song");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                this.showListSong();
                break;
            case 2:
                new Main();
                break;
            default:
                System.out.println("Invalid choice!!!");
        }
        new SongView().menu();
    }

    private void showListSong(){
        for (Song song : songController.getSongs()){
            System.out.println(song.getId()+". "+song.getName());
        }
        System.out.println("Enter id to show details");
        int id = Integer.parseInt(sc.nextLine());
        this.formViewDetailsSong(id);
    }
    private void formViewDetailsSong(int id){
        Song song = songController.findSongById(id);
        song.setListen(song.getListen()+1);
        showSongDetails(song);
        System.out.println("Enter 1 to like this song or else to exit");
        int choose = Integer.parseInt(sc.nextLine());
        if (choose == 1){
            song.setLike(song.getLike()+1);
        }
        showSongDetails(song);

    }
    private void showSongDetails(Song song){
        System.out.println(song.getName());
        System.out.println("\tPerformers:");
        System.out.print("\t\t");
        for (Singer singer:song.getSingerList()){
            System.out.print(singer.getName()+"");
        }
        System.out.println();
        System.out.println("\tPlayed:" +song.getListen());
        System.out.println("\tLikes:"+song.getLike());
    }
}
