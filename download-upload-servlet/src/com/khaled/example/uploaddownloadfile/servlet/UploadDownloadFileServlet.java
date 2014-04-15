package com.khaled.example.uploaddownloadfile.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadDownloadFileServlet
 */
@WebServlet("/updownload.do")
public class UploadDownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletFileUpload uploader = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDownloadFileServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// Wenn die Datei klein ist dann wird sie in Memory geladen amsonsten auf Disk
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		//die hochgeladene Dateien sollen in diesem Folder gespeichert als tmp files
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName= request.getParameter("fileName");
		
		if((fileName==null) || (fileName.equals(""))){
			throw new ServletException("File name can not be null or empty");
		}
		
		File file = new File(getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
		
		if(!file.exists()){
			throw new ServletException("FIle does not exists on Server");
		}
		
		ServletContext ctx = getServletContext();
		ServletOutputStream outst = response.getOutputStream();
		
		String mimeType = ctx.getMimeType(file.getAbsolutePath());
		
		response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		InputStream ips = new FileInputStream(file);
		
		
		int read = 0;
		byte[] bufferData = new byte[1024];
		
		while((read = ips.read(bufferData)) != -1 ){
			outst.write(bufferData, 0, read);
		}
		
		ips.close();
		
		outst.flush();
		outst.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head></head><body>");
		
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			
			out.println("<table border=\"1\">");
			while(fileItemsIterator.hasNext()){
				out.println("<tr>");
				FileItem fileItem = fileItemsIterator.next();
				out.println("<td>File");
				out.println("</td>");
				out.println("<td>");
				out.println("<br>FieldName= " + fileItem.getFieldName());
				out.println("<br>FileName= " + fileItem.getName());
				out.println("<br>ContentType= " + fileItem.getContentType());
				out.println("<br>Size in bytes= " + fileItem.getSize());
				
				File file = new File(getServletContext().getAttribute("FILES_DIR") + File.separator + fileItem.getName());
				
				if(file.exists()){
					file.delete();
					file = new File(getServletContext().getAttribute("FILES_DIR") + File.separator + fileItem.getName());
				}
				
				System.out.println("Absolute path at server= " + file.getAbsolutePath());
				
				//schreibt die datei auf disk mit dem richtigen Name
				fileItem.write(file);
				out.write("<br>* File mit diesem Name " + fileItem.getName() + " uploaded successfully.");
				out.write("<br><a href=\"updownload.do?fileName=" + fileItem.getName()+"\">Download " + fileItem.getName() +"</a>");
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (FileUploadException e) {
			out.write("Exception in uploading file.");
		} catch (Exception e) {
			out.write("Exception in uploading file.");
		}
		out.write("</body></html>");
	}

}
