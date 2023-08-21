public class Song {

    public boolean gettitle;
    private String Title;
    private double duration;

    public Song(){
    }

    public Song(String song, double duration) {
        this.Title = song;
        this.duration = duration;
    }

    public String gettitle() {
        return Title;
    }

    public void setTitle(String song) {
        this.Title = song;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "Song{" +
                "song='" + Title + '\'' +
                ", duration=" + duration +
                '}';
    }
}

