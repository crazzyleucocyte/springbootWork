package com.study.springboot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Menu;
import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;
import com.study.springboot.service.MenuService;

@RestController
@RequestMapping("/menu")		//뭐가 됐든 /menu가 붙어있는거는 모두 이 컨트롤러로 들어오도록 했다.
public class MenuRestController {

	@Autowired
	MenuService menuService;
	
	@GetMapping
	public List<Menu> menuAllList(){
		return menuService.menuAllList();
	}
	
	@GetMapping("/type/{type}")
	public List<Menu> findByType(@PathVariable(name="type") Type type) {
		return menuService.findByType(type);
	}
	
	@GetMapping("/type/{type}/taste/{taste}")
	public List<Menu> findByTypeAndTaste(@PathVariable(name="type") Type type, @PathVariable(name="taste") Taste taste) {
		return menuService.findByTypeAndTaste(type, taste);
	}

	/*
	 * 지금까지 상태코드를 지정하기 위해 HttpServletResponse의 setStatus()와 sendError()를 사용
	   문제점은 에러시, json이 아닌 view(html, jsp)로 결과를 응답함.
	   오류를 json으로 응답하기 위해 ResponseEntity 사용해야함.
	   
	   - restFul하게 만들떄는 요구한 자원이 없을 떄 404오류 반환(클라이언트 측 오류<없는 id를 넣었기 떄문>)
	   	 null일떄와 null이 아닐때를 나누어 처리가 필요
	   
	 * ResponseEntity : 결과 데이터와 HTTP상태코드와 오류코드까지 직접 제어할 수 있는 클래스
	   - status : 응답에 대한 status코드
	   - header : header값(요청/응답)에 대한 요구사항
	   - body : 메시지 body에 작성될 내용(요구사항의 내용)	그래서 아래 insertmenu에서 @requestBody로 Menu객체를 받았다.
	   
	 * ResponseEntity 사용법
	   - status와 body를 이용
	   	 ResponseEntity.status(상태코드).body(객체)
	   	 
	   	 + 상태코드 HttpStatus에 정의된 값 이용
	   	   (document : https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpStatus.html)
	   
	   	 + 상태코드 ok와 body를 한번에 사용
	   	   ResponseEntity.ok(member)
	   	   
	   	 + body가 없을떄, build()사용하여 상태코드를 보내줄 때
	   	   ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   	   					or
	   	   ResponseEntity.status(404).build();
	   	
	   	 + body가 없고, status를 대신하여 사용하는 메서드
	   	   noContent() : 204
	   	   badRequest() : 400
	   	   notFound() : 404
	   
	   
	   **** 이 상태코드를 쓰는 이유는 클라이언트가 잘못 했을떄 해당 오류에 대해 알려주고 오류 원인을 알려주기 위함이므로
	   	    서버측에서는 클라이언트가 없는 id를 넣었는데 오류 코드로 500이 떠서 클라이언트 잘못인데 서버잘못으로 떴을떄 해당 오류코드를
	   	    바꿔준다던지,
	   	    오류코드에 대한 정보와 원인이 일치하지 않을떄라던지 그럴떄 사용한다
	   		
	   		아래와 같은 케이스로 오류코드가 뜨는데 주로 정상작동시 이후 행동이나 
	   		서버오류인데 사용자오류로 뜨던지 사용자 오류인데 서버 오류로 뜨던지 이럴떄 해당 오류코드를 변경해준다.
	   		
	   		없는걸 검색한다 > 사용자 잘못 (4xx)
	   		
			사용자가 정상적으로 입력했지만 
			서버가 결과 도출을 못했다 > 서버 잘못(5xx)
			
			정상적으로 작동했다(2xx / 3xx)
	   
	   
	   
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Menu> findById(@PathVariable(name="id") Long id){
		Optional<Menu> menu= menuService.findById(id);
		
		if(menu.isPresent()) {
			return ResponseEntity.ok(menu.get());				//ok면 200
		} else {
			return ResponseEntity.notFound().build();			//notFound면 404
		}
		
		// 정상조회가 안되면(id가 없을 떄) 500오류 발생
		// 500 : 서버측 오류
		// 사용자가 없는 id를 잘못 넣어서 발생된 오류
	}
	
	@PostMapping()
	public ResponseEntity<?> insertMenu(@RequestBody Menu menu){
		//JSON으로 값을 받을때는 @RequestParam이 아니라 @RequestBody로 받아야 한다.
		Menu reMenu = menuService.insertMenu(menu);
		System.out.println(menu);
		
		// 아래에 ResponseEntity.created(URI.create("/menu/"+ reMenu.getId())).build();의 뜻은
		// ajax의 jqXHR의 header에 /menu/{id}인 url을 담겠다는 뜻 그리고 ajax에서는 split을 쓰면 id를 얻을 수 있다.
		return ResponseEntity.created(URI.create("/menu/"+ reMenu.getId())).build();
	}
	
	@PutMapping()
	public ResponseEntity<?> updateMenu(@RequestBody Menu menu){
		 Menu reMenu = menuService.updateMenu(menu);
		 return ResponseEntity.ok(reMenu);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMenu(@PathVariable(name="id") Long id){
		menuService.deleteMenu(id);
		return ResponseEntity.noContent().build();  		// noContent : 204(http 상태코드)
	}
	
	
	
	
	
	
	

}
