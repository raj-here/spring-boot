package com.biz.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.biz.bean.Address;
import com.biz.bean.Student;
import com.biz.service.AddressService;
import com.biz.service.StudentService;

import test.Link;
import test.RTFMetaData;
import test.RTFParsedData;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private AddressService addressService;

	@RequestMapping(path = "/getStudents", method = RequestMethod.GET)
	public List<Student> getStudents() {
		return studentService.getAll();
	}

	@RequestMapping(path = "/getAddresses", method = RequestMethod.GET)
	public List<Address> getAddresses() {
		return addressService.getAll();
	}

	@RequestMapping(path = "/getStudent/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable long id) {
		return studentService.findById(id);
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public void saveStudent() {
		Address address = new Address();
		address.setCityName("Chandigarh");

		Address address2 = new Address();
		address2.setCityName("Delhi");

		Address address3 = new Address();
		address3.setCityName("Lucknow");

		List<Address> set = new ArrayList<Address>();

		set.add(address);
		set.add(address2);
		set.add(address3);

		Student student = new Student();
		student.setName("Raj");
		student.setAddress(set);

		studentService.save(student);
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public void updateStudent() {
		Address address = new Address();
		address.setCityName("Faridabad");

		List<Address> set = new ArrayList<Address>();
		set.add(address);
		Student student = studentService.findById(1);
		set.addAll(student.getAddress());
		student.setAddress(set);
		studentService.save(student);
	}

	@RequestMapping(path = "/rtf-test", method = RequestMethod.GET)
	public List<RTFParsedData> parsedRTFMethod()
			throws IOException, SAXException, TikaException, TransformerConfigurationException {
		String path = "D:/2.rtf";
		Metadata metadata = new Metadata();
		Tika tika = new Tika();
		InputStream input = new FileInputStream(path);
		StringWriter sw = new StringWriter();
		SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		TransformerHandler handler = factory.newTransformerHandler();
		handler.getTransformer().setOutputProperty(OutputKeys.METHOD, "xml");
		handler.getTransformer().setOutputProperty(OutputKeys.INDENT, "no");
		handler.setResult(new StreamResult(sw));

		tika.getParser().parse(input, handler, metadata, new ParseContext());
		String htmlText = sw.toString();
		Document doc = Jsoup.parse(htmlText);
		Elements links = doc.select("p a");

		System.err.println(links.after("p"));
		List<RTFParsedData> rtfList = null;

		try {
			rtfList = links.stream().map(link -> {

					// String tempData = link.parent().child(1);
					//
					// String tempData2[] = tempData.split(",");

					RTFMetaData metaData = new RTFMetaData(2, "Author");
					Link linkData = new Link(link.attr("href"), link.text());

					return new RTFParsedData(linkData, "", new Date(), "", "", metaData);
				}).collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println(e);
		}
		return rtfList;

	}
}
