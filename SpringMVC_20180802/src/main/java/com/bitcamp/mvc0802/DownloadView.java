package com.bitcamp.mvc0802;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		File file = (File) model.get("downloadFile");
		
		response.setContentType("appliaction/download; charset=utf-8");
		response.setContentLength((int) file.length());
		
		// MSIE 여부 확인 후 파일이름(한글) 인코딩 처리
		String userAgent = request.getHeader("User-Agent");
		
		String fileName = "";
		
		if(userAgent.indexOf("MSIE") > -1) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		
		fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, out);
		
		fis.close();
		out.flush();
		out.close();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
