import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> listDir = new ArrayList<>();
        listDir.add("temp");
        listDir.add("src");
        listDir.add("res");
        listDir.add("savegames");
        File dir = new File("C://Games");
        if (dir.mkdir()) {
            stringBuilder.append(dir.getName() + " - dir create");
            stringBuilder.append("\n");
        }
        for (String s : listDir) {
            File dirs = new File("C://Games", s);
            if (dirs.mkdirs()) {
                stringBuilder.append(dirs.getName() + " - dir create");
                stringBuilder.append("\n");
            }
        }
        List<String> resDir = new ArrayList<>();
        resDir.add("drawable");
        resDir.add("vectors");
        resDir.add("icons");
        for (String listRe : resDir) {
            File dirsRes = new File("C://Games/res", listRe);
            if (dirsRes.mkdirs()) {
                stringBuilder.append(dirsRes.getName() + " - dir create");
                stringBuilder.append("\n");
            }
        }
        List<String> srcDir = new ArrayList<>();
        srcDir.add("main");
        srcDir.add("test");
        List<String> list = new ArrayList<>();
        list.add("Main.java");
        list.add("Utils.java");
        for (String src : srcDir) {
            File dirsSrc = new File("C://Games/src", src);
            if (dirsSrc.mkdirs()) {
                stringBuilder.append(dirsSrc.getName() + " - dir create");
                stringBuilder.append("\n");
            }
        }
        File file1 = new File("C://Games/src/main", "Main.java");
        File file2 = new File("C://Games/src/main", "Utils.java");
        File file3 = new File("C://Games/temp", "text.txt");
        try {
            if (file1.createNewFile()) {
                stringBuilder.append(file1.getName() + " - file create");
                stringBuilder.append("\n");
            }
            if (file2.createNewFile()) {
                stringBuilder.append(file2.getName() + " - file create");
                stringBuilder.append("\n");
            }
            if (file3.createNewFile()) {
                stringBuilder.append(file3.getName() + " - file create");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter text = new FileWriter(file3);
            text.write(String.valueOf(stringBuilder));
            text.flush();
            text.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
