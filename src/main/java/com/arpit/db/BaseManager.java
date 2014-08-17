package com.arpit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

public class BaseManager {
	
	@Autowired
	public MongoOperations mongoOperation;
	
	public MongoOperations getMongoOperation() {
		return this.mongoOperation;
	}
	
	public void setMongoOperation(MongoOperations mongoOps) {
		this.mongoOperation = mongoOps;
	}
}
