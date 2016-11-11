package ie.gasgit;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
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
        // connect to server
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // connect to database
        MongoDatabase db = mongoClient.getDatabase("GLEN_TEST");
        System.out.println("Connected to database successfully");

        // connect to collection
        MongoCollection<Document> collection = db.getCollection("mycollection");

        // create document
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
        Document myDoc2 = collection.find(eq("name", "MongoDB")).first();
        System.out.println("here");
        System.out.println(myDoc2.toJson());

        // update doc by field
        collection.updateOne(eq("name", "gordon"), set("name", "glen"));

        // update many
        UpdateResult updateResult = collection.updateMany(eq("name", "glen"), set("name", "gordon"));
        System.out.println("Update Document Count: " + updateResult.getModifiedCount());


    }
}
