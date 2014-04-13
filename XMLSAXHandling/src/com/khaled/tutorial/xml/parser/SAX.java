package com.khaled.tutorial.xml.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAX {
	public static void main(String[] args) {
		try {
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();

			FileReader reader = new FileReader("./src/test.xml");
			InputSource inputSource = new InputSource(reader);

			xmlReader.setContentHandler(new LetterHandler());
			xmlReader.parse(inputSource);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
