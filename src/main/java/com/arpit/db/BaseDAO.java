package com.arpit.db;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public abstract class BaseDAO<T> {
	private Class<T> type = null;
	
	public BaseDAO(Class<T> type) {
		this.type = type;
	}
	
	public Class<T> getType() {
		System.out.println("The type is: "+this.type.toString());
        return this.type;
    }
	
	@Autowired
	public MongoOperations mongoOperation;
	
	public MongoOperations getMongoOperation() {
		return this.mongoOperation;
	}
	
	public void setMongoOperation(MongoOperations mongoOps) {
		this.mongoOperation = mongoOps;
	}
	
	public void add(T entity) {
		mongoOperation.save(entity);
	}
	
	public List<T> getAll(){
		List<T> entities= mongoOperation.findAll(this.getType());
		return entities;
	}
	
	public T get(String id){
		Query searchQuery = new Query(Criteria.where("_id").is(id));
		return mongoOperation.findOne(searchQuery, this.getType());
	}

	public void delete(BigInteger id) {
		//TODO: Auto-generated code 
	}
}
