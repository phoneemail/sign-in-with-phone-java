import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class HTMLButtonGenerator {
    public static void main(String[] args) {
        String COUNTRY_CODE = "your_country_code";
        String PHONE_NO = "your_phone_number";
        String REDIRECT_URL = "your_redirect_url";

        // Generate the HTML code
        String html = generateHTML(COUNTRY_CODE, PHONE_NO, REDIRECT_URL);

        // Write the HTML code to a temporary HTML file
        try {
            Path tempFile = FileSystems.getDefault().getPath("temp.html");
            java.nio.file.Files.write(tempFile, html.getBytes());
            
            // Open the HTML file in the default web browser
            java.awt.Desktop.getDesktop().browse(tempFile.toUri());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateHTML(String country_code, String phone_no, String redirect_url) {
        return "<html>"
            + "<head></head>"
            + "<body>"
            + "<button style=\"display: flex; align-items: center; justify-content: space-between; padding: 10px 15px; background-color: #02BD7E; font-weight: bold; color: #ffffff; border: none; border-radius: 3px; font-size: inherit; cursor: pointer;\""
            + " id=\"btn_ph_login\" name=\"btn_ph_login\" type=\"button\""
            + " onclick=\"window.open('https://auth.phone.email/sign-in?countrycode=" + country_code + "&phone_no=" + phone_no + "&redirect_url=" + redirect_url + "', 'peLoginWindow', 'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0, width=500, height=500, top=' + (screen.height - 500) / 2 + ', left=' + (screen.width - 500) / 2);\">"
            + "<svg xmlns=\"http://www.w3.org/2000/svg\" style=\"margin-right: 5px; fill: #ffffff\" height=\"24\" viewBox=\"0 -960 960 960\" width=\"24\">"
            + "<path d=\"M798-120q-125 0-247-54.5T329-329Q229-429 174.5-551T120-798q0-18 12-30t30-12h162q14 0 25 9.5t13 22.5l26 140q2 16-1 27t-11 19l-97 98q20 37 47.5 71.5T387-386q31 31 65 57.5t72 48.5l94-94q9-9 23.5-13.5T670-390l138 28q14 4 23 14.5t9 23.5v162q0 18-12 30t-30 12Z\"/>"
            + "</svg>"
            + "Sign in with Phone Number"
            + "</button>"
            + "</body>"
            + "</html>";
    }
}
