package java.app;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTransfer{
    public static void main(String[] args) throws IOException{
        String path = System.getProperty("user.dir");
        File file = new File(path);
        File[] fileList = file.listFiles();
        String separator = FileSystems.getDefault().getSeparator();
        if (fileList!=null){
            for (int i=0;i<fileList.length;i++){
                File f = fileList[i];
                String str = f.getName();
                Pattern cp = Pattern.compile("\\.exe$");
                Matcher mp = cp.matcher(str);

                if (!mp.find()){
                    Pattern p = Pattern.compile("\\.DNG$");
                    Matcher m = p.matcher(str);

                    if (m.find()){
                        try{
                            Path sourcePath = Paths.get(path+separator+str);
                            Path targetPath = Paths.get(".."+separator+"DNG"+separator+str);
                            Files.move(sourcePath,targetPath);
                            System.out.println("DNG");
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    } else {
                        try{
                            Path sourcePath = Paths.get(path+separator+str);
                            Path targetPath = Paths.get(".."+separator+"DCIM"+separator+str);
                            Files.move(sourcePath, targetPath);
                            System.out.println("JPG");
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}