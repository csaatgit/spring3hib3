package controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public ModelAndView returnView() {
		return new ModelAndView("hello", "message", "Hi Every One");
	}
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public @ResponseBody Map<String, String> getMovie(@PathVariable String name) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("movie", name);
		return result;
	}
	
}
