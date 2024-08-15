package well.demo.strings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class StringDetectorController {

	
	@Autowired
	private StringDetectorService stringDectorService;
	
	/**
	 * GET implementation
	 */
	@RequestMapping(method=RequestMethod.GET, value="/query")
	public int hasKey(@RequestParam(name="key", required=true) String key) {
		 return  stringDectorService.hasKey(key);
		 
	 }
	
	@RequestMapping(method=RequestMethod.POST, value="/input", consumes = "text/plain")
	public void addString(@RequestBody String topic) {
		stringDectorService.addString(topic);
	}
	
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hello";
	}
	
	
	
	
}
