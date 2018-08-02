package com.bitcamp.mvc0802;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseField;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PageRankPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");
		
		// 테이블 생성
		Table table = new Table(2,pageRanks.size()+1);
		table.setPadding(5);
		
		// 사용 폰트 틍록
		BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bf);
		
		// 셀 생성
		Cell cell = new Cell(new Paragraph("순위", font));
		cell.setHeader(true);
		
		// 테이블에 셀을 등록
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("페이지", font));
		table.addCell(cell);
		
		table.endHeaders();
		
		for (PageRank pageRank : pageRanks) {
			
			table.addCell(new Cell(Integer.toString(pageRank.getRank())));
			table.addCell(new Cell(pageRank.getPage()));
		}

		document.add(table);
		
		
	}

	
	
	
	
	
	
	
	
	
	
}
