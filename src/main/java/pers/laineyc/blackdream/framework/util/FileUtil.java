package pers.laineyc.blackdream.framework.util;

import org.apache.commons.io.IOUtils;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author LaineyC
 */
public final class FileUtil {

    private static final Charset CHARSET = Charset.forName("UTF-8");

    public static void create(Path path) {
        if(!Files.exists(path)){
            try {
                Files.createDirectories(path);
            }
            catch (Exception e){
                throw new BusinessException(e, "创建失败");
            }
        }
    }

    public static boolean exists(Path path) {
       return Files.exists(path);
    }

    public static void delete(Path path) {
        try {
            Files.deleteIfExists(path);
        }
        catch (Exception e){
            throw new BusinessException(e, "删除失败");
        }
    }

    public static void write(Path path, InputStream inputStream) {
        try {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            Files.write(path, bytes);
        }
        catch (Exception e){
            throw new BusinessException(e, "创建失败");
        }
    }

    public static InputStream read(Path path) {
        try {
            return Files.newInputStream(path);
        }
        catch (Exception e){
            throw new BusinessException(e, "读取失败");
        }
    }

    public static void writeString(Path path, String content) {
        try {
            byte[] bytes = content.getBytes(CHARSET);
            Files.write(path, bytes);
        }
        catch (Exception e){
            throw new BusinessException(e, "创建失败");
        }
    }

    public static String readString(Path path) {
        try {
            return IOUtils.toString(Files.newInputStream(path), CHARSET);
        }
        catch (Exception e){
            throw new BusinessException(e, "读取失败");
        }
    }


    public static void mkdirs(String path){
        File pathFile = new File(path);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
    }

    public static boolean deleteFile(File deleteFile){
        File[] files = deleteFile.listFiles();
        if(files != null) {
            for(int i = 0 ; i < files.length ; i++) {
                File file = files[i];
                if(file.isDirectory()) {
                    FileUtil.deleteFile(file);
                }
                else {
                    if(file.delete()){

                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return deleteFile.delete();
    }

    public static boolean deleteFile(File deleteFile, boolean delete){
        File[] files = deleteFile.listFiles();
        if(files != null) {
            for(int i = 0 ; i < files.length ; i++) {
                File file = files[i];
                if(file.isDirectory()) {
                    FileUtil.deleteFile(file, true);
                }
                else {
                    if(file.delete()){

                    }
                    else {
                        return false;
                    }
                }
            }
        }
        if(delete){
            return deleteFile.delete();
        }
        else{
            return true;
        }
    }

    public static void copyFile(File source, File target) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(source);
            fo = new FileOutputStream(target);
            in = fi.getChannel();
            out = fo.getChannel();
            in.transferTo(0, in.size(), out);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(fi != null){
                    fi.close();
                }
                if(in != null){
                    in.close();
                }
                if(fo != null){
                    fo.close();
                }
                if(out != null){
                    out.close();
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}