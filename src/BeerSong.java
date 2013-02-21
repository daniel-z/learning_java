
public class BeerSong {
    public static void main (String[] args) {
        int beers = 100;
        while ( beers >= 0 ) {
            if( beers == 0 ){
                System.out.println("No more bottles of beer");
                break;
            }
            System.out.println(beers + " bottles of beer on the wall");
            System.out.println("Take one down");
            System.out.println("Pass it around");
            beers--;
        }
    }
}
