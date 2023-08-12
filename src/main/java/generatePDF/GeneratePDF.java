package generatePDF;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

import dao.CommandeDaoImpl;
import dao.ArticleDaoImpl;
import entities.CommandeArticle;
import dao.UserDaoImpl;
import entities.Commande;
import entities.Article;
import entities.User;
import metier.HibernateUtil;

public class GeneratePDF {

	private CommandeDaoImpl commandeDao;
	private ArticleDaoImpl articleDao;
	private UserDaoImpl userDao;
	Resource resource = new ClassPathResource("applicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(resource);

	public GeneratePDF() {
		commandeDao = (CommandeDaoImpl) factory.getBean("commandeDao");
		articleDao = (ArticleDaoImpl) factory.getBean("articleDao");
		userDao = (UserDaoImpl) factory.getBean("userDao");
	}

	public void generateInvoice(int commandeId) {

		CommandeDaoImpl commandeDao = (CommandeDaoImpl) factory.getBean("commandeDao");
		Commande commande = commandeDao.getById(commandeId);

		UserDaoImpl userDao = (UserDaoImpl) factory.getBean("userDao");
		User client = userDao.getById(commande.getUser().getId());

		System.out.println(commande);

		Set<CommandeArticle> cmdArticles = commande.getCommandeArticles();
		System.out.println(cmdArticles.size());

		String filePath = "C:\\Users\\pc\\eclipse-workspace\\Gestion-Vente02\\src\\main\\webapp\\assets\\invoices\\invoice"
				+ client.getId() + "" + commande.getCodeCommande() + ".pdf";
		Date invoiceDateCommande = commande.getDateCommande();
		String customerName = client.getFullName();
		String invoiceDate = commande.getDateLivraison();
		double totalAmount = commande.getPrixTotal();

		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
			Paragraph title = new Paragraph("Facture", titleFont);
			title.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(title);

			Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
			document.add(new Paragraph("Mr/Mm: " + customerName, contentFont));
			document.add(new Paragraph("Date de livraison: " + invoiceDate, contentFont));
			document.add(new Paragraph("Date de commande: " + invoiceDateCommande, contentFont));
			document.add(new Paragraph("Montant total : " + totalAmount, contentFont));

			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100);
			table.setSpacingBefore(20);
			table.setSpacingAfter(20);

			Font tableHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			PdfPCell cell1 = new PdfPCell(new Phrase("Nom Article", tableHeaderFont));
			PdfPCell cell2 = new PdfPCell(new Phrase("Prix Article", tableHeaderFont));
			PdfPCell cell3 = new PdfPCell(new Phrase("Quantite article", tableHeaderFont));
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			Font tableContentFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
			for (CommandeArticle cmdArticle : cmdArticles) {
				PdfPCell cell11 = new PdfPCell(new Phrase(cmdArticle.getArticle().getNomArticle(), tableContentFont));
				PdfPCell cell22 = new PdfPCell(
						new Phrase(cmdArticle.getArticle().getPrixArticle() + "", tableContentFont));
				PdfPCell cell33 = new PdfPCell(new Phrase("" + cmdArticle.getQuantity(), tableContentFont));
				table.addCell(cell11);
				table.addCell(cell22);
				table.addCell(cell33);
			}

			document.add(table);

			document.close();

			System.out.println("La facture PDF a été générée avec succès.");
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openPdf(int commandeId) throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		CommandeDaoImpl commandeDao = (CommandeDaoImpl) factory.getBean("commandeDao");
		Commande commande = commandeDao.getById(commandeId);

		UserDaoImpl userDao = (UserDaoImpl) factory.getBean("userDao");
		User client = userDao.getById(commande.getUser().getId());

		System.out.println(commande);

		Set<CommandeArticle> cmdArticles = commande.getCommandeArticles();
		System.out.println(cmdArticles.size());
		String filePath = "C:\\Users\\pc\\eclipse-workspace\\Gestion-Vente02\\src\\main\\webapp\\assets\\invoices\\invoice"
				+ client.getId() + "" + commande.getCodeCommande() + ".pdf";

		Path pdfPath = Paths.get(filePath);
		if (Files.exists(pdfPath)) {
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=invoice.pdf");

			try (InputStream inputStream = Files.newInputStream(pdfPath);
					OutputStream outputStream = response.getOutputStream()) {
				byte[] buffer = new byte[4096];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
			}
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
