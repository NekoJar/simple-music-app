import java.util.Arrays;

public class DriverAlbum {
    public static void main(String[] args) {
        Song song1 = new Song();
        song1.setTitle("Hello world");
        song1.setArtist(new String[]{"Alan Walker", "Torine"});
        song1.setDuration(171);

        Song song2 = new Song();
        song2.setTitle("Film Favorit");
        song2.setArtist(new String[]{"Sheila On 7"});
        song2.setDuration(226);

        Album album = new Album();
        album.setTitle("Kayaknya Hits");
        album.setYear(2023);

        album.addSong(song1);
        album.addSong(song2);

        album.displayInfo();
    }
}

class Song {
    private String title;
    private String[] artist;
    private int duration;

    public Song(){}

    public Song(String title, String[] artist, int duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setArtist(String[] artist){
        this.artist = artist;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    }

    public String[] getArtist(){
        return artist;
    }


    public String getDurationAsString(){
        int minutes = duration/60;
        int seconds = duration%60;

        String minuteStr = String.format("%02d", minutes);
        String secondStr = String.format("%02d", seconds);

        return minuteStr + ":" + secondStr;
    }
}

class Album {
    private String title;
    private int year;
    private Song[] songs;

    public Album(){}

    public Album(  String title, int year, Song[] songs){
        this.title = title;
        this.year = year;
        this.songs = songs;
    }

     public void setTitle(String title){
        this.title = title;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String getTitle(){
        return title;
    }

    public int getYear(){
        return year;
    }

    public void addSong(Song song){
        if(songs == null){
            songs = new Song[]{song};
        } else {
            Song[] newSongs = Arrays.copyOf(songs, songs.length + 1);
            newSongs[songs.length] = song;
            songs = newSongs;
        }
    }

    public void displayInfo(){
        System.out.println("");
        System.out.println("Album Info");
        System.out.println("----------------------");
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("");
        System.out.println("Song list");
        System.out.println("----------------------");
        
        if(songs != null){
            for(int i = 0; i < songs.length; i++){
                Song song = songs[i];
                System.out.println((i+1) + " Title : " + song.getTitle());
                System.out.println("  Artist : " + String.join(", ", song.getArtist()));
                System.out.println("  Duration : " + song.getDurationAsString());
                System.out.println("");
            }
        }else{
            System.out.println("No songs in this album");
        }
    }
}
