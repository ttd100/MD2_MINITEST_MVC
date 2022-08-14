package service.song;

import model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongServiceIMPL implements ISongService {
    private static final List<Song> songs = new ArrayList<>();
    static {
        songs.add(new Song(1,"Nắng ấm xa dần"));
        songs.add(new Song(2,"Đã từng"));
        songs.add(new Song(3,"Deep sea"));
        songs.add(new Song(4,"Oke"));
        for (Song song : songs){
            song.setListen((int)(Math.random()*100+1));
            song.setLike((int) (Math.random()*song.getListen()));
        }
    }
    @Override
    public List<Song> findAll() {
        return songs;
    }


    @Override
    public void save(Song song) {
        if (this.findById(song.getId()) == null) {
            songs.add(song);
        } else {
            this.findById(song.getId()).setName(song.getName());
        }
    }

    @Override
    public void updateId(int id, String name, int age) {

    }

    @Override
    public void deleteById(int id) {
        songs.remove(this.findById(id));
    }

    @Override
    public Song findById(int id) {
        return songs.stream().filter(s -> s.getId()== id).findAny().orElse(null);
    }

    @Override
    public void sort() {

    }
}
