package controllers;

import models.Group;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

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