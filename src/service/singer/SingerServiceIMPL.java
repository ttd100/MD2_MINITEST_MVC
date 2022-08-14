package service.singer;

import model.Singer;
import model.Song;
import service.IGeneric;
import service.song.ISongService;
import service.song.SongServiceIMPL;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingerServiceIMPL implements ISingerService {

    private  static  final List<Singer> singerList = new ArrayList<>();
    static {
        singerList.add(new Singer(1,"Sơn Tùng MTP",25));
        singerList.add(new Singer(2,"Quân AP",27));
        singerList.add(new Singer(3,"Binz",31));
        singerList.add(new Singer(4,"Binz",29));
        ISongService service = new SongServiceIMPL();
        service.findAll().get(0).getSingerList().add(singerList.get(0));
        singerList.get(0).getSongList().add(service.findAll().get(0));
        service.findAll().get(1).getSingerList().add(singerList.get(1));
        singerList.get(1).getSongList().add(service.findAll().get(1));
        service.findAll().get(2).getSingerList().add(singerList.get(2));
        singerList.get(2).getSongList().add(service.findAll().get(2));
        service.findAll().get(3).getSingerList().add(singerList.get(3));
        singerList.get(3).getSongList().add(service.findAll().get(3));
    }
    @Override
    public List<Singer> findAll() {
        return singerList;
    }
    @Override
    public void save(Singer e) {
        singerList.add(e);
    }

    @Override
    public void updateId(int id, String name, int age) {
        singerList.get(id-1).setName(name);
        singerList.get(id-1).setAge(age);
    }

    @Override
    public void deleteById(int id) {
        singerList.remove(id -1);
    }

    @Override
    public Singer findById(int id) {
        return singerList.get(id -1);
    }

    @Override
    public void sort() {
        Collections.sort(singerList);
    }





}
