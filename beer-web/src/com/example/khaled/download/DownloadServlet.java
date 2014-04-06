package com.example.khaled.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/zip");
		
		ServletContext ctx = getServletContext();
		FileInputStream is = (FileInputStream) ctx.getResourceAsStream("/test.zip");
		
		int read = 0;
		byte[] bytes = new byte[4500];
		
		OutputStream os = response.getOutputStream();
		
		StringBuilder type = new StringBuilder("attachment; filename=newTest.zip");
        response.setHeader("Content-Disposition", type.toString());
		
		while((read=is.read(bytes)) != -1){
			os.write(bytes, 0, read);
			System.out.println("reading " );
		}
		
		os.flush();
		os.close();
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
