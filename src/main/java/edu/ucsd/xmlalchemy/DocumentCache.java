package edu.ucsd.xmlalchemy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DocumentCache {

    private static final Map<Path, Document> cache = new ConcurrentHashMap<>();

    private DocumentCache() {}

    public static Document read(String filename)
            throws IOException, ParserConfigurationException, SAXException {
        var path = Paths.get(filename);
        var data = cache.get(path);
        if (data == null) {
            var file = new File(filename);
            var dbf = DocumentBuilderFactory.newDefaultInstance();
            var db = dbf.newDocumentBuilder();
            var document = db.parse(file);
            document.normalize();
            Utils.trimTextNodes(document.getDocumentElement());
            cache.put(path, document);
        }
        return cache.get(path);
    }
}
