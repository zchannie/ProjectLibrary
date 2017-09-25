package cn.csbe.web.cms.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.sl.usermodel.PictureData.PictureType;
import org.apache.poi.ss.usermodel.Picture;

import com.sun.xml.internal.txw2.Document;

public class POIUtils {

//	public static String docToHtml(HWPFDocument document, String path) throws Exception {  
//        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());  
//        wordToHtmlConverter.setPicturesManager(new PicturesManager() {  
//            @Override  
//            public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches, float heightInches) {  
//                return suggestedName;  
//            }  
//        });  
//        wordToHtmlConverter.processDocument(document);  
//        List<Picture> pictures = document.getPicturesTable().getAllPictures();  
//        if (!CollectionUtils.isEmpty(pictures)) {  
//            for (Picture picture:pictures) {  
//                picture.writeImageContent(new FileOutputStream(path + picture.suggestFullFileName()));  
//            }  
//        }  
//        Document htmlDocument = wordToHtmlConverter.getDocument();  
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
//        DOMSource domSource = new DOMSource(htmlDocument);  
//        StreamResult streamResult = new StreamResult(outStream);  
//        TransformerFactory tf = TransformerFactory.newInstance();  
//        Transformer serializer = tf.newTransformer();  
//        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");  
//        serializer.setOutputProperty(OutputKeys.INDENT, "yes");  
//        serializer.setOutputProperty(OutputKeys.METHOD, "html");  
//        serializer.transform(domSource, streamResult);  
//        outStream.close();  
//        return new String(outStream.toByteArray(), "utf-8");  
//    }  
//  
//    /** 
//     * 处理表格会有点问题 
//     * @param document 
//     * @param path 
//     * @return 
//     * @throws IOException 
//     */  
//    public static String docXToHtml(XWPFDocument document, String path)throws IOException {  
//        XHTMLOptions options = XHTMLOptions.create();  
//        options.setIgnoreStylesIfUnused(false);  
//        options.setFragment(true);  
//        options.setExtractor(new FileImageExtractor(new File(path)));  
//        ByteArrayOutputStream out = new ByteArrayOutputStream();  
//        XHTMLConverter.getInstance().convert(document, out, options);  
//        String content = new String(out.toByteArray());  
//        org.jsoup.nodes.Document document1 = Jsoup.parse(content);  
//        return document1.html();  
//    }  
    
}
