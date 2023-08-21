import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     // create an album and add songs to album
        Album Balasubrahmanyam=new Album("Balu","BaluHits");
        Balasubrahmanyam.addSongToAlbum("VayyariBama",3.5);
        Balasubrahmanyam.addSongToAlbum("NinnuChusina",3.3);
        Balasubrahmanyam.addSongToAlbum("ohoDevuda",7.5);
        Balasubrahmanyam.addSongToAlbum("udyogamoodi",5.3);
//        create another album and add songs
        Album dsp=new Album("DeviSri","DeviHits");
        dsp.addSongToAlbum("lahari",4.4);
        dsp.addSongToAlbum("muthyamantha",4.3);
        dsp.addSongToAlbum("pakadopakado",2.4);
        dsp.addSongToAlbum("soonyam",4.8);

        // Now create a playlist, and add songs to playlist using the function present in album class;
        LinkedList<Song>kalyans_list=new LinkedList<>();
        // now add song to playlist by entering song name you want to ;
        // call the function of prefered album and search by song name and add the song object;
        System.out.println(Balasubrahmanyam.addSongToPlaylist("VayyariBama",kalyans_list));
        System.out.println(Balasubrahmanyam.addSongToPlaylist("pillanichushte",kalyans_list));
        System.out.println(Balasubrahmanyam.addSongToPlayllist(3,kalyans_list));
        System.out.println(dsp.addSongToPlaylist("lahari",kalyans_list));
        System.out.println(dsp.addSongToPlayllist(10,kalyans_list));
        System.out.println(dsp.addSongToPlaylist("soonyam",kalyans_list));

        // after adding all the songs to playlist,now have to implement the play function tp play the songs in the list
        play(kalyans_list);






    }

    private static void play(LinkedList<Song> kalyans_list) {
          // if the playlist is empty , then no need to play the songs,
        if(kalyans_list.size()==0){
            System.out.println("Your playlist is empty");
           return;
        }
         // we have set the pointer for the playlist
        ListIterator<Song> itr=kalyans_list.listIterator();
        System.out.println("You are currently on song:"+itr.next());
        printMenu();
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        // while coming from next to previous song---> playing curren song only (n--->p)
        // while coming from previous to next song----> playing current song only(p--->n)
        // To fix this we have to keep track of previous operation
        // if operation was next,---wasNext==true;
        // if operation was pervious== wasNext==false;
        boolean wasNext=true;
        while(!quit){
            System.out.println("Please Enter Your Choice");
            int choice=sc.nextInt();

            switch (choice){
                case 1:{
                    printMenu();
                    break;
                }
                case 2:{
                    // if previoos operation was previous, then have to move pointer twice to play the next song
                    if(!wasNext){
                        itr.next();
                        wasNext=true;
                    }
                    if(!itr.hasNext()){
                        System.out.println("You are at the end of the playlist");
                    }
                    else{
                        System.out.println("Currently playing :"+itr.next());
                        wasNext=true;
                    }
                    break;
                }
                case 3:{
                    // if previous operaton was next, then have to move pointer twice to go to previous song
                    if(wasNext){
                        itr.previous();
                        wasNext=false;
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("Yor are at the start of the playlist");
                    }
                    else{
                        System.out.println("Currently playing:"+itr.previous());
                        wasNext=false;
                    }
                    break;
                }
                case 4:{
                    // if my previous operaton was next, do previous operation to play the current song, and change wasNext  to previous
                    // if my previous operaton was prev, do next operation to play the current song, and change wasNext to next;
                    if(wasNext==true){
                        System.out.println("Currently playing song"+itr.previous());
                        wasNext=false;
                    }
                    else{
                        System.out.println("Currently playing song:"+itr.next());
                        wasNext=true;
                    }
                    break;
                }
                case 5:{
                    break;
                }
                case 6:{
                    printSongs(kalyans_list);
                    break;
                }
                case 7:{
                    quit=true;
                    break;
                }
                default:{
                    System.out.println("Wrong Choice Entered! Please Enter the correct choice");
                }
            }
        }


    }

    private static void printSongs(LinkedList<Song>kalyans_list) {
       for(Song song:kalyans_list){
           System.out.println(song);
       }
    }

    private static void printMenu() {
        System.out.println("1:show the menu again");
        System.out.println("2: Play next Song");
        System.out.println("3: Play provious Song:");
        System.out.println("4: Play Current Song again");
        System.out.println("5: Delete current song from playlist");
        System.out.println("6: Print all the songs in playlist");
        System.out.println("7: Quit applicatioin");
    }
}
