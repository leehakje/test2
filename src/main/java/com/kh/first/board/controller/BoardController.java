package com.kh.first.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.first.board.model.vo.Board;
import com.kh.first.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/blist.do")
	public String blistMethod(Model model) {
		model.addAttribute("blist", boardService.selectBoardList());
		return "board/bListView";
	}
	
	@RequestMapping("/binsertForm.do")
	public String binsertFormMethod() {
		
		return "board/binsertForm";
		
	}
	
	/*@RequestMapping(value = "/binsert.do", method = RequestMethod.POST)
	public String insertBoard(Board board, Model model) {
		int result = boardService.insertBoard(board);
		String viewName = null;
		if(result > 0)
			viewName = "bListView";
		else {
			model.addAttribute("message", "게시글 등록 실패");
			viewName = "binsertFail";
		}
		return viewName;
	}*/
	
	@RequestMapping("/binsert.do")
	public String insertBoard(Board board, HttpServletRequest request) throws IOException{
		//파일 업로드 처리
		MultipartHttpServletRequest multipartRequest =
				(MultipartHttpServletRequest)request;
		MultipartFile uploadFile = multipartRequest.getFile("upFile");
		
		// 웹서버 컨테이너 경로 추출함 
	    String root = request.getSession().getServletContext().getRealPath("/");
	    // 파일 저장 경로 정함
	    String savePath = root + "uploadFiles/";
	    
		if(!uploadFile.isEmpty()){
			String ofileName = uploadFile.getOriginalFilename();
			
			long currentTime = System.currentTimeMillis();  
		    SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rfileName = simDf.format(new Date(currentTime)) +"."
					+ ofileName.substring(ofileName.lastIndexOf(".")+1);;
					uploadFile.transferTo(new File(savePath + rfileName));
						
			board.setBoard_original_filename(ofileName);
			board.setBoard_rename_filename(rfileName);
		}
		
		boardService.insertBoard(board);
		
		
		return "redirect:blist.do";
	}
	
	 @RequestMapping("/bDetailView.do")
	   public String boardDetail(Board board, Model model) {
	      model.addAttribute("board", boardService.selectOne(board));
	      
	      return "board/bDetailView";
	   }
	 
	 @RequestMapping("/bdownfile.do")
		public void fileDownload(
				@RequestParam(value="rfile") String rfileName, 
				@RequestParam(value="ofile") String ofileName,
				HttpServletResponse response,
				HttpServletRequest request){
			// 프로젝트 내에 파일이 저장된 곳의 위치를 얻어옴
			String saveFolder = request.getSession()
				   .getServletContext().getRealPath("/uploadFiles/");			 
			
			BufferedInputStream buf = null;
			ServletOutputStream downOut = null;
				 
			try {		  
			   downOut = response.getOutputStream();
			   File downfile = new File(saveFolder + "/" + rfileName);
			   response.setContentType("text/plain; charset=utf-8");		
				//한글 파일명 인코딩 처리
				response.addHeader("Content-Disposition", "attachment; filename=\"" + 
				 new String(ofileName.getBytes("UTF-8"), "ISO-8859-1") + 
				 "\"");
			   response.setContentLength((int)downfile.length());
			   
			   FileInputStream input = new FileInputStream(downfile);
			   buf = new BufferedInputStream(input);
			   int readBytes = 0;

			   while ((readBytes = buf.read()) != -1){
				downOut.write(readBytes);
			   }
			   downOut.close();
			   buf.close();
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
		}
	 @RequestMapping("/bdelete.do")
		public String deleteBoardMethod(Board board, Model model) {
			boardService.bdelete(board);
			return "redirect:blist.do";
			
	 }

	
}
