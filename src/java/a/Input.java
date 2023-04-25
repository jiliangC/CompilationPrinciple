package a;

import java.io.*;

import static a.SyntaxAnalyzer.map_s2i;

public class Input {
    public static Production[] productions = new Production[200]; // 产生式数组

    public static void main(String[] args) throws IOException {
        readToBuffer();
        System.out.println(1);
    }


    public static void readToBuffer() throws IOException {
        int cnt = 0;
        String filepath = "D:\\Users\\13270\\Documents\\JavaProject\\SyntaxAnalyzer\\file\\grammar.txt";
        InputStream is = new FileInputStream(filepath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            String[] split = line.split("->");
            String s = split[0];
            String[] s1 = split[1].split(" ");
            for (int i = 0; i < s1.length; i++) {
                if (s1[i].length() == 1 && ((s1[i].charAt(0) >= 'A' && s1[i].charAt(0) <= 'Z')||s1[i].equals("ε"))) {

                } else {
                    s1[i] = String.valueOf(map_s2i.get(s1[i]));
                }
            }

            productions[cnt++] = new Production(s, s1, line);
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }

    public static class Production {
        String l_str;
        String[] r_str;
        String prod;

        public Production(String l_str, String[] r_str, String prod) {
            this.l_str = l_str;
            this.r_str = r_str;
            this.prod = prod;
        }
    }

}
