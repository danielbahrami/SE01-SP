Before it is possible to run the application, these steps must be completed:

1. Download JDK 15, and apply it in the project structure on your IDE.

2. Download JavaFX 15 SDK, and add the "lib" folder as a library in your IDE.

3. Edit the run configurations in your IDE by adding VM options.

Add these VM options if you are using a Linux/Mac machine:
--module-path /path/to/javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml

Add these VM options if you are using a Windows machine:
--module-path "\path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml


To run the application, run "GameMenu.main()" through your IDE located here:
1T2-4 Javaprojekt > Pandemic-master > Pandemic-framework > Pandemic > GameMenu.java
