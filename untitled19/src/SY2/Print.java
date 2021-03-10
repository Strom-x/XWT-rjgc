package SY2;

import java.io.*;

public class Print {
    public void print() throws IOException {
        //读取文件
        FileInputStream in = new FileInputStream("yq_in.txt");
        //防止出现中文乱码
        InputStreamReader inReader = new InputStreamReader(in, "GBK");
        BufferedReader bufRader = new BufferedReader(inReader);

        int flag = 0;  //标志。
        String pro = null;
        StringBuffer result = new StringBuffer();
        String str = null;
        //按行读取且分类。
        while ((str = bufRader.readLine()) != null) {
            //按空格分隔。
            String[] line = str.split("\\s");

            //分类。
            if (!line[2].equals("0")) {
                if (flag == 0) {
                    pro = line[0];
                    result.append(pro + '\n');
                    result.append(line[1] + "  \t" + line[2] + '\n');
                    flag = 1;
                } else {

                    if (pro.equals(line[0])) {
                        result.append(line[1] + "  \t" + line[2] + '\n');
                    } else {
                        pro = line[0];
                        result.append("\n");
                        result.append(pro + "\n");
                        result.append(line[1] + "  \t" + line[2] + "\n");
                    }
                }
            }
        }
        bufRader.close();

        //在控制台调试输出观察结果。
        System.out.println(result);

        //输出文件。
        FileWriter writer;
        try {
            writer = new FileWriter("yq_out.txt");
            writer.write(result.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
