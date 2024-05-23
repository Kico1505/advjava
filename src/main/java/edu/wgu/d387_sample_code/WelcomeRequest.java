package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WelcomeRequest {

    public String getEnglishWelcome() throws IOException {
        Properties properties = new Properties();
            try {
            InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
            properties.load(stream);
            return properties.getProperty("welcome");
        }
            catch (
        IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFrenchWelcome() throws IOException {
        Properties properties = new Properties();
        try {
            InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
            properties.load(stream);
            return properties.getProperty("welcome");
        }
        catch (
                IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
