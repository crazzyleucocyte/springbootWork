package com.study.springboot.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@Controller
public class FileUploadController {

	@RequestMapping("/")
	public String root() {
		return"fileForm";
	}

	@RequestMapping("/fileUpload")
	public @ResponseBody String fileUpload(HttpServletRequest request) {
		JSONObject jObj = new JSONObject();
		try {
			//파일을 저장할 위치의 절대경로를 얻어오는 코드
			String filePath=ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
			System.out.println("파일 저장 위치 : "+filePath);

			//읽은 파일을 리스트화 시킴
			List<Part> fileParts = request.getParts()
										  .stream()
										  .filter(part -> "files".equals(part.getName()) && part.getSize()>0)	//part.getName()의 getName은 파일명을 뜻하는것이 아니라 input의 name을 뜻하는것으로 넘어올때는 'input의 name':'파일명'으로 들어온다.
										  .collect(Collectors.toList());
			/*
			 * request.getParts(): 이 메서드는 multipart/form-data 요청의 모든 파트를 가져옵니다. 파일 업로드의 경우, 각 파일과 다른 폼 데이터가 Part 객체로 표현됩니다.

				.stream(): Part 객체들의 컬렉션을 스트림으로 변환하여, 필터링 및 수집과 같은 함수형 스타일의 작업을 수행할 수 있게 합니다.
				
				.filter(part -> "files".equals(part.getName()) && part.getSize() > 0): 스트림에서 다음 조건을 만족하는 파트들만 필터링합니다:
													part.getName()의 getName은 파일명을 뜻하는것이 아니라 input의 name을 뜻하는것으로 넘어올때는 'input의 name':'파일명'으로 들어온다.
																						넘어오는 input의 이름이 files인 경우 필터링한다
																						파트의 크기가 0보다 큰 경우, 즉 빈 파일이 아닌 경우.
				.collect(Collectors.toList()): 필터링된 파트들을 다시 리스트로 수집합니다.
			*/
			//파일이 여러개 일떄
			for(Part filePart : fileParts) {
				//파일이름 얻어오기
				//Paths.get(filePart.getSubmittedFileName() 서브밋된 파일을 가져오는 코드
				String fileName = Paths.get(filePart.getSubmittedFileName())
									   .getFileName().toString();
				String fpn = filePath + "\\" + fileName;

				
				try(	BufferedInputStream fin = new BufferedInputStream(filePart.getInputStream());
						BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(fpn))){
						//위에 new BufferedOutputStream(new FileOutputStream(fpn))안에 fpn이라는 경로가 지정되어있어서 write만 하면 저장이 된다.

					//파일을 읽어오는 부분 .read가 -1이면 해당 파일을 다 읽었다는 뜻
					int data;
					while(true) {
						data= fin.read();
						System.out.println(data);
						if(data ==-1)
							break;
						fout.write(data);		//가져온 데이터를 저장하는 부분
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println("Upload fileName : " + fpn);

			}
			//result ="success";
			jObj.put("success", "ok");
			jObj.put("fileupload", "파일 업로드 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			result="fail";
			jObj.put("success", "no");
			jObj.put("fileupload", "파일 업로드 실패");
		}
		return jObj.toJSONString();
	}

}
