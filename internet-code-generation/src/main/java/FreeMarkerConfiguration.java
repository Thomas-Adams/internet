import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
@Data
public class FreeMarkerConfiguration {

    Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);

    public FreeMarkerConfiguration() {
        try {
            initialize();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }


    public void initialize() throws IOException {
        cfg.setDirectoryForTemplateLoading(new File(getClass().getResource("/templates/").getFile()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
    }

}
