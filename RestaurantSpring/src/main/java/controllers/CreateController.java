package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.Receipe;

@Controller
public class CreateController {
	@PostMapping(value = "/create", produces = "text/plain")
	public ModelAndView create(@RequestParam Long receipeId, @RequestParam String receipeName) {
		ModelAndView modelAndView = new ModelAndView("resultpage");
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		Entity receipe = new Entity("Receipe", receipeId);
		receipe.setProperty("receipeId", receipeId);
		receipe.setProperty("receipeName", receipeName);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(receipe);
		Entity result = null;
		try {
			result = datastore.get(receipeKey);
		} catch (EntityNotFoundException e) {
			return modelAndView.addObject("result", "Oops! Receipe not found!!");
		}
		Receipe receipeDetails = new Receipe((Long)result.getProperty("receipeId"),(String)result.getProperty("receipeName"));
		return modelAndView.addObject("result", receipeDetails);
	

	}

}
