package br.com.gustavoleterio.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoleterio.mvc.mudi.interceptor.AccessInterceptor;
import br.com.gustavoleterio.mvc.mudi.interceptor.AccessInterceptor.Access;

@RestController
@RequestMapping("/api/access")
public class AccessRest {
	
	@GetMapping
	public List<Access> getAccess(){
		return AccessInterceptor.accesses;
	}
}
