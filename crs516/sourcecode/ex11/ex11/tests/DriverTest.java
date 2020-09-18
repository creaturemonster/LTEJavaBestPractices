import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;

import javax.swing.JTabbedPane;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DriverTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		Driver.main(null);
		//Make sure there's a window on the screen.
        Frame[] allFrames = Frame.getFrames();
        for (int i = 0; i < allFrames.length; i++) {
        	
           Frame f = allFrames[i];
           if (f instanceof com.ltree.crs516.client.WOD) {
              assertTrue(f.getTitle().equals("World Ocean Database Browser "));
              Container contentPane =((com.ltree.crs516.client.WOD) f).getContentPane();
              Component[] components = contentPane.getComponents();
              JTabbedPane tabs = (JTabbedPane)components[0];
              assertTrue(tabs.getTabCount()==6);
            	  assertTrue(tabs.getTitleAt(0).equals("Primary Headers "));
            	  assertTrue(tabs.getTitleAt(1).equals("Character Data "));
            	  assertTrue(tabs.getTitleAt(2).equals("Secondary Headers "));
            	  assertTrue(tabs.getTitleAt(3).equals("Biology Headers "));
            	  assertTrue(tabs.getTitleAt(4).equals("Taxa Sets "));
            	  assertTrue(tabs.getTitleAt(5).equals("Profile Data"));
        	   return;
           }
           fail("Did not get a WOD frame");
        }

	}

}
