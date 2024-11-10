import java.util.ArrayList;
import java.util.LinkedList;

class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if (index >= 0 && index < songs.size()) {
            playList.add(songs.get(index));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song != null) {
            playList.add(song);
            return true;
        }
        return false;
    }
}

class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ": " + duration;
    }
}

public class App {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("Rock", "AC/DC");
        album.addSong("Highway to Hell", 4.6);
        album.addSong("Back in Black", 4.22);
        album.addSong("Song3", 4.3);
        albums.add(album);

        album = new Album("Symphonic Metal", "April Rain");
        album.addSong("Will we meet again?", 5.44);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("Song3", playList);
        albums.get(0).addToPlayList("123124", playList);
        albums.get(0).addToPlayList(1, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(0).addToPlayList(3, playList);
        albums.get(0).addToPlayList(2, playList);

        System.out.println("Playlist:");
        for (Song song : playList) {
            System.out.println(song);
        }
    }
}
