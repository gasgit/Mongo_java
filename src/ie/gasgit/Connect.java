package ie.gasgit;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

/**
 * Created by glen on 11/11/16.
 */
public class Connect {

    // connect to server
    MongoClient mongoClient = new MongoClient("localhost", 27017);

    // connect to database
    MongoDatabase db = mongoClient.getDatabase("GLEN_TEST");

    // connect to collection
    MongoCollection<Document> collection = db.getCollection("mycollection");

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
    // insert adding object, can add different objects as documents
    public void insertObject(){

    }

    // get first doc in collection
    public void getFirst(){

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }


    public void getAllDocs(){

        // find all docs in collection
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
//        // find all foreach
//        for (Document ds : collection.find()) {
//            System.out.println(ds.toJson());
//        }

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







}
