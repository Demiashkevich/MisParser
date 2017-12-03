import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class MisFile {

    public void parse(final List<String> keys) {
        return lines.stream().map(line -> {
            String[] misValues = line.split(",");
            Optional<String> findValue = Arrays.stream(misValues).filter(v -> keys.stream().anyMatch(v::equals)).findFirst();
            if (findValue.isPresent()) {
                return findValue.get();
            }
            return null;
        }).findFirst();
    }

}
