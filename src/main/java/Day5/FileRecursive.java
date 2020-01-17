package Day5;

/**
 * 指定一个本地路径，从该路径及所有子路径获取所用图片类型文件
 * 得到一个file数组，将其按文件大小排序输出
 * @ClassName FileRecursive
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/1/17
 **/

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class FileRecursive {
    public static void main(String[] args) {
        //封装目录
        File srcFile = new File("D:/1");
        //递归功能实现
        System.out.println("-------------不按大小排序输出------------");
        getAllJavaFilePaths(srcFile);
        System.out.println("--------------按大小排序输出-------------");
        orderByLength(srcFile);
    }

    /**
     * 按文件大小排序输出
     *
     * @param srcFile
     */
    public static void orderByLength(File srcFile) {
        List<File> files = Arrays.asList(new File(String.valueOf(srcFile)).listFiles());
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                long diff = f1.length() - f2.length();
                if (diff > 0) {
                    return 1;
                } else {
                    if (diff == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }

            public boolean equals(Object obj) {
                return true;
            }
        });
        for (File f : files) {
            if (f.isDirectory()) {
                continue;
            }
            System.out.println(f.getAbsolutePath() + ":" + f.length());
        }
    }

    /**
     * 按路径默认文件排序输出（不按文件大小排序输出）
     *
     * @param srcFile
     */
    private static void getAllJavaFilePaths(File srcFile) {        //获取该目录下所有的文件或者文件夹的File数组
        File[] fileArray = srcFile.listFiles();
        //遍历该File数组，得到每一个File对象
        for (File file : fileArray) {
            //判断该File对象是否是文件夹
            if (file.isDirectory()) {
                getAllJavaFilePaths(file);
            } else {
                //继续判断是否是以.png结尾
                if (file.getName().endsWith(".png")) {
                    //就输出该文件的绝对路径
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

}