package view;

import controller.SingerController;
import model.Singer;
import model.Song;

import java.util.Comparator;
import java.util.Scanner;

public class SingerView {
    private final Scanner sc = new Scanner(System.in);
    
    private final SingerController singerController = new SingerController();

//    Scanner sc = new Scanner(System.in);
    public void menu(){
        System.out.println("MENU");
        System.out.println("1. Show List Singer");
        System.out.println("2. Create Singer");
        System.out.println("3. Update Singer");
        System.out.println("4. Detail Singer");
        System.out.println("5. Delete Singer");
        System.out.println("6. Sort Singer List");
        System.out.println("7. Exit");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                this.showListSinger();
                break;
            case 2:
                this.createSinger();
                break;
            case 3:
                this.updateSinger();
                break;
            case 4:
                this.showDetailSinger();
                break;
            case 5:
                this.deleteSinger();
                break;
            case 6:
                this.sortSingerList();
                break;
            case 7:
                new Main();
                break;
            default:
                System.out.println("Invalid choice");
        }
        new SingerView().menu();
    }


    public void showListSinger() {
        for (Singer singer : singerController.getSingers()) {
            System.out.println(singer.getId() + ". " + singer.getName() + " " + singer.getAge());
        }
    }

    public void createSinger() {
        System.out.println("Enter singer name:");
        String name = sc.nextLine();
        System.out.println("Enter singer age:");
        int age = Integer.parseInt(sc.nextLine());
        singerController.addSinger(new Singer(singerController.getSingers().size() + 1, name, age));
    }

    public void deleteSinger(){
        System.out.println("Enter singer id to delete: ");
        int idDelete = Integer.parseInt(sc.nextLine());
        if (!isValid(idDelete)){
            System.out.println("Id out of range");
            return;
        }
        System.out.println("Sure to delete? Y/N");
        String check = sc.nextLine();
        if (check.equalsIgnoreCase("y")){
            singerController.deleteSinger(idDelete);
        } else if (check.equalsIgnoreCase("n")) {
            System.out.println("Not delete yet");
        }else {
            System.out.println("Invalid choice");
        }
    }
    public void updateSinger(){
        System.out.println("EDIT SINGER");
        System.out.println("Enter singer id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter singer name: ");
        String name = sc.nextLine();
        System.out.println("Enter singer age");
        int age = Integer.parseInt(sc.nextLine());
        singerController.editSinger(id,name,age);

        if (!isValid(id)){
            System.out.println("Id out of range");
            return;
        }
    }
    public void showDetailSinger(){
        System.out.println("Enter singer id to show:");
        int id = Integer.parseInt(sc.nextLine());
        Singer singer = singerController.findSingerById(id);
        System.out.println("Id: " + singer.getId()+", name" +singer.getName()+", age:"+singer.getAge());
    }
    public void sortSingerList(){
        singerController.sortSingerList();
        System.out.println("Singer list sorted");
    }
    private boolean isValid(int id){
        int size = singerController.getSingers().size();
        return id >= 0 && id < size;
    }
}
