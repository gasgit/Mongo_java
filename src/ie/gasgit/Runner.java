package ie.gasgit;

/**
 * Created by glen on 10/11/16.
 */
public class Runner {

    public static void main(String[] args) {

        Connect con = new Connect();

        con.insertFields("Zebra","888","555","black/white");
        con.getAllDocs();
        con.getFirst();
        con.findFilter("name","gordon");
        con.updateField("name","MongoDB","Mongo_changed");


    }

}
