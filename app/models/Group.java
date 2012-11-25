package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import play.Logger;
import play.data.validation.Constraints.Required;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

import controllers.MorphiaObject;

@Entity
public class Group {

	@Id
	public ObjectId id;
	@Required
	public String groupName;
	@play.data.format.Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date date;

	public static List<Group> all() {
		if (MorphiaObject.datastore != null) {
			return MorphiaObject.datastore.find(Group.class).asList();
		} else {
			return new ArrayList<Group>();
		}
	}

	public static void create(Group group) {
		MorphiaObject.datastore.save(group);
	}
	
	public static void delete(String idToDelete) {
		Group toDelete = MorphiaObject.datastore.find(Group.class).field("_id").equal(new ObjectId(idToDelete)).get();
		if (toDelete != null) {
			Logger.info("toDelete: " + toDelete);
			MorphiaObject.datastore.delete(toDelete);
		} else {
			Logger.debug("ID No Found: " + idToDelete);
		}
	}
	
	@Override
	public String toString() {
		return id + ":" + groupName;
	}
}
