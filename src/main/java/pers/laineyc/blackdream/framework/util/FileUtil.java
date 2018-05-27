package pers.laineyc.blackdream.framework.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import java.io.InputStream;
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

}