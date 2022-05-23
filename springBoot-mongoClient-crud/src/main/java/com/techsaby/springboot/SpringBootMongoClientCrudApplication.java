package com.techsaby.springboot;

import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@SpringBootApplication
//public class SpringBootMongoClientCrudApplication implements CommandLineRunner {
public class SpringBootMongoClientCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoClientCrudApplication.class, args);
	}

	/*
	 * public MongoClient getClient() { return new MongoClient("localhost", 27017);
	 * }
	 * 
	 * @Override public void run(String... args) throws Exception { //1 - Connection
	 * MongoClient mongoClient = getClient();
	 * 
	 * //2 - Get Database or will be created if not present MongoDatabase database =
	 * mongoClient.getDatabase("testDatabase");
	 * 
	 * //3- Get Collection inside the Database or will be created if not present
	 * MongoCollection<Document> employeeCollection =
	 * database.getCollection("employeeCollection");
	 * 
	 * //4 - Create Document and Add document to the Collection
	 * 
	 * Document document = new Document(); document.append("firstName", "Tony");
	 * document.append("lastName", "Stark"); document.append("address", "Malibu");
	 * 
	 * employeeCollection.insertOne(document); System.out.println("Data Inserted!");
	 * 
	 * 
	 * }
	 */

}
