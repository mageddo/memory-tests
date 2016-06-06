package eu.kielczewski.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 6/3/16 3:42 PM
 */
@Controller
@RequestMapping("/system")
public class SystemHealthCheckController {

	@RequestMapping(value = "/memory", method = RequestMethod.GET)
	@ResponseBody
	public Map getSystemMemoryStatus(){

		Map<String, Object> map = new LinkedHashMap<>();
		long total = Runtime.getRuntime().totalMemory();
		long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		map.put("total", toMbytes(total));
		map.put("used", toMbytes(used));
		return map;
	}

	private Object toMbytes(final long value) {
		return String.format("%.2fM", value / 1024D / 1024D);
	}
}
