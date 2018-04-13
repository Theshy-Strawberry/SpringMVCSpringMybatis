package ctrl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class Upload {
	@RequestMapping("/upload")
	public String insert(HttpServletRequest request) throws IOException {
		String mm=request.getParameter("filename");
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		MultipartFile file = mrequest.getFile("file");
		String fileName = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String path=System.getProperty("user.dir")+"\\upload\\"+fileName;
		FileOutputStream fos = new FileOutputStream(path
			);
		fos.write(file.getBytes());
		fos.flush();
		fos.close();
		return "homepage";
	}
}
