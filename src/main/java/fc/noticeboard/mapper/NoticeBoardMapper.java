package fc.noticeboard.mapper;

import java.util.List;

import fc.noticeboard.domain.NoticeBoardStandard;
import fc.noticeboard.domain.NoticeBoardVO;

public interface NoticeBoardMapper {
	
	/* 게시판 등록 */
    public void enroll(NoticeBoardVO notice);
    
    /* 게시판 목록 */
    public List<NoticeBoardVO> getList();
    
    /* 게시판 조회 */
    public NoticeBoardVO getPage(int notice_num);
   
    /* 게시판 수정 */
    public int modify(NoticeBoardVO notice);
    
    /* 게시판 삭제 */
    public int delete(int notice_num);
    
    /* 게시판 목록(페이징 적용) */
    public List<NoticeBoardVO> getListPaging(NoticeBoardStandard sta);
    
    /* 게시판 총 개수 */
    public int getTotal(NoticeBoardStandard str);
}
