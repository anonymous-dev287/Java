package DesignPattern.StructuralDP;

//Target Interface
interface LanguageTranslation {
 String translateTo(String language, String text);
}

//Adaptee (Existing system working with English text)
class EnglishTextSystem {
 String processEnglishText(String text) {
     System.out.println("Processing English text: " + text);
     // Actual processing logic...
     return "Processed English Text";
 }
}

//Adapter class that adapts Adaptee to Target
class TranslationAdapter implements LanguageTranslation {
 private EnglishTextSystem englishTextSystem;

 TranslationAdapter(EnglishTextSystem englishTextSystem) {
     this.englishTextSystem = englishTextSystem;
 }

 @Override
 public String translateTo(String language, String text) {
     System.out.println("Translating to " + language + ": " + text);
     // Translation logic based on the target language
     String translatedText;
     switch (language.toLowerCase()) {
         case "hindi":
             translatedText = performHindiTranslation(text);
             break;
         case "marathi":
             translatedText = performMarathiTranslation(text);
             break;
         default:
             translatedText = text; // Default to original text for unsupported languages
             break;
     }
     return englishTextSystem.processEnglishText(translatedText);
 }

 private String performHindiTranslation(String text) {
     // Actual translation logic to Hindi...
     return "Hindi Translation: " + text;
 }

 private String performMarathiTranslation(String text) {
     // Actual translation logic to Marathi...
     return "Marathi Translation: " + text;
 }
}

//Client code using Target interface
public class Adapter {
 public static void main(String[] args) {
     EnglishTextSystem englishTextSystem = new EnglishTextSystem();
     LanguageTranslation translationAdapter = new TranslationAdapter(englishTextSystem);

     // Translating and processing text in Hindi
     String translatedResultHindi = translationAdapter.translateTo("Hindi", "Buldozer");
     System.out.println("Translated Result (Hindi): " + translatedResultHindi);

     // Translating and processing text in Marathi
     String translatedResultMarathi = translationAdapter.translateTo("Marathi", "Auto");
     System.out.println("Translated Result (Marathi): " + translatedResultMarathi);

     // Translating and processing text in an unsupported language (e.g., Spanish)
     String translatedResultUnsupported = translationAdapter.translateTo("Spanish", "Hello");
     System.out.println("Translated Result (Unsupported Language): " + translatedResultUnsupported);
 }
}



/*
    LanguageTranslation is the target interface.
    EnglishTextSystem is the Adaptee.
    TranslationAdapter is the Adapter class that implements the LanguageTranslation interface and adapts the EnglishTextSystem to it.
    The client code (Adapter) uses the TranslationAdapter to translate and process text in Hindi, Marathi, and an unsupported language.
    */
