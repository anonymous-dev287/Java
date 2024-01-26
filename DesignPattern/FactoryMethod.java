package DesignPattern;

//Product interface
interface Document {
 void open();
 void save();
}

//Concrete Products
class PDFDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening PDF document");
 }

 @Override
 public void save() {
     System.out.println("Saving PDF document");
 }
}

class WordDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening Word document");
 }

 @Override
 public void save() {
     System.out.println("Saving Word document");
 }
}

//Creator interface with Factory Method
interface DocumentCreator {
 Document createDocument();
}

//Concrete Creators implementing the Factory Method
class PDFDocumentCreator implements DocumentCreator {
 @Override
 public Document createDocument() {
     return new PDFDocument();
 }
}

class WordDocumentCreator implements DocumentCreator {
 @Override
 public Document createDocument() {
     return new WordDocument();
 }
}

public class FactoryMethod {
 public static void main(String[] args) {
     // Create a PDF document using PDFDocumentCreator
/*The variable pdfCreator is declared with the type DocumentCreator, which is an interface. 
 * However, it is assigned an instance of the concrete class PDFDocumentCreator. 
 * This is possible due to polymorphism in Java.*/
     DocumentCreator pdfCreator = new PDFDocumentCreator();
     /*By declaring the variable as the interface type (DocumentCreator), you abstract away the specific implementation details. 
      * The code that uses pdfCreator does not need to know the specific type of the object;
      *  it only interacts with it through the methods declared in the DocumentCreator interface.*/
     Document pdfDocument = pdfCreator.createDocument();
     pdfDocument.open();
     pdfDocument.save();

     // Create a Word document using WordDocumentCreator
     DocumentCreator wordCreator = new WordDocumentCreator();
     Document wordDocument = wordCreator.createDocument();
     wordDocument.open();
     wordDocument.save();
 }
}

