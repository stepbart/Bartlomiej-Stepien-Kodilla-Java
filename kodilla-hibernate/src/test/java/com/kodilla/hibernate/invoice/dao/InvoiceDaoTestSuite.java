package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Product product = new Product("BIKE");
        Invoice invoice = new Invoice("1/10/2021");
        Item item1 = new Item(product,new BigDecimal(2000),5,new BigDecimal(1200));
        Item item2 = new Item(product,new BigDecimal(14999),1,new BigDecimal(8500));
        Item item3 = new Item(product,new BigDecimal(19000),1,new BigDecimal(12000));
        Item item4 = new Item(product,new BigDecimal(1800),1,new BigDecimal(1200));

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        //When
        productDao.save(product);
        int productID = product.getId();
        invoiceDao.save(invoice);
        int invoiceID = invoice.getId();
        //

        //Then
        Assertions.assertNotEquals(0,invoiceID);
        Assertions.assertNotEquals(0,productID);
        Assertions.assertNotEquals(0,item1.getId());
        Assertions.assertNotEquals(0,item2.getId());
        Assertions.assertNotEquals(0,item3.getId());
        Assertions.assertNotEquals(0,item4.getId());

        //CleanUp
        itemDao.deleteAll();
        productDao.deleteById(productID);
        invoiceDao.deleteById(invoiceID);
    }
}
