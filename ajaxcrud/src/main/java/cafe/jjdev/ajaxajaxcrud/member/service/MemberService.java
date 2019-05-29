package cafe.jjdev.ajaxajaxcrud.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.ajaxajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.ajaxajaxcrud.member.vo.Member;

@Service
@Transactional
public class MemberService {
	
	@Autowired private MemberMapper memberMapper;
	
	// 리스트									LIMIT	몇번째 부터 보여줄지 사용할 값에 영향을 주기위한 값
	public Map<String, Object> selectMemberList(int startPage){
		
		//맵을 사용한다
		Map<String, Object> map = new HashMap<String, Object>();		
		
		// 몇개를 보여줄 변수를 선언한다
		final int ROW_PER_PAGE = 10;
		
		//페이징에 사용할 변수 startRow:몇번째데이터 부터 보여줄지를 정함
		int startRow = (startPage-1)*ROW_PER_PAGE;
		System.out.println("startRow : " + startRow);
		
		// 셀렉트쿼리문 몇번째부터 몇개를 보여줄 데이터 map에 담음
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		List<Member> list = memberMapper.selectMemberList(map);
		
		// 라스트 페이지를 구하기위해 데이터 총개수를 구함
		int allCount = memberMapper.selectMemberCount();
		System.out.println("allCount 총인원 : " + allCount);
		
		// 마지막페이지   
		int lastPage = 0;
		// 나눠서 나머지가 있을경우  예 : 105%10 은 10.5 이므로 완전히 나눌수없어서 나머지가 있다. 이경우 데이터가 남아있기에 페이지를 한장더 있어야 나머지 5개의 데이터를 볼 수 있다.
		// ※ SQL은 알아서 마지막남은걸 보여주지만 / 마지막도 갯수를 알려줘야 하는것도 있다.
		if(allCount % ROW_PER_PAGE == 0) {
			lastPage = allCount/ROW_PER_PAGE;
		}else {
			lastPage = allCount/ROW_PER_PAGE+1;
		}
		
		
		// 맵에 담아서 뷰에필요한 값을 리턴한다.
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("startPage", startPage);
		resultMap.put("list", list);
		resultMap.put("lastPage", lastPage);
		
		return resultMap;
	}
	
	// 추가
	public int insertMember(Member member) {
		
		return memberMapper.insertMember(member);
	}
	
	// 삭제
	public int deleteMember(Member member) {
		
		
		
		return memberMapper.deleteMember(member);
	}
	
	// 수정
	public int updateMember(Member member) {
		
		
		
		return memberMapper.updateMember(member);	
	}
	
	
	
	
}
