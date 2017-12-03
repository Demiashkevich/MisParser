import java.util.*;

public class FileFacade {

    private String PNR_PATH = "";
    private String MIS_DIRECTORY = "";

    public void execute() {

        final Optional<List<String>> pnrLinesOpt = FileReader.read(PNR_PATH);

        if (pnrLinesOpt.isPresent()) {
            final List<String> pnrLines = pnrLinesOpt.get();
            final KeyInitializer keyInitializer = new KeyInitializer();
            final Map<String, List<String>> pnrKeysMap = keyInitializer.pnrMapInit(pnrLines);
        }

    }

}
