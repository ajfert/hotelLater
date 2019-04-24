package web.servlet.user;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bdqn.service.UserService;

@WebServlet("/addUpictureServlet")
public class AddUpictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uploadFileName = null;
		int uid =0;
		//上传路径
		String uploadFilePath = request.getSession().getServletContext()
				.getRealPath("upload/");
		/*
		 * E:\eclipse\workspace\.metadata\\ .  plugins\org.eclipse.wst.server.core\tmp1\ wtpwebapps\Hotel\ upload\
		 */
		 System.out.println(uploadFilePath);
		File savedir = new File(uploadFilePath);
		//如果不存在就创建
		if(!savedir.exists()){
			savedir.mkdir();
		}
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items;
			try {
				items = upload.parseRequest(request);
				Iterator<FileItem> ite = items.iterator();
				while(ite.hasNext()){
					FileItem item = ite.next();
					if(item.isFormField()){
						String fieldName = item.getFieldName();
						if(fieldName.equals("uid")){
							String id = item.getString();
							if(id!=null&&!id.equals("")){
								uid = Integer.parseInt(id);
							}
						}
						
					}else{
						String fileName = item.getName();
						if(fileName!=null&&!fileName.equals("")){
							File fullFile = new File(item.getName());
							File saveFile = new File(uploadFilePath,fullFile.getName());
							try {
								item.write(saveFile);
							} catch (Exception e) {
								e.printStackTrace();
							}
							uploadFileName = fullFile.getName();
						}
					}
				}
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			}
		}
		UserService us = new UserService();
		boolean b = us.changePicById(uid, uploadFileName);
		if(b) {
			System.out.println(11);
			//response.sendRedirect("/show.jsp");
		}else {
			System.out.println(222);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public Date strtodate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
