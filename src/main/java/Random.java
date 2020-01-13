import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Random
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/1/13
 * 随机生成随机数，写入数组，并存储到本地
 **/
public class Random {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            int temp = (int) (Math.random() * 100);
            list.add(temp);
        }
        File file = new File("D:/Random.txt");
        if (!file.exists()) {
            System.out.println("正在创建...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("创建成功！");
        } else {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.valueOf(list)+"\t");
            fileWriter.close();
            System.out.println("写入成功！");
        }

    }


}