
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
public class RetrieveController {
	@GetMapping(path = "/retrieve", produces = "text/plain")
	public ModelAndView retrieve(@RequestParam Long receipeId) {
		ModelAndView modelAndView = new ModelAndView("resultpage");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key receipeKey = KeyFactory.createKey("Receipe", receipeId);
		Entity result = null;
		try {
			result = datastore.get(receipeKey);
		} catch (EntityNotFoundException e) {
			return modelAndView.addObject("result", "Oops!!Receipe not found!!!");
		}
		Receipe receipeDetails=new Receipe(	(Long)result.getProperty("receipeId"),(String)result.getProperty("receipeName"));
		return modelAndView.addObject("result", receipeDetails.toString());
	}
}
