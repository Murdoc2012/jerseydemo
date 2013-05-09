package sol.neptune;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Closeable;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends HttpServlet {
	
	
	private static final int BUFFER_SIZE = 10240;
	
  protected void doGet(HttpServletRequest request,
	  HttpServletResponse response) throws ServletException, IOException {
	  
	  String filename = "/index.html";
	  ServletContext context = getServletContext();
	  
	  InputStream inp = context.getResourceAsStream(filename);
	  
	  
	  response.reset();
      response.setBufferSize(BUFFER_SIZE);
      response.setContentType(context.getMimeType(filename));
	  
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {

            input = new BufferedInputStream(inp, BUFFER_SIZE);
            output = new BufferedOutputStream(response.getOutputStream(), BUFFER_SIZE);

            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {           
            close(output);
            close(input);
        }
	  
	  }
	  
	    protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException { 
		}
  
  
  private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {               
                e.printStackTrace();
            }
        }
    }
 }
