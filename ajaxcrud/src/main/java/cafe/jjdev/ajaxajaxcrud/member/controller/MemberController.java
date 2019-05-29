package cafe.jjdev.ajaxajaxcrud.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.ajaxajaxcrud.member.service.MemberService;
import cafe.jjdev.ajaxajaxcrud.member.vo.Member;



@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/getMembers")
	public Map<String, Object> getMembers(@RequestParam(value="startPage", defaultValue="1")int startPage) {
		System.out.println("맴버 리스트 매서드 요청" + startPage);
	
		Map<String, Object> resultMap = memberService.selectMemberList(startPage);
		System.out.println("리스트 개수 list.size()" + resultMap.size());
		System.out.println("컨트롤 map : " + resultMap);
		return resultMap;
	}
	
	@PostMapping("/addMember")
	public void addMember(Member member) {
		System.out.println("맴버 입력 매서드 요청 member : " + member);
		
		memberService.insertMember(member);
	}
	
	@PostMapping("/removeMember")
	public void removeMember(@RequestParam(value="ck[]") String[] ck) { // List<String> ck
		System.out.println("맴버 삭제 매서드 요청 id : " + ck);
		
		for(String id : ck) {
			Member member = new Member();
			member.setId(id);
			memberService.deleteMember(member);
		}
		
	}
	
	@PostMapping("/modifyById")
	public void modifyById(Member member) {
		System.out.println("맴버 수정 매서드 요청 member : " + member);
		
		memberService.updateMember(member);
		
	}
	
}
