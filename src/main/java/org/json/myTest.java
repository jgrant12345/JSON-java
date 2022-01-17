package org.json;
import java.io.*;
import java.util.*;

import static org.json.XML.parse;

public class myTest {
//Assumption1: don't have any empty keys, so no /catalog/book//hi or essentially no double slash
   public static void main(String[] args) throws FileNotFoundException {
       File myFile = new File("/Users/justin/IdeaProjects/JSON-java/src/main/java/org/json/sampleXML.xml");
       Reader myReader = new FileReader(myFile);
       JSONObject jo = new JSONObject();
       XMLTokener x = new XMLTokener(myReader);
       while (x.more()) {
           x.skipPast("<");
           if(x.more()) {
//              Idea3: We can start off with the top level. Once we hit the desired object, we can pass in some kind of signal
//              then, when we hit the closing tag of it, then we can print the contents. of course it can be tricky
//              if there's an array. If there's a number passed into keypath, we can look for the nth iteration of that
//              Idea4: For first part: create a current keypath and update that.
//              If that's the same, then we're done. we also need to stop one tag earler, then we can do all of the magic stuff with it
//              For replacement, replace the object when hit the open tag, then call the skippast method skippast(</ +tagName +>
//              then the rest will go well
               parse(x, jo, null, XMLParserConfiguration.KEEP_STRINGS,false, "/contact/address/zipcode", "address", false);
//               System.out.println(jo);
           }

       }
       ;
   }
}
