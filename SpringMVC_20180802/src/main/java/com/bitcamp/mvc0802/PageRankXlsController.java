package com.bitcamp.mvc0802;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageRankXlsController {

	@RequestMapping("/pageRank/xls")
	public ModelAndView getXlsPage() {
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "www.naver.com"));
		pageRanks.add(new PageRank(2, "www.daum.net"));
		pageRanks.add(new PageRank(3, "www.nate.com"));
		return new ModelAndView("pageRanks", "pageRanks", pageRanks);
	}
	
	@RequestMapping("/pageRank/pdf")
	public ModelAndView getPdfpage() {

		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "www.naver.com"));
		pageRanks.add(new PageRank(2, "www.daum.net"));
		pageRanks.add(new PageRank(3, "www.nate.com"));
		
		return new ModelAndView("pageRanksPdf", "pageRanks", pageRanks);
		
	}
	
	
	
	
	
	
	
	
	
	
}
