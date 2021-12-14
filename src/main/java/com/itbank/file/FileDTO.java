package com.itbank.file;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

//idx             number          default GALL_SEQ.nextval primary key,
//name            varchar2(500)   not null,
//writer          varchar2(1000)  CONSTRAINT member_gall_fk REFERENCES member(userid) on delete set null,
//description     varchar2(2000)  not null,
//filename        varchar2(1000)  not null,
//writeDate       date            default sysdate

public class FileDTO {

	private int idx;
	private String name;
	private String writer;
	private String description;
	private Date writeDate;
	// input name="uploadFile"
	private MultipartFile uploadFile;
	// getName() 함수가 파일의 이름을 반환하도록 설정
	private String fileName;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

	
	
}
