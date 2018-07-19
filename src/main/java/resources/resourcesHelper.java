package resources;

public class resourcesHelper {
	
	public static String getResourcePath(String path)
	{
		String basePath = System.getProperty("user.dir");
		return basePath+path;
	}
}
