package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.file.FileDAO;
import com.itbank.file.FileDTO;

@Service
public class FileService {

	@Autowired private FileDAO dao;
	
	private String uploadPath = "c:\\upload";
	
	private File dir;
	
	public FileService() {
		dir = new File(uploadPath);
		if(dir.exists() == false) {
			dir.mkdir();
		}
	}

	public boolean upload(MultipartFile file) throws IllegalStateException, IOException {
		
		File dest = new File(dir, file.getOriginalFilename());
		
		file.transferTo(dest);
		
		// return 값이 boolean -> true or fasle
		// dest.isFile() : dest가 file인지 확인
		// dest.exist() : dest가 존재하는지 확인
		// 즉, 둘다 true라면 true를 반환 하나라도 false라면 false를 반환

		return dest.exists() && dest.isFile();
	}

	public int upload2(FileDTO dto) throws IllegalStateException, IOException {
		
//		uploadPath = request.getSession().getServletContext().getRealPath("/upload");
//		dir = new File(uploadPath);
//		if(dir.exists() == false) {
//			dir.mkdir();
//		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		
		
		String fileName = dto.getUploadFile().getOriginalFilename();
		
		System.out.println(fileName);
		
		String [] p = fileName.split("\\.");
		
		for(String s : p) {
			System.out.print(s + "\n");
		}
		
		
		String fN = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
		
		
		
		fileName = today + "_" + fN + "." + p[1];
		
		
		File dest = new File(dir, fileName);
		dto.getUploadFile().transferTo(dest);
		dto.setFileName(fileName);
		
		int row = dao.upload2(dto);
		
		return row;
	}

	public List<FileDTO> selectList() {
		List<FileDTO> list = dao.selectList();
		return list;
	}
	
	
}
