package com.app.database;


import com.app.config.AppConfig;
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
	static String userName =  AppConfig.getSecretData("MONGO_DB_USERNAME");
	static String dbPassword =  AppConfig.getSecretData("MONGO_DB_PASSWORD");
	 static String connectionString = "mongodb+srv://"+userName+":"+dbPassword+"@cluster0.wwc2tlu.mongodb.net/?appName=Cluster0";

     static ServerApi serverApi = ServerApi.builder()
             .version(ServerApiVersion.V1)
             .build();

     static MongoClientSettings settings = MongoClientSettings.builder()
             .applyConnectionString(new ConnectionString(connectionString))
             .serverApi(serverApi)
             .build();
     // Create a new client and connect to the server
     static MongoClient mongoClient = MongoClients.create(settings);
       
     static MongoDatabase database = mongoClient.getDatabase("rdec_mca");
     static MongoCollection<Document> c = database.getCollection("users");
    
         
	
	public static boolean insertUserData(String firstName, String lastName, long phone, String userMail, String userPwd) {
		try {
			c.insertOne(new Document("firstName", firstName)
	 				.append("lastName", lastName)
	 				.append("mobileNum", phone)
	 				.append("userEmail", userMail)
	 				.append("userPassword", userPwd)
	 				.append("isVerified", false));
			return true;
		} catch (Exception e) {
			return false;
		}
		 
	}
	
}