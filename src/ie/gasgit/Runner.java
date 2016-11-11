package ie.gasgit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by glen on 10/11/16.
 */
public class Runner {

    public static void main(String[] args) {
        // create connect
        Connect con = null;
        try {
            con = new Connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create new object
        Person p = new Person("hilti", "555", "133","salmon44");
        // insert object
        con.insertObject(p);

//        // delete document key/value
//        con.delete("eye_col","salmon44");


        // insert document straight through fields
        con.insertFields("Zebra","888","555","black/white");
//        // get and print all docs
//        con.getAllDocs();
//        // get first doc
//        con.getFirst();
//        // get doc key/value
//        con.findFilter("name","gordon");
//        // update field in doc key/value
//        con.updateField("name","MongoDB","Mongo_changed");

//        // delete many docs common key/value
//        con.deleteMany("name","hilti");

        //con.createNewCollection("test_createNewCollection_method");
        con.createNewDatabase("test_createNewDatabase_method");


        // con.allDocs();
        con.allDocsList();
        // list all databases on server
        con.listDatabases();
        // list all collection in database
        con.listCollections();



    }

}
