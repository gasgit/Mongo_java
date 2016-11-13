package ie.gasgit;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

/**
 * Created by glen on 11/11/16.
 */
public class Connect {

    // connect to server
    private MongoClient mongoClient = new MongoClient("localhost", 27017);

    // connect to database
    private MongoDatabase db = mongoClient.getDatabase("GLEN_TEST");

    // connect to collection
    private MongoCollection<Document> collection = db.getCollection("mycollection");

    // insert adding fields
    public void insertFields(String name, String id, String height, String eye_col){

        // create document
        Document doc = new Document("name", name)
                .append("id", id)
                .append("height", height)
                .append("eye_col",eye_col);

        // insert doc to collection
        collection.insertOne(doc);


    }
    // insert adding object
    public void insertObject(Person object){

        Document doc = new Document("name",object.getName())
                        .append("id",object.getId())
                        .append("height", object.getHeight())
                        .append("eye_col",object.getEye_col());

        collection.insertOne(doc);
    }

    // insert any object
    public <E> void insertGeneric(E object) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(object);

        System.out.println("json: " + jsonString);
        collection.insertOne(Document.parse(jsonString));

    }

    // get first doc in collection
    public void getFirst(){

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }


    public void allDocs(){
        // find all docs in collection
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        }
        // count docs in collection
        System.out.println("Total Documents: " + collection.count());

    }

    public void allDocsList(){
        List<String> docs = new ArrayList<String>();
        // find all foreach
        for (Document ds : collection.find()) {
            docs.add(ds.toJson());
            System.out.println(ds.toJson());
        }
        System.out.println(docs);
        // count docs in collection
        System.out.println("Total Documents: " + collection.count());
    }

    // find by filter
    public void findFilter(String key, String value){

        Document doc = collection.find(eq(key, value)).first();
        System.out.println("Filter Result:  " + doc.toJson());
    }

    // update doc by field
    public void updateField(String key, String oldValue,  String newValue ){

        collection.updateOne(eq(key, oldValue), set(key, newValue));
    }

    // update many
    public void updateMany(String key, String oldValue,  String newValue){
        UpdateResult updateResult = collection.updateMany(eq(key, oldValue), set(key, newValue));
        System.out.println("Update Document Count: " + updateResult.getModifiedCount());
    }
    // delete
    public void delete(String key, String value){

        collection.deleteOne(eq(key,value));

    }

    public void deleteMany(String key, String value){

        collection.deleteMany(eq(key,value));

    }
    // return list dbs
    public void listDatabases(){

        List<String> dbs = new ArrayList();

        for (String name: mongoClient.listDatabaseNames()) {
            dbs.add(name);
        }

        System.out.println(dbs);
    }
    // return list collections
    public void listCollections(){

        List<String> cols = new ArrayList();

        for (String name : db.listCollectionNames()) {
            //System.out.println(name);
            cols.add(name);
        }
        System.out.println(cols);
    }


    public void createNewDatabase(String name){



    }

    public void createNewCollection(String name){



        db.createCollection(name);

    }

    public void deleteDatabase(String name){

        mongoClient.getDatabase(name).drop();

    }

    public void deleteCollection(){






    }







}
