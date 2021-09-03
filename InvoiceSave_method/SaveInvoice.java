//package com.PageObject.CreatCustomer;
//
//import org.testng.Assert;
//
//public class SaveInvoice {
//
//    @Then("^save the invoice$")
//    public void save_the_invoice() throws Throwable {
//
//        billEntry.clickOn(billEntry.saveButton);
//
//        Thread.sleep(5000);
//
//        String finalInvoiceMessage = new String();
//        billEntry.checkElementVisibility(billEntry.invoicesuccessMessageElement, 30);
//        if (billEntry.invoicesuccessMessageElement.isDisplayed()) {
//            finalInvoiceMessage = finalInvoiceMessage.concat(billEntry.invoicesuccessMessageElement.getText());
//        }
//
//        String invoiceNumber = SalesBillEntry.findStringUsingRegex(finalInvoiceMessage, SalesBillEntry.invoicePattern);
//        String giNumber = SalesBillEntry.findStringUsingRegex(finalInvoiceMessage, SalesBillEntry.giPattern);
//
//        System.out.println("Invoice number generated : " + invoiceNumber);
//        System.out.println("GI number generated : " + giNumber);
//
//
//        String expectedFinalMessage = prop.getPropValues(ArteriaConstants.salesEntrySuccessMessage);
//        Assert.assertEquals(expectedFinalMessage
//                .replace("invoiceNumber", invoiceNumber)
//                .replace("giNumber", giNumber), finalInvoiceMessage);
//    }
//
//}
