/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;





/**
 *
 * @author MylesMack
 */
public class API {
    
    public String pubRec;


    static Scanner jin=new Scanner(System.in);
    
    public static String callURL(String myURL) {
		//System.out.println("Requested URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 
		return sb.toString();
	}
    
    public static void Reviews(String PR)
    {
        String review = callURL("http://api.walmartlabs.com/v1/reviews/"+PR+"?apiKey=93dks62dn7yauy49e66e2ctd");

        int locR, locR2;
        String parseR, parseR2;
        locR = review.indexOf("]");
        parseR = review.substring(locR+1);
        parseR2 = parseR;
        locR = parseR.indexOf("{");
        
        review = parseR.substring(0,locR);
        
        parseR = parseR.substring(locR+1);
        //System.out.println(review);
        if (review.equals(",\"reviewStatistics\":"))
        {
            locR = review.indexOf("{");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf(":");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf("\"");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf("\"");
            review = parseR.substring(0, locR);
            System.out.println(review);
            
        }
        else
        {
            while(!review.equals(",\"reviewStatistics\":"))
            {
                int loc;
                
                
                
                loc = parseR2.indexOf("]");
                parseR2 = parseR2.substring(loc+1);
                loc = parseR2.indexOf("{");
                review = parseR2.substring(0,loc);
                parseR2 = parseR2.substring(loc+1);

                
                //System.out.println(parseR2);
                //System.out.println(review);
        
        /*    System.out.println("true");
            System.out.println(parseR);
            review = ",\"reviewStatistics\":";*/
            }
            locR = review.indexOf("{");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf(":");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf("\"");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf("\"");
            review = parseR.substring(0, locR);
            System.out.println("Rating: " + review);
            
            
        }
        //return System.out.println("Rating: " + review);
    }
    
   /* public static String ProductRecommendation(String result)
    {
        //Retrieving the first 10 recommendations
        int locID;
        int count = 1;
       
        int locPR;
        String parsePR, parsePR2, resultPR, description;
        String PR, PR2, PR3, PR4, PR5, PR6, PR7, PR8, PR9, PR10; 
        locPR = result.indexOf(':');
        parsePR = result.substring(0,locPR);
        resultPR = result.substring(locPR+1);
        locPR = resultPR.indexOf(',');
        PR = resultPR.substring(0,locPR);
        description = resultPR;
        System.out.println(PR);
        
        while(count<10)
        //for(int count = 1; count>11; count++)
        {
            locPR = resultPR.indexOf(']');
        //parsePR = resultPR.substring(0,locPR);
            parsePR = resultPR.substring(locPR+1);
            locPR = parsePR.indexOf('{');
            parsePR = parsePR.substring(locPR+1);
            locPR = parsePR.indexOf(':');
            parsePR = parsePR.substring(locPR+1);
            locPR = parsePR.indexOf(',');
            count++;
            if(count==2)
            {
                PR2 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR2);
            }
            if(count==3)
            {
                PR3 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR3);
            }
            if(count==4)
            {
                PR4 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR4);
            }
            if(count==5)
            {
                PR5 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR5);
            }
            if(count==6)
            {
                PR6 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR6);
            }
            if(count==7)
            {
                PR7 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR7);
            }
            if(count==8)
            {
                PR8 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR8);
            }
            if(count==9)
            {
                PR9 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR9);
            }
            if(count==10)
            {
                PR10 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println(PR10);
            }
        
        }
        return result;
       
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String item;
        System.out.println("What item are you searching for?");
        item = jin.next();
        //System.out.println("\nOutput: \n" + callURL("http://api.walmartlabs.com/v1/search?apiKey=93dks62dn7yauy49e66e2ctd&lsPublisherId={Your%20LinkShare%20Publisher%20Id}&query="+item));
        String result = callURL("http://api.walmartlabs.com/v1/search?apiKey=93dks62dn7yauy49e66e2ctd&lsPublisherId={Your%20LinkShare%20Publisher%20Id}&query="+item);
        //System.out.println("You're result is " + result);
        
        
        //Retrieving the itemID
        int locID;
        String parse1, parse2, itemID;
        locID=result.indexOf('[');
        parse1 = result.substring(0,locID);
        parse2 = result.substring(locID+1);
       
        locID = parse2.indexOf(':');
        parse1 = parse2.substring(locID+1);
        
        locID = parse1.indexOf(',');
        itemID = parse1.substring(0,locID);
        
        result = callURL("http://api.walmartlabs.com/v1/nbp?apiKey=93dks62dn7yauy49e66e2ctd&itemId="+itemID);
        //System.out.println("You're result is " + result);
        
        //Retrieving the first 10 recommendations
        
        int count = 1;
        String i ="1";
      
        int locPR;
        String parsePR, parsePR2, resultPR, description, pubRec;
        String PR, PR2, PR3, PR4, PR5, PR6, PR7, PR8, PR9, PR10;
        
        
        locPR = result.indexOf(':');
        parsePR = result.substring(0,locPR);
        resultPR = result.substring(locPR+1);
        locPR = resultPR.indexOf(',');
        PR = resultPR.substring(0,locPR);
        description = resultPR;
        System.out.println("Item #1: " + PR);
        Reviews(PR);
        
        //System.out.println(PR);

         /*String review = callURL("http://api.walmartlabs.com/v1/reviews/"+PR+"?apiKey=93dks62dn7yauy49e66e2ctd");

        int locR, locR2;
        String parseR, parseR2;
        locR = review.indexOf("]");
        parseR = review.substring(locR+1);
        parseR2 = parseR;
        locR = parseR.indexOf("{");
        
        review = parseR.substring(0,locR);
        
        parseR = parseR.substring(locR+1);
        //System.out.println(review);
        if (review.equals(",\"reviewStatistics\":"))
        {
            locR = review.indexOf("{");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf(":");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf("\"");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf("\"");
            review = parseR.substring(0, locR);
            System.out.println(review);
            
        }
        else
        {
            while(!review.equals(",\"reviewStatistics\":"))
            {
                int loc;
                
                
                
                loc = parseR2.indexOf("]");
                parseR2 = parseR2.substring(loc+1);
                loc = parseR2.indexOf("{");
                review = parseR2.substring(0,loc);
                parseR2 = parseR2.substring(loc+1);

                
                //System.out.println(parseR2);
                //System.out.println(review);
        
        /*    System.out.println("true");
            System.out.println(parseR);
            review = ",\"reviewStatistics\":";
            }
            locR = review.indexOf("{");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf(":");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf("\"");
            parseR = parseR.substring(locR+1);
            locR = parseR.indexOf("\"");
            review = parseR.substring(0, locR);
            System.out.println(review);
            
            
        }
        */
        
        while(count<10)
        //for(int count = 1; count>11; count++)
        {
            locPR = resultPR.indexOf(']');
        //parsePR = resultPR.substring(0,locPR);
            parsePR = resultPR.substring(locPR+1);
            locPR = parsePR.indexOf('{');
            parsePR = parsePR.substring(locPR+1);
            locPR = parsePR.indexOf(':');
            parsePR = parsePR.substring(locPR+1);
            locPR = parsePR.indexOf(',');
            count++;
            if(count==2)
            {
                PR2 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #2: " + PR2);
                Reviews(PR2);
            }
            if(count==3)
            {
                PR3 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #3: " + PR3);
                Reviews(PR3); 
            }
            if(count==4)
            {
                PR4 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #4: " + PR4);
                Reviews(PR4);
            }
            if(count==5)
            {
                PR5 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #5: " + PR5);
                Reviews(PR5);
            }
            if(count==6)
            {
                PR6 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #6: " + PR6);
                Reviews(PR6);
            }
            if(count==7)
            {
                PR7 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #7: " + PR7);
                Reviews(PR7);
            }
            if(count==8)
            {
                PR8 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #8: " + PR8);
                Reviews(PR8);
            }
            if(count==9)
            {
                PR9 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #9: " + PR9);
                Reviews(PR9);
            }
            if(count==10)
            {
                PR10 = parsePR.substring(0,locPR);
                resultPR = parsePR.substring(locPR+1);
                System.out.println("Item #10: " + PR10);
                Reviews(PR10);
                pubRec = PR10;
            }
            
            
        
        }
        
        
        //Reviews for the 10 Product Recommendations
        
       
       // System.out.println(review);
       // System.out.println(parseR);
          
        
        
        // TODO code application logic here
    }

    /*private static String ProductRecommendation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
