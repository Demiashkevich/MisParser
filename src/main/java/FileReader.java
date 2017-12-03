import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public final class FileReader {

    private FileReader() {
    }

    public static Optional<List<String>> read(final String absolutePath) {
        try {
            final List<String> misLines = Files.readAllLines(Paths.get(absolutePath));
            return Optional.of(misLines);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
