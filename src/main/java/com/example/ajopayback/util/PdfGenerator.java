package com.example.ajopayback.util;

import com.example.ajopayback.model.Transaction;
import com.example.ajopayback.model.User;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;


public class PdfGenerator {
    private static final String DOWNLOAD_PATH = "\\C:\\Users\\raqib\\Downloads\\";

    public static String generateTransferReceipt(Transaction transfer, User sender, User receiver){
        try{
            String fileName = "transfer-receipt" + transfer.getId() +".pdf";
            String filePath = DOWNLOAD_PATH + fileName;

            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font headerFont = new Font(Font.FontFamily.HELVETICA, 18,Font.BOLD);
            Font bodyFont = new Font(Font.FontFamily.HELVETICA, 12);

            //Header
            document.add(new Paragraph("TRANSFER RECEIPT",headerFont));
            document.add(new Paragraph("--------------------------------------------"));

            document.add(new Paragraph("Transfer id"+ transfer.getId(),bodyFont));
            document.add(new Paragraph("Sender Account"+ sender.getAccountNumber(),bodyFont));
            document.add(new Paragraph("Sender Name"+ sender.getFirstName() +" " + sender.getSurName(),bodyFont));
            document.add(new Paragraph("Receiver Account"+ receiver.getAccountNumber(),bodyFont));
            document.add(new Paragraph("Receiver Name "+ receiver.getFirstName() + " " + receiver.getSurName(),bodyFont));
            document.add(new Paragraph("Amount N"+ transfer.getAmount(),bodyFont));
            document.add(new Paragraph("Status "+ transfer.getStatus(),bodyFont));
            document.add(new Paragraph("Date "+ transfer.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),bodyFont));

            document.add(new Paragraph("---------------------------------------------"));
            document.add(new Paragraph("Thank you for banking with us!",bodyFont));

            document.close();

            return filePath;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
