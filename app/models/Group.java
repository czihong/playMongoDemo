package models;

import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.*;

@Entity  
public class Group {
	
  @Id
  public ObjectId id;
	public String groupName;
}
