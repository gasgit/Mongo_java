package ie.gasgit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by glen on 10/11/16.
 */
public class Runner {

    public static void main(String[] args) {

        Connect con = null;
        try {
            con = new Connect();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Person p = new Person("hilti", "555", "133","salmon44");
        con.insertObject(p);


//        con.delete("eye_col","salmon44");



        con.insertFields("Zebra","888","555","black/white");
//        con.getAllDocs();
//        con.getFirst();
//        con.findFilter("name","gordon");
//        con.updateField("name","MongoDB","Mongo_changed");


//        con.deleteMany("name","hilti");

        //con.createNewCollection("test_createNewCollection_method");
        con.createNewDatabase("test_createNewDatabase_method");


       // con.allDocs();
        con.allDocsList();

        con.listDatabases();
        con.listCollections();



    }

}
