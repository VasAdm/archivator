import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    private static final String FolderName = "./Data/";

    public static void main(String[] args) {

        try {
////Чтение из файла
//            Path sourceReading = Paths.get(FolderName + "switches.log.txt");
//            System.out.println(FilesExamples.readingFile(sourceReading));
////Запись в файл
//            Path destinationWriting = Paths.get(FolderName + "testText.txt");
//            FilesExamples.writingFile(destinationWriting, "Test two\nLine2", StandardOpenOption.CREATE);
////Архивировать файл
//            Path sourceArchiving = Paths.get(FolderName + "image.jpg");
//            Path destinationArchiving = Paths.get(FolderName + "image.zip");
//            FilesExamples.archivingFile(sourceArchiving, destinationArchiving);
////Архивировать несколько файлов
//            Path[] sourceArchivingAll = {Paths.get(FolderName + "image.jpg"),
//                    Paths.get(FolderName + "switches.log.txt"),
//                    Paths.get(FolderName + "testText.txt")};
//            Path destinationArchivingAll = Paths.get(FolderName + "archive.zip");
//            FilesExamples.archivingAllFiles(sourceArchivingAll, destinationArchivingAll);
////Архивировать дирректорию
//            Path sourceArchivingDir = Paths.get(FolderName + "folder");
//            Path destinationArchivingDir = Paths.get(FolderName + "archive1.zip");
//            FilesExamples.archivingDir(sourceArchivingDir, destinationArchivingDir);
////Разархивировать файл
//            String sourceExtractingDir = FolderName + "archive1.zip";
//            String destinationExtractingDir = FolderName + "result/";
//            FilesExamples.extractingDir(sourceExtractingDir, destinationExtractingDir);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}