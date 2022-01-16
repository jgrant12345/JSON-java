package org.json;
import java.io.*;
import java.util.*;

import static org.json.XML.parse;

public class myTest {
//Assumption1: don't start keypath with a /
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
//
               parse(x, jo, null, XMLParserConfiguration.KEEP_STRINGS,false, "catalog", "catalog");
//               System.out.println(jo);
           }

       }
       ;
   }
}
