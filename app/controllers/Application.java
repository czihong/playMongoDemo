package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.Group;

public class Application extends Controller {
	static Form<Group> groupForm = form(Group.class);

	public static Result index() throws Exception {
		// redirect to the "group Result
		return redirect(routes.Application.group());
	}

	public static Result group() {
		return ok(views.html.index.render(Group.all(), groupForm));
	}

	public static Result newGroup() {
		Form<Group> filledForm = groupForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Group.all(), filledForm));
		} else {
			Group.create(filledForm.get());
			return redirect(routes.Application.group());  
		}
	}
	
	public static Result deleteGroup(String id) {
		Group.delete(id);
		return redirect(routes.Application.group());
	}

}
