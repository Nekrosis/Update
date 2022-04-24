import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String create = " Create";
        String dirGame = "/Users/macbookpro/Games";
        StringBuilder stringBuilder = new StringBuilder();
        List<String> listDir = new ArrayList<>();
        listDir.add("temp");
        listDir.add("src");
        listDir.add("res");
        listDir.add("savegames");
        File dir = new File(dirGame);
        if (dir.mkdir()) {
            stringBuilder.append(dir.getName() + create);
            stringBuilder.append("\n");
        }
        for (String s : listDir) {
            File dirs = new File(dirGame, s);
            if (dirs.mkdirs()) {
                stringBuilder.append(dirs.getName() + create);
                stringBuilder.append("\n");
            }
        }
        List<String> resDir = new ArrayList<>();
        resDir.add("drawable");
        resDir.add("vectors");
        resDir.add("icons");
        for (String listRe : resDir) {
            File dirsRes = new File(dirGame + "/res", listRe);
            if (dirsRes.mkdirs()) {
                stringBuilder.append(dirsRes.getName() + create);
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
            File dirsSrc = new File(dirGame + "/src", src);
            if (dirsSrc.mkdirs()) {
                stringBuilder.append(dirsSrc.getName() + create);
                stringBuilder.append("\n");
            }
        }
        File file1 = new File(dirGame + "/src/main", "Main.java");
        File file2 = new File(dirGame + "/src/main", "Utils.java");
        File file3 = new File(dirGame + "/temp", "text.txt");
        List<File> files = new ArrayList<>();
        files.add(file1);
        files.add(file2);
        files.add(file3);
        try {
            for (File file : files) {
                if (file.createNewFile()) {
                    stringBuilder.append(file.getName() + create)
                            .append("\n");
                    FileWriter text = new FileWriter(file3);
                    text.write(String.valueOf(stringBuilder));
                    text.flush();
                    text.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
