
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import redis.clients.jedis.Jedis;

/**
 *
 * @authors Harry Kapnas,Konstantinos Chronis
 */
public class Feeder {
    
    Reader rd;
    String ttl;
    ArrayList<String> atts; 
    ArrayList<String[]> vals;
    Jedis jedis;
    
    String path;

    public Feeder() throws IOException{
    	path = new UserInput().inputInterface();
        rd = new Reader(path);
        jedis = jediConnector();
        ttl=rd.getTitle();
        atts = rd.getAttributes();
        vals = rd.getValues();
    }
    
    //Class that handles connection with Redis Server
    private Jedis jediConnector(){
        jedis = new Jedis("localhost");
        System.out.println("Connection Established");
        System.out.println("Pinging Server...");
        System.out.println("Server Replies: "+jedis.ping());
        System.out.println("======================");
        return jedis;
    }
    
    //The main class that passes the key value hashes to Redis
    public void setKeyValues() throws IOException{        
        LinkedHashMap<String, String> propertiesMap = new LinkedHashMap<>();
        
        System.out.println("Initating Input:");
        for (String[] val : vals) {
            for (int j = 0; j<atts.size(); j++) {
                String[] tmp = val;
                propertiesMap.put(atts.get(j), tmp[j]);                
            }
            jedis.hmset(ttl+":" + val[0], propertiesMap);
            propertiesMap.clear();
        }
        System.out.println("Process Completed.");
        System.out.println("======================");
    }
    
    //Class to get back key values
    public void valuesPrinter(String key){
        for (int i=0;i<atts.size();i++) {
            System.out.println( jedis.hget(key, atts.get(i)));
        }
    }
    
}
