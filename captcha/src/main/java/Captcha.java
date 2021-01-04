import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Captcha {
    private String str;

    public Captcha(String str){
        this.str = str;
    }

    void createCaptcha() {
        int num[] = new int[str.length()];
        BufferedImage im = new BufferedImage(100 * str.length(), 150, BufferedImage.TYPE_INT_RGB);
        for (int i = 0 , j = 0; i < num.length; i++ , j+=100) {
            num[i] = Integer.parseInt(str.substring(i, i + 1));
            im.getGraphics().drawImage(Reader.readImg(String.valueOf(num[i])), j, 0, null);
        }
        String path = null;
        try {
            File file = new File("src/main/resources/result.jpg");
            path = file.getAbsolutePath();
            ImageIO.write(im, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Runner.run(path);
    }
}
