package com.techsaby.springboot.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.techsaby.springboot.entity.Employee;

@Repository
public class EmployeeRepository {
	
	private MongoClient client;
	
	public MongoClient getClient() {
		if(client ==null) {
			client = new MongoClient("localhost", 27017);
		}
		return client;
	}
	
	public List<Employee> getAll() {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("testDatabase");
		MongoCollection<Document> employeeCollection 
									= database.getCollection("employeeCollection");
		
		List<Employee> responseList = new ArrayList<Employee>();
		for(Document doc : employeeCollection.find()) {
			Employee emp = new Employee(doc.get("_id").toString()
					, doc.getString("firstName"),doc.getString("lastName"),doc.getString("address"));
			responseList.add(emp);
		}
		return responseList;
	}

	public String save(Employee emp) {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("testDatabase");
		MongoCollection<Document> employeeCollection 
									= database.getCollection("employeeCollection");
		
		Document doc = new Document();
		doc.append("firstName", emp.getFirstName());
		doc.append("lastName", emp.getLastName()); 
		doc.append("address", emp.getAddress());
		
		String response; 
		
		try {
			employeeCollection.insertOne(doc);
			response = "Sucessfully Inserted! " + doc.toString();
		}catch(Exception e) {
			response ="Something went wrong, Please try again later!";
		}
		return response;
	}

	public String update(Employee emp) {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("testDatabase");
		MongoCollection<Document> employeeCollection 
									= database.getCollection("employeeCollection");
		
		Document doc = new Document();
		doc.append("firstName", emp.getFirstName());
		doc.append("lastName", emp.getLastName()); 
		doc.append("address", emp.getAddress());
		
		String response; 
		
		try {
			BasicDBObject filter = new BasicDBObject("_id", new ObjectId(emp.getId()));
			employeeCollection.updateOne(filter, new BasicDBObject("$set", doc));
			response = "Sucessfully Updated! " + doc.toString();
		}catch(Exception e) {
			response ="Something went wrong, Please try again later!";
		}
		return response;
	}

	public String delete(String id) {
		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("testDatabase");
		MongoCollection<Document> employeeCollection 
									= database.getCollection("employeeCollection");
		
		String response; 
		
		try {
			BasicDBObject filter = new BasicDBObject("_id", new ObjectId(id));
			employeeCollection.deleteOne(filter);
			response = "Sucessfully Deleted! " + id.toString();
		}catch(Exception e) {
			response ="Something went wrong, Please try again later!";
		}
		return response;
	}

}
