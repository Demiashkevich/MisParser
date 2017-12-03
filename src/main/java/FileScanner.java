import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class FileScanner {

    private FileScanner() {

    }

    public static Set<String> scan(final String directory) {
        File[] files = new File(directory).listFiles();

        if (files != null) {
            return Arrays.stream(files).map(File::getAbsolutePath).collect(Collectors.toSet());
        }

        return null;
    }

}
