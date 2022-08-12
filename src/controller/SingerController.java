package controller;

import model.Singer;
import service.singer.ISingerService;
import service.singer.SingerServiceIMPL;

import java.util.List;

public class SingerController {
    private final SingerServiceIMPL singerService = new SingerServiceIMPL();
    public List<Singer> getSingers(){
        return singerService.findAll();
    }
    public void addSinger(Singer singer){
        singerService.save(singer);
    }
    public void editSinger(int id, String name ,int age){
        singerService.updateId(id,name,age);
    }
    public void deleteSinger(int id){
        singerService.deleteById(id);

    }
    public Singer findSingerById(int id){
        return singerService.findById(id);
    }
    public void sortSingerList(){
        singerService.sort();
    }
}
