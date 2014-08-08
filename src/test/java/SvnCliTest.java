import com.swforge.toolkit.config.ConfigUtils;
import org.junit.Test;
import org.tmatesoft.svn.cli.SVN;

/**
 * Created by sungwoo on 14. 8. 8.
 */
public class SvnCliTest {
    @Test
    public void testSvnCli() {
        String projectConfigurationUrl= ConfigUtils.getPropProjectConfigurationUrl();
        System.setProperty("svnkit.http.methods", "Basic");
        SVN.main(new String[] {
                "info",
                "--non-interactive",
                "--username", ConfigUtils.getFullUserId(),
                "--password", ConfigUtils.getUserPass(),
                projectConfigurationUrl
        });
    }
}
