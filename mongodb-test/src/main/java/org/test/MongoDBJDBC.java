package org.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;

public class MongoDBJDBC {


	public static <T> void main(String[] args) {
		try {

			System.out.println("start");

			//1、
			MongoClient mongoClient = new MongoClient("192.168.114.129", 27017);

			//2、
			MongoDatabase mongoDatabase = mongoClient.getDatabase("fssc");

			MongoCollection<Document> collection = mongoDatabase.getCollection("student");

//			insert(collection);
//			findAndPrint(collection);
			
			//remove(collection);
//			update(collection);
//			findAndPrint(collection);
			
//			Long count = collection.count(Filters.eq("name", "白攀"));
//			System.out.println(count);
			
//			 { $project : {
//			        title : 1 ,
//			        author : 1 ,
//			    }}
			 Bson bson = BsonDocument.parse("{\"$group\":{\"_id\":null,\"count\":{\"$sum\":1}}}");
			AggregateIterable<Document> aggregate = collection.aggregate(Arrays.asList(bson));
			MongoCursor<Document> iterator = aggregate.iterator();
			while (iterator.hasNext()) {
				Document next = iterator.next();
				
				System.out.println(next.toString());
			}
			



			System.out.println("successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void insert(MongoCollection<Document> collection) {
		Map<String, Object> bp = new HashMap<String, Object>();
		bp.put("code", "001");
		bp.put("age", "50");
		bp.put("name", "白攀");
		collection.insertOne(new Document(bp));
	}

	private static void remove(final MongoCollection<Document> collection) {
		Bson bson = BsonDocument.parse("{\"name\":\"白攀\"}");
		collection.deleteOne(bson);
	}
	
	private static void update(final MongoCollection<Document> collection) {
//		{
//		     upsert: <boolean>,
//		     multi: <boolean>,
//		     writeConcern: <document>
//		   }
		
		//更新文档   将文档中likes=100的文档修改为likes=200   
//        collection.updateMany(Filters.eq("name", "2B"), new Document("name","白攀"));  
		Bson bson_O = BsonDocument.parse("{\"name\":\"2B\"}");
		Bson bson_N = BsonDocument.parse("{\"$set\":{\"name\":\"白攀\"}}");
		collection.updateMany(bson_O,bson_N);
	}

	private static void findAndPrint(MongoCollection<Document> collection) {
		FindIterable<Document> docs = collection.find();

		MongoCursor<Document> iterator = docs.iterator();

		while (iterator.hasNext()) {
			Document next = iterator.next();
			System.out.println("你娃儿叫个岁每日眼的："+next.get("name"));
			System.out.println(next.toString());
		}
		
		System.out.println("=============================================================");
	}

}
