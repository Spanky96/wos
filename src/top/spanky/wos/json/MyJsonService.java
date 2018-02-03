package top.spanky.wos.json;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

public class MyJsonService {

    private final Logger logger = Logger.getLogger(MyJsonService.class);
    private static final String FILE_NAME = "shop.json";

    public JSONObject getShopBasicInfo() {
        BufferedReader reader = null;
        StringBuffer buffer = new StringBuffer();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(MyJsonService.class.getClassLoader().getResourceAsStream(FILE_NAME)));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            logger.error(FILE_NAME + " 未找到，文件读取失败");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error(FILE_NAME + " 未能正常关闭");
                }
            }
        }

        return JSONObject.fromObject(buffer.toString());
    }

    public boolean setBasicInfoJsonFile(JSONObject jsonObject) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(MyJsonService.class.getClassLoader().getResource(FILE_NAME).getPath());
            fileWriter.write(jsonObject.toString());
            return true;
        } catch (IOException e) {
            logger.error(FILE_NAME + " 写文件异常");
            return false;
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    logger.error(FILE_NAME + " 未能正常关闭");
                }
            }
        }


    }

}
