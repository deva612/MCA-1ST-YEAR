package com.app.database;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import shadow.org.bson.Document;

public class DatabaseConnection {
	public static void insertUserData(String fName, String lName, String mobile, String email, String password) {
		
		
	}
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://piebytwo014:piebytwo014@cluster0.owltxjt.mongodb.net/?appName=Cluster0";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("secf");
                MongoCollection<Document> coll = database.getCollection("users");
                coll.insertOne(new Document("firstName", "Harsh")
                						.append("lastName", "Tyagi")
                						.append("mobileNum", "123456")
                						.append("userEmail", "harsh@rdec.in")
                						.append("userPassword", "harsh@123"));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}
