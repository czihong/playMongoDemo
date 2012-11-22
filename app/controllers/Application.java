package controllers;

import models.Group;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.mapping.Mapper;
import com.google.code.morphia.query.UpdateOperations;
import com.mongodb.Mongo;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  // Test 111 222
	public static Result index() throws Exception {  
    Morphia morphia = new Morphia();  
    Mongo mongo = new Mongo("127.0.0.1",27017);  
    Datastore ds = morphia.createDatastore(mongo, "test");  
    ds.ensureIndexes();   
    ds.ensureCaps();  
      
    Group me = new Group();
    me.groupName = "test group";  
    ds.save(me);  
    Group e3 = ds.find(Group.class).get();   
    UpdateOperations<Group> ops = ds.createUpdateOperations(Group.class).set("groupName", "hello world");  
    //UpdateOperations<Group> ops = ds.createUpdateOperations(Group.class).unset("name");  
    ds.update(ds.createQuery(Group.class).field(Mapper.ID_KEY).equal(e3.id), ops);  
    String result = "";
    for(Group me2 : ds.find(Group.class)){  
        System.out.println(me2.groupName);  
        result = me2.groupName;
    }  
    return ok(result);
	} 
  
}