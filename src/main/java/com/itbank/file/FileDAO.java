package com.itbank.file;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface FileDAO {

	int upload2(FileDTO dto);

	@Select("select * from gallery3 order by idx desc")
	List<FileDTO> selectList();

}
