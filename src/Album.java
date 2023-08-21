import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Album {
    private String artist;
    private String album;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String album) {
        this.artist = artist;
        this.album = album;
        this.songs=new ArrayList<Song>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // Functionalites in Album
    public boolean Findsong(String song_name){
        // we have song list stored in arraylist for each album
        // when ever user searches for song in a particular album, have to go through thew whole list in album, arn
        // rerturn trure if song name matches with the song name present in the list
        for(Song song:songs){
            if(song.gettitle().equals(song_name)){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String songName, double duration){
        // first have to check the song name is in the album or not, if it is not present , then add song to album
        if(!Findsong(songName)){
            Song addSong=new Song(songName,duration);
            this.songs.add(addSong);
            return "Song Added Successfully";
        }
          return "Song is already present in this Album, add another song";
    }

    public String addSongToPlaylist(String song_name,LinkedList<Song> playlist){
        // check in this particular album if , this song exist or not
//        if exists add to playlist,
        for(Song song:this.songs){
            if(song.gettitle().equals(song_name)){
                playlist.add(song);
                return "Song is being added to your playlist";
            }
        }
        return "Song not found in this album";
    }

    /**
     *  Implemented Polymorphism here
     * @param song_no
     * @param playlist
     * @return
     */


    public String addSongToPlayllist(int song_no,LinkedList<Song>playlist){
        int index=song_no-1;
        if(index>=0&&index<songs.size()) {
            playlist.add(songs.get(index));
            return "Song Added Successfully";
        }
        return" song number does not exist in this album";
    }
}
