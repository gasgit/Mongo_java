package ie.gasgit;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.set;


/**
 * Created by glen on 10/11/16.
 */
public class Test_Grounds {


    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        System.out.println("Connected to database successfully");

        MongoDatabase db = mongoClient.getDatabase("GLEN_TEST");

        MongoCollection<Document> collection = db.getCollection("mycollection");

        Document doc = new Document("name", "MongoDB")
                .append("id", "999")
                .append("height", 666)
                .append("eye_col","pink");


        // insert doc to collection
        collection.insertOne(doc);

        // find all docs in collection
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        // count docs in collection
        System.out.println("Total Documents: " + collection.count());

        // get first docs in collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        // find by filter
//        myDoc = collection.find(eq("name", "glen")).first();
//        System.out.println(myDoc.toJson());

        // update doc by field
        collection.updateOne(eq("name", "gordon"), set("name", "glen"));

        // update many
        UpdateResult updateResult = collection.updateMany(eq("name", "glen"), set("name", "gordon"));
        System.out.println("Update Document Count: " + updateResult.getModifiedCount());


//        FindIterable<Document> records =  db.getCollection("mycollection").find(new Document("name", "harriot"));


//        MongoCursor<Document> iterator = records.iterator();
//
//        while(iterator.hasNext()){
//            Document doc = iterator.next();
//            System.out.println(doc);
//        }


        //**********************  find all ************************************

//        FindIterable<Document> records = db.getCollection("mycollection").find();

//        while (iterator.hasNext()) {
//            Document doc = iterator.next();
//            System.out.println(doc);
//            String name = doc.getString("name");
//            String id = doc.get("id").toString();
//            String height = doc.get("height").toString();
//            String eye_col = doc.getString("eye_col");
//
//            System.out.println("Name: " + name);
//            System.out.println("ID: " + id);
//            System.out.println("Height: " + height);
//            System.out.println("Eye Colour:" + eye_col);
//        }

        //*******************************************************************************************


    }
}
