package eu.kielczewski.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 6/3/16 5:21 PM
 */
@Controller
@RequestMapping("/test")
public class HelloWorld {

	@RequestMapping(value = "/sum", method = RequestMethod.GET)
	@ResponseBody
	public double sum(@RequestParam("a") double a, @RequestParam("b") double b){
		return a + b;
	}
}
