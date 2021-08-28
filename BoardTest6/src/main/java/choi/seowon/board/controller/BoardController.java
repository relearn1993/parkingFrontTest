package choi.seowon.board.controller;

import choi.seowon.board.dto.BoardDto;
import choi.seowon.board.Service.BoardService;
import choi.seowon.board.Service.SearchService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Http 요청이 진입하는 지점
public class BoardController {
	private BoardService boardService;
	private SearchService searchService;
	
	public BoardController(BoardService boardService, SearchService searchService) {
		this.boardService = boardService;
		this.searchService = searchService;
	}
	
	@GetMapping("/")
	public String mainPage() {
		return "index.html";
	}
	
	@GetMapping("/board")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) { //가져온 getBoard 데이터를 model을 통해 view에 전달
		List<BoardDto> boardDtoList = boardService.getBoardList(pageNum);
		Integer[] pageList = boardService.getPageList(pageNum);
		
		model.addAttribute("postList", boardDtoList);
		model.addAttribute("pageList", pageList);
		
		return "board/list.html";
	}
	
	@GetMapping("/post")
	public String post() {
		return "board/post.html";
	}
	
	@PostMapping("/post")
	public String write(BoardDto boardDto) {
		boardService.savePost(boardDto);
		return "redirect:/board/";
	}
	
	@GetMapping("/post/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		BoardDto boardDto = boardService.getPost(id);
		
		model.addAttribute("post", boardDto);
		return "board/detail.html";
	}
	
	@GetMapping("/post/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		BoardDto boardDto = boardService.getPost(id);
		
		model.addAttribute("post", boardDto);
		return "board/update.html";
	}
	
	@PutMapping("/post/edit/{id}")
	public String update(BoardDto boardDto) {
		boardService.savePost(boardDto);
		return "redirect:/board";
	}
	
	@DeleteMapping("/post/{id}")
	public String delete(@PathVariable("id") Long id) {
		boardService.deletePost(id);
		return "redirect:/board";
	}
	
	@GetMapping("/board/search")
	public String search(@RequestParam(value="keyword") String keyword, Model model) {
	    List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
	    
	    model.addAttribute("boardList", boardDtoList);
	    
	    return "board/list.html";
	}
	

	@GetMapping("/login")
	public String loginPage() {
		return "loginform.html";
	}

	@GetMapping("/join")
	public String joinpage() {
		return "joinform.html";
	}
	
	@GetMapping("/search")
	public String searchpage(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) { //가져온 getBoard 데이터를 model을 통해 view에 전달
		List<BoardDto> boardDtoList = searchService.getBoardList(pageNum);
		Integer[] pageList = searchService.getPageList(pageNum);
		
		model.addAttribute("postList", boardDtoList);
		model.addAttribute("pageList", pageList);

		return "search.html";
	}

	@GetMapping("/post/parking{id}")
	public String parkingdetail(@PathVariable("id") Long id, Model model) {
		BoardDto boardDto = boardService.getPost(id);
		
		model.addAttribute("post", boardDto);
		return "detailpage.html";
	}
}
