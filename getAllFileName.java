import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

class GetAllFileNames{
    
    private static String getExtension(String filename){
        int extIndex = filename.lastIndexOf(".") + 1;
        return filename.substring(extIndex);
    }

    public static void main(String[] args) throws IOException{
        String downloadsPath = System.getProperty("user.home") + "/Downloads/";
        File folder = new File(downloadsPath);
        File[] filelist = folder.listFiles();

        for(int i = 0; i < filelist.length; i++){
            if(filelist[i].isFile()){
                String filename = filelist[i].getName();
                String directoryName = getExtension(filename);
                new File(downloadsPath + directoryName + "/").mkdir();
                Path source = Paths.get(downloadsPath + filename);
                Path target = Paths.get(downloadsPath + directoryName + "/" + filename);
                Files.move(source, target);
            }
        }
    }

}
