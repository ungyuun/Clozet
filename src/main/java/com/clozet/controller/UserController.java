package com.clozet.controller;

import com.clozet.Mapper.ProductMapper;
import com.clozet.auth.PrincipalDetails;
import com.clozet.model.dto.KakaoTokenDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.dto.UserDto;
import com.clozet.model.entity.Role;
import com.clozet.model.entity.User;
import com.clozet.repository.UserRepository;
import com.clozet.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


//==> 회원관리 Controller
@RestController
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserService userService;

	@GetMapping("/loginForm")
	public String loginForm(){
		return "login";
	}
	@GetMapping("/kakao/callback")
	public ResponseEntity<Map<String,Object>> kakaoLogin(@RequestParam("code")String code) throws Exception {
		// authorizedCode: 카카오 서버로부터 받은 인가 코드
		System.out.println("code : "+code);
		Map<String,Object> map = userService.kakaoLogin(code);
		userService.register((UserDto)map.get("UserDto"));
		return ResponseEntity.ok(map);
	}

	@GetMapping("/joinForm")
	public String joinForm(){
		return "join";
	}

	@GetMapping("/user")
	@ResponseBody
	public String user(){
		return "user";
	}

	@GetMapping("/manager")
	@ResponseBody
	public String manager(){
		return "manager";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String admin(){
		return "admin";
	}


//	@Value("#{commonProperties['pageUnit']}")
//	int pageUnit;
//	@Value("#{commonProperties['pageSize']}")
//	int pageSize;
//
//
//	@RequestMapping( value="addUser", method=RequestMethod.GET )
//	public String addUser() throws Exception{
//
//		System.out.println("/user/addUser : GET");
//
//		return "redirect:/user/addUserView.jsp";
//	}
//
//	@RequestMapping( value="addUser", method=RequestMethod.POST )
//	public String addUser( @ModelAttribute("user") User user ) throws Exception {
//
//		System.out.println("/user/addUser : POST");
//		//Business Logic
//		userService.addUser(user);
//
//		return "redirect:/user/loginView.jsp";
//	}
//
//
//	@RequestMapping( value="getUser", method=RequestMethod.GET )
//	public String getUser( @RequestParam("userId") String userId , Model model ) throws Exception {
//
//		System.out.println("/user/getUser : GET");
//		//Business Logic
//		UserDto userDto = userService.getUser(userId);
//		// Model 과 View 연결
//		model.addAttribute("userDto", userDto);
//
//		return "forward:/user/getUser.jsp";
//	}
//
//	@RequestMapping( value="updateUser", method=RequestMethod.GET )
//	public String updateUser( @RequestParam("userId") String userId , Model model ) throws Exception{
//
//		System.out.println("/user/updateUser : GET");
//		//Business Logic
//		User user = userService.getUser(userId);
//		// Model 과 View 연결
//		model.addAttribute("user", user);
//
//		return "forward:/user/updateUser.jsp";
//	}
//
//	@RequestMapping( value="updateUser", method=RequestMethod.POST )
//	public String updateUser( @ModelAttribute("user") User user , Model model , HttpSession session) throws Exception{
//
//		System.out.println("/user/updateUser : POST");
//		//Business Logic
//		userService.updateUser(user);
//
//		String sessionId=((User)session.getAttribute("user")).getUserId();
//		if(sessionId.equals(user.getUserId())){
//			session.setAttribute("user", user);
//		}
//
//		return "redirect:/user/getUser?userId="+user.getUserId();
//	}
//
//
//	@RequestMapping( value="login", method=RequestMethod.GET )
//	public String login() throws Exception{
//
//		System.out.println("/user/logon : GET");
//
//		return "redirect:/user/loginView.jsp";
//	}
//
//	@RequestMapping( value="login", method=RequestMethod.POST )
//	public String login(@ModelAttribute("user") User user , HttpSession session ) throws Exception{
//
//		System.out.println("/user/login : POST");
//		//Business Logic
//		User dbUser=userService.getUser(user.getUserId());
//
//		if( user.getPassword().equals(dbUser.getPassword())){
//			session.setAttribute("user", dbUser);
//			System.out.println(dbUser.toString());
//		}
//
//		return "redirect:/index.jsp";
//	}
//
//	@RequestMapping( value="logout", method=RequestMethod.GET )
//	public String logout(HttpSession session ) throws Exception{
//
//		System.out.println("/user/logout : POST");
//
//		session.invalidate();
//
//		return "redirect:/index.jsp";
//	}
//
//
//	@RequestMapping( value="checkDuplication", method=RequestMethod.POST )
//	public String checkDuplication( @RequestParam("userId") String userId , Model model ) throws Exception{
//
//		System.out.println("/user/checkDuplication : POST");
//		//Business Logic
//		boolean result=userService.checkDuplication(userId);
//		// Model 과 View 연결
//		model.addAttribute("result", new Boolean(result));
//		model.addAttribute("userId", userId);
//
//		return "forward:/user/checkDuplication.jsp";
//	}
//
//
//	@RequestMapping( value="listUser" )
//	public String listUser( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
//
//		System.out.println("/user/listUser : GET / POST");
//
//		if(search.getCurrentPage() ==0 ){
//			search.setCurrentPage(1);
//		}
//		search.setPageSize(pageSize);
//
//		// Business logic 수행
//		Map<String , Object> map=userService.getUserList(search);
//
//		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
//		System.out.println(resultPage);
//
//		// Model 과 View 연결
//		model.addAttribute("list", map.get("list"));
//		model.addAttribute("resultPage", resultPage);
//		model.addAttribute("search", search);
//
//		return "forward:/user/listUser.jsp";
//	}
}