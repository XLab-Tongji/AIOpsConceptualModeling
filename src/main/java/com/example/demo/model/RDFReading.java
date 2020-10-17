package com.example.demo.model;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.*;
import java.io.InputStream;

public class RDFReading {
    public static String inputFileName = "resources.rdf";

    public static void main(String[] args){
        Model model = ModelFactory.createDefaultModel();

        // 使用 FileManager 查找文件
        InputStream in = RDFDataMgr.open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }

        // 读取RDF/XML 文件
        model.read(in, null);

        model.write(System.out);
    }
}
