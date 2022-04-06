package fc.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fc.noticeboard.domain.NoticeBoardStandard;
import fc.noticeboard.domain.NoticeBoardVO;
import fc.noticeboard.mapper.NoticeBoardMapper;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	
	@Autowired
	private NoticeBoardMapper mapper;
	
	/* 게시판 등록 */
	@Override
	public void enroll(NoticeBoardVO notice) {
		
		mapper.enroll(notice);
	}
	
	/* 게시판 목록 */
	@Override
	public List<NoticeBoardVO> getList(){
		
		return mapper.getList();
	}
	
	/* 게시판 조회 */
	@Override
	public NoticeBoardVO getPage(int notice_num){
		
		return mapper.getPage(notice_num);
	}
	
	/* 게시판 수정 */
    @Override
    public int modify(NoticeBoardVO notice) {
        
        return mapper.modify(notice);
    }
    
    /* 게시판 삭제 */
    @Override
    public int delete(int notice_num) {
        
        return mapper.delete(notice_num);
    }
	
    /* 게시판 목록(페이징 적용) */
    @Override
    public List<NoticeBoardVO> getListPaging(NoticeBoardStandard str){
    	return mapper.getListPaging(str);
    }
    
    /* 게시물 총 개수 */
    @Override
    public int getTotal(NoticeBoardStandard str) {
        
        return mapper.getTotal(str);
    }

}
