package cn.lee.jason.io.dicom;

import java.io.IOException;

import org.dcm4che3.tool.dcm2jpg.Dcm2Jpg;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by jason on 17/3/10.
 */
public class TestDcm4chImage {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testImage() {
        Resource resource = new ClassPathResource("/dicom/rightDicom");
        doConvert(resource);
    }

    @Test
    public void testWrong() {
        Resource resource = new ClassPathResource("/dicom/wrongDicom");
        doConvert(resource);
    }

    private void doConvert(Resource resource) {
        try {
            String path = resource.getFile().getPath() + ".jpg";
            logger.info(path);
            Dcm2Jpg dcm2Jpg = new Dcm2Jpg();
            dcm2Jpg.initImageWriter("jpeg", null, null, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
