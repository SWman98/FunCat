package fc.noticeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fc.noticeboard.domain.NoticeBoardPageMaker;
import fc.noticeboard.domain.NoticeBoardStandard;
import fc.noticeboard.domain.NoticeBoardVO;
import fc.noticeboard.service.NoticeBoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/notice/*")
public class NoticeBoardController {

	
	@Autowired
	private NoticeBoardService bservice;
	
	/* 게시판 목록 페이지 접속(페이징 적용) */
	@GetMapping("/list")
	public void noticelistGet(Model model, NoticeBoardStandard str) {
		
		log.info("noticeListGET");
		
		model.addAttribute("list", bservice.getListPaging(str));
		
		int total = bservice.getTotal(str);
		
		NoticeBoardPageMaker pageMake = new NoticeBoardPageMaker(str, total);
		
		model.addAttribute("pageMaker", pageMake);
		
		
	}
    
    @GetMapping("/enroll")
    // => @RequestMapping(value="enroll", method=RequestMethod.GET)
    public void noticeEnrollGET() {
        
        log.info("게시판 등록 페이지 진입");
        
    }
    
    /* 게시판 등록 */
    @PostMapping("/enroll")
    public String noticeEnrollPOST(NoticeBoardVO notice, RedirectAttributes rttr) {
        
        log.info("NoticeBoardVO : " + notice);
        
        bservice.enroll(notice);
        
        rttr.addFlashAttribute("result", "enrol success");
        
        return "redirect:/notice/list";
        
    }
    
    /* 게시판 조회 */
    @GetMapping("/get")
    public void noticeGetPageGET(int notice_num, Model model, NoticeBoardStandard str) {
    	model.addAttribute("pageInfo", bservice.getPage(notice_num));
    	
    	model.addAttribute("str", str);
    }
    
    /* 수정 페이지 이동 */
    @GetMapping("/modify")
    public void boardModifyGET(int notice_num, Model model, NoticeBoardStandard str) {
        
        model.addAttribute("pageInfo", bservice.getPage(notice_num));
        
        model.addAttribute("str", str);
        
    }
    
    /* 페이지 수정 */
    @PostMapping("/modify")
    public String boardModifyPOST(NoticeBoardVO notice, RedirectAttributes rttr) {
        
        bservice.modify(notice);
        
        rttr.addFlashAttribute("result", "modify success");
        
        return "redirect:/notice/list";
        
    }
    
    /* 페이지 삭제 */
    @PostMapping("/delete")
    public String boardDeletePOST(int notice_num, RedirectAttributes rttr) {
        
        bservice.delete(notice_num);
        
        rttr.addFlashAttribute("result", "delete success");
        
        return "redirect:/notice/list";
        
    }
}
