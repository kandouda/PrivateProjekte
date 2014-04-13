package com.khaled.tutorial.xml.parser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.khaled.tutorial.xml.dto.Letter;

public class LetterHandler implements ContentHandler {

	private String currentValue;
	private Letter letter;
	private List<Letter> alleLetter = new ArrayList<Letter>();

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		currentValue = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		// Name setzen
		if (localName.equals("name")) {
			letter.setName(currentValue);
		}

		// Street setzen
		if (localName.equals("street")) {
			letter.setStreet(currentValue);
		}

		if (localName.equals("letter")) {
			alleLetter.add(letter);
			System.out.println(letter);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (localName.equals("letter")) {
			letter = new Letter(null, null);
		}
	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void endPrefixMapping(String arg0) throws SAXException {

	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {

	}

	@Override
	public void processingInstruction(String arg0, String arg1)
			throws SAXException {

	}

	@Override
	public void setDocumentLocator(Locator arg0) {

	}

	@Override
	public void skippedEntity(String arg0) throws SAXException {

	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {

	}

}
