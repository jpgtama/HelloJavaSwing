/**
 * 
 */
package com.evan.hello.HelloJavaSwing;

import java.net.URL;

/**
 * @author hu xiao yi
 *
 */
public class ResourceUtil {

	public static URL getCutImage(){
		return ResourceUtil.class.getResource("/images/cut.gif");
	}
	
	public static URL getCopyImage(){
		return ResourceUtil.class.getResource("/images/copy.gif");
	}
	
	public static URL getPasteImage(){
		return ResourceUtil.class.getResource("/images/paste.gif");
	}
	
}
