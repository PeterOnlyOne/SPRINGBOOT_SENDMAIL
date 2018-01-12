package cn.et;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MailController {

	@Autowired
	private JavaMailSender jms;
	
	@PostMapping("/send")
	public String sendMail(@RequestBody Map<String, Object> map){
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("wqm19980102@126.com");
		smm.setTo(map.get("email_to").toString());
		smm.setSubject(map.get("email_subject").toString());
		smm.setText(map.get("email_content").toString());
		jms.send(smm);
		return "ok";
	}
	
	@GetMapping("/user/{userId}")
	public Map getUser(@PathVariable String userId){
		Map map = new HashMap();
		map.put("id", userId);
		map.put("name", "zs"+userId);
		return map;
	}
}
