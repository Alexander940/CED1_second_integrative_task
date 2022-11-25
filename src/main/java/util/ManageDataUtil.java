package util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ManageDataUtil {

      public static String getPositionsGraph(){
            String file = "./src/main/resources/position_nodes_graph.txt";
            try {
                  FileInputStream fis = new FileInputStream(file);
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();

                  byte[] buffer = new byte[3];
                  int bytesQuePudeLeer = 0;

                  while((bytesQuePudeLeer = fis.read(buffer)) != -1){
                        baos.write(buffer, 0, bytesQuePudeLeer);
                  }
                  fis.close();
                  baos.close();

                  String read = baos.toString();
                  return read;
            } catch(IOException ex) {
                  ex.printStackTrace();
                  return null;
            }
      }

      public static String getEdgesGraph(){
            String file = "./src/main/resources/adjacency_graph.txt";
            try {
                  FileInputStream fis = new FileInputStream(file);
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();

                  byte[] buffer = new byte[3];
                  int bytesQuePudeLeer = 0;

                  while((bytesQuePudeLeer = fis.read(buffer)) != -1){
                        baos.write(buffer, 0, bytesQuePudeLeer);
                  }
                  fis.close();
                  baos.close();

                  String read = baos.toString();
                  return read;
            } catch(IOException ex) {
                  ex.printStackTrace();
                  return null;
            }
      }
}
