import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FileParser {

    private List<String> lines;

    public Optional<String> parse(final String pnr, final List<String> keys, final String absolutePath) {
        this.linesInit(keys, absolutePath);
        return lines.stream().map(line -> {
            String[] misValues = line.split(",");
            Optional<String> findPnr = Arrays.stream(misValues).filter(pnr::equals).findFirst();
            if (findPnr.isPresent()) {
                return line;
            }
            return null;
        }).findFirst();
    }

    private void linesInit(final List<String> keys, final String absolutePath) {
        Optional<List<String>> lines = FileReader.read(absolutePath);
        if (lines.isPresent()) {
            this.lines = lines.get();
        }
    }

}
