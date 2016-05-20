import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseURL {
	   public static void main(String[] args) throws Exception {
		   ParseURL parseURL=new ParseURL();
		   URL myURL = new URL("http://www.cprogramming.com/advtutorial.html");
		   
		   System.out.println("URL is " + myURL.toString());
	        System.out.println("protocol = " + myURL.getProtocol());
	        System.out.println("authority = " + myURL.getAuthority());
	        System.out.println("host = " + myURL.getHost());
	        System.out.println("port = " + myURL.getPort());
	        System.out.println("path = " + myURL.getPath());
	        System.out.println("query = " + myURL.getQuery());
	        System.out.println("filename = " + myURL.getFile());
	        System.out.println("ref = " + myURL.getRef());
	        
	        parseURL.getHTML(myURL);   
	       
	    } //end main method
public String getHTML(URL myURL){
	String httpResponce = "";
    try
    {
       URLConnection urlConnection = myURL.openConnection();
       HttpURLConnection connection = null;
       if(urlConnection instanceof HttpURLConnection)
       {
          connection = (HttpURLConnection) urlConnection;
       }
       else
       {
          System.out.println("Please enter an HTTP URL.");
          return null;
       }
       BufferedReader in = new BufferedReader(
       new InputStreamReader(connection.getInputStream()));
       
       String current;
       while((current = in.readLine()) != null)
       {
    	  if(current.contains("<img ") || current.contains("<a href"))
          httpResponce += current +"\n";
       }
       System.out.println(httpResponce);
       
       
       
    }catch(IOException e)
    {
       e.printStackTrace();
    }
	return httpResponce;
	
}
}
