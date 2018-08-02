package com.bitcamp.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class PageRanksView extends AbstractExcelView {
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//1.시트 생성
		HSSFSheet sheet = createFirstSheet(workbook);
		//2.시트의 첫 번째 행의 라벨 작성
		createColumnLabel(sheet);
		// 3. 데이터들을 표현할 행 생성과 셀 생성
		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");
		int rowNum = 1;
		for (PageRank rank : pageRanks) {
			createPageRankRow(sheet, rank, rowNum++);
		}
	}

	//sheet 생성 메서드
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "포털사이트 순위");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}

	//컬럽 라벨 생성
	private void createColumnLabel(HSSFSheet sheet) {
		//행 생성
		HSSFRow firstRow = sheet.createRow(0);
		
		//셀 생성
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("순위");
		cell = firstRow.createCell(1);
		cell.setCellValue("포털사이트");
	}
	
	// 데이터 출력 행 생성
	private void createPageRankRow(HSSFSheet sheet, PageRank rank, int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(rank.getRank());
		cell = row.createCell(1);
		cell.setCellValue(rank.getPage());
	}

}