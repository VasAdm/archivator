import java.io.*;
import java.nio.file.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FilesExamples {
    //Чтение из файла
    public static String readingFile(Path path)  {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            return e.getMessage();
        }
    }
    //Запись в файл
    public static void writingFile(Path path, String text, OpenOption option) {
        try {
            Files.writeString(path, text, option);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Архивировать файл
    public static void archivingFile(Path input, Path output) {
        try {
            FileOutputStream outputStream = new FileOutputStream(output.toString());
            ZipOutputStream zipOut = new ZipOutputStream(outputStream);
            ZipEntry entry = new ZipEntry(input.getFileName().toString());
            zipOut.putNextEntry(entry);
            byte[] data = Files.readAllBytes(input);
            zipOut.write(data);
            zipOut.finish();
            zipOut.close();
            outputStream.close();
        }catch (IOException ex) {ex.printStackTrace();}
    }
    //Архивировать несколько файлов
    public static void archivingAllFiles(Path[] input, Path output) {
        try {
            FileOutputStream outputStream = new FileOutputStream(output.toString());
            ZipOutputStream zipOut = new ZipOutputStream(outputStream);
            for (Path fileName : input) {
                ZipEntry entry = new ZipEntry(fileName.getFileName().toString());
                zipOut.putNextEntry(entry);
                byte[] data = Files.readAllBytes(fileName);
                zipOut.write(data);
            }
            zipOut.finish();
            zipOut.close();
            outputStream.close();
        }catch (IOException ex) {ex.printStackTrace();}
    }
    //Архивировать дирректорию
    public static void archivingDir(Path input, Path output) {
        try {
            FileOutputStream outputStream = new FileOutputStream(output.toString());
            ZipOutputStream zipOut = new ZipOutputStream(outputStream);
            writeFileToZip(
                    new File(input.toString()),
                    zipOut,
                    ""
            );
            zipOut.finish();
            zipOut.close();
            outputStream.close();
        }catch (IOException ex) {ex.printStackTrace();}
    }
    //Архивировать дирректорию(additional)
    private static void writeFileToZip(File file, ZipOutputStream zipOut, String path) throws IOException {
        if (file.isDirectory()) {
            String folder = path + file.getName() + "/";
            ZipEntry entry = new ZipEntry(folder);
            zipOut.putNextEntry(entry);
            zipOut.closeEntry();
            File[] files = file.listFiles();
            for (File fl : Objects.requireNonNull(files)) {
                writeFileToZip(fl, zipOut, folder);
            }
            return;
        }

        ZipEntry entry = new ZipEntry(path + file.getName());
        zipOut.putNextEntry(entry);
        byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        zipOut.write(bytes);
    }
    //Разархивировать файл
    public static void extractingDir(String input, String output) throws IOException {
        FileInputStream inputStream = new FileInputStream(input);
        ZipInputStream zipInput = new ZipInputStream(inputStream);
        while (true) {
            ZipEntry entry = zipInput.getNextEntry();
            if (entry == null) {
                break;
            }
            File file = new File(output + entry.getName());
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                byte[] bytes = zipInput.readAllBytes();
                Files.write(
                        Paths.get(file.getAbsolutePath()),
                        bytes,
                        StandardOpenOption.CREATE);
            }
        }
    }
}