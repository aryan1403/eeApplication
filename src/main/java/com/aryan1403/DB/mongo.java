package com.aryan1403.DB;

import com.aryan1403.Merchandise.supplier;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class mongo {
    MongoClient client = new MongoClient("localhost", 27017);
    MongoDatabase database = client.getDatabase("eeapplication");
    MongoCollection<Document> collection = database.getCollection("Data");

    public void add(supplier s) {
        Document doc = new Document("id", s.getProductID())
            .append("pname", s.getProductName())
            .append("pid", s.getProductID())
            .append("pdesc", s.getProductDesc())
            .append("purl", s.getProductImageURL())
            .append("price", s.getPrice())
            .append("rating", s.getRating());

        collection.insertOne(doc);
    }

    public FindIterable<Document> retreive() {
        return collection.find();
    }
}
