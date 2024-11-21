package capstone.web.test;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

@Controller
public class MjpegStreamController {

    private  String MJPEG_STREAM_URL; // Flask MJPEG 스트리밍 URL

    // 환영 메시지와 비디오 스트리밍을 포함한 HTML 페이지 제공
    @GetMapping("/")
    public String welcomePage(@RequestParam("jetsonIp") String jetsonIp) {
        MJPEG_STREAM_URL = "http://" + jetsonIp + ":5000/video_feed";;
        return "index";  // templates/index.html 페이지 반환
    }

    // MJPEG 스트리밍을 제공하는 경로
    @GetMapping("/video-feed")
    @ResponseBody
    public void streamVideo(HttpServletResponse response) throws IOException {

        System.out.println("MjpegStreamController.streamVideo");
        URL url = new URL(MJPEG_STREAM_URL);
        System.out.println("URL: ",MJPEG_STREAM_URL);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();

        response.setContentType("multipart/x-mixed-replace; boundary=frame");
        response.setCharacterEncoding("UTF-8");

        OutputStream responseOutputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            responseOutputStream.write(buffer, 0, bytesRead);
            responseOutputStream.flush();
        }

        inputStream.close();
    }
}
