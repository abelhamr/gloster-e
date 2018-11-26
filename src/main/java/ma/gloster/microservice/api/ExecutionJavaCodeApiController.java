package ma.gloster.microservice.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import ma.gloster.microservice.dto.DataJson;

@RestController
public class ExecutionJavaCodeApiController {
	
	
	@PostMapping("/javaCode")
	public void executeJavaCode(DataJson data) {
		
		
	}

}
