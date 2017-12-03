import java.util.*;

public class KeyInitializer {

    private FileParser fileParser = new FileParser();

    protected String path;
    protected List<Integer> numKey;

    public Map<String, List<String>> pnrMapInit(final List<String> pnrLines) {
        final Map<String, List<String>> pnrMap = new HashMap<>();
        pnrLines.forEach(v->pnrMap.put(v, new ArrayList<>(Collections.singletonList(v))));
        return pnrMap;
    }

    public void init(final String pnr, final List<String> keys) {
        Optional<String> findLine = fileParser.parse(pnr, keys, path);

        if (findLine.isPresent()) {
            final String line = findLine.get();
            final List<String> linePart = Arrays.asList(line.split(","));
            numKey.forEach(i -> keys.add(linePart.get(i)));
        }
    }

}
