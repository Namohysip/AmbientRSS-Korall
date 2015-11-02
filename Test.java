
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.awt.Font;
import java.io.InputStreamReader;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class Driver {

	public static void main(String[] args) {
		try {
			URL feedUrl = new URL("http://www.npr.org/rss/rss.php");

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedUrl));
			System.out.println(feed);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
		
		public static void openWebpage(URI uri) {
		    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
		        try {
		            desktop.browse(uri);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}

		public static void openWebpage(URL url) {
		    try {
		        openWebpage(url.toURI());
		    } catch (URISyntaxException e) {
		        e.printStackTrace();
		    }
		}

}
