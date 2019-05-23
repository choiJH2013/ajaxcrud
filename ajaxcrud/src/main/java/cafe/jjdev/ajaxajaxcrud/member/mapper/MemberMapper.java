package cafe.jjdev.ajaxajaxcrud.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.ajaxajaxcrud.member.vo.Member;

@Mapper
public interface MemberMapper {
	
	public int selectMemberCount(); // 총 개수 리턴
	public List<Member> selectMemberList(int startRow);	// 리스트 출력
	public int insertMember(Member member);	// 입력
	public int deleteMember(Member member); // 삭제
	public int updateMember(Member member);	// 수정
	
	
}
