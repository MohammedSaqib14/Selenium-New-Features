package SeleniumNewFeatures;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PDFReaderTest {
	
	WebDriver driver;
	String url = "";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void pdfReaderTest() throws IOException {
		URL pdfUrl = new URL(url);
		InputStream ip = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(ip);
		PDDocument pdDocument = PDDocument.load(bf);
		
		int pageCount = pdDocument.getNumberOfPages();
		System.out.println(pageCount);
		
		PDFTextStripper pdfStipper = new PDFTextStripper();
		String pdfText = pdfStipper.getText(pdDocument);
		System.out.println(pdfText);
		
		
		pdfStipper.setStartPage(2);
		String pdfText1 = pdfStipper.getText(pdDocument);
		System.out.println(pdfText1);
		
		
		
	}

}
