import java.io.*;
import java.text.*;
import java.util.*;

public class QueryPro {

  public static void main(String[] args) throws Exception {

	  FileInputStream is = new FileInputStream("Query.txt");
	  InputStreamReader Rdr = new InputStreamReader(is);
	  BufferedReader buf = new BufferedReader(Rdr);
	  //String inputLine = buf.readLine();
	 // int n =  Integer.parseInt(inputLine);

	  FileOutputStream outFile = new FileOutputStream("query.java");
	  OutputStreamWriter outStream = new OutputStreamWriter(outFile);
	  BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outFile));

      out.write("import java.io.*;\n");
      out.write("import java.text.*;\n");
      out.write("import java.util.*;\n");
      out.write("import redis.clients.jedis.Jedis;\n\n");
      out.write("public class QueryPro {\n");
      out.write("  public static void main(String[] args) throws Exception {\n");
      out.write("	  Jedis jedis = new Jedis(\"localhost\", 6379);\n");
      
      out.write("	  String line1 = br.readLine().trim();\n");
      out.write("	  String line2 = br.readLine().trim();\n");
      out.write("	  String line3 = br.readLine().trim();\n");
      
      
      for (int i=0; i<4; i++) {
		  out.write("      for (int k_"+i+"=0; k_"+i+" < 100; k_"+i+"++) {\n");
	  }
	  out.write("        // check here and print\n");
	  for (int i=0; i<4; i++) {
		  out.write("      }\n");
	  }
      out.write("  } // of main\n");
      out.write("} // of program\n");

	  out.close();
	  outStream.close();
	  outFile.close();


  }  // of main

}  // of class
