package pl.java.borowiec.jmx;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 14-04-2013 00:10:07
 */
@ManagedResource(objectName = "bean:name=PersonalBlogPerformanceMonitor", description = "personalBlog jmx monitor")
public class PerformanceMonitor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Info> map = new HashMap<String, Info>();

	@ManagedOperation
	public void setMethodResponseTime(String methodName, long responseTime) {
		if (map.get(methodName) == null) {
			map.put(methodName, new Info());
		} else {
			Info info = map.get(methodName);
			info.increase(responseTime);
			map.put(methodName, info);
		}
	}

	@ManagedOperation
	public String getReport(String str) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Info> entry : map.entrySet()) {
			sb.append(entry.getKey()).append(" averageResponseTime ").append(entry.getValue().getAverageRespTime()).append(" count: ")
					.append(entry.getValue().getRequestCount()).append("\n");
		}
		System.err.println(sb.toString());
		return sb.toString();
	}

	@ManagedOperation()
	public String getReport1() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Info> entry : map.entrySet()) {
			sb.append(entry.getKey()).append(" averageResponseTime ").append(entry.getValue().getAverageRespTime()).append(" count: ")
					.append(entry.getValue().getRequestCount()).append("\n");
		}
		System.err.println(sb.toString());
		return sb.toString();
	}

	@ManagedOperation
	public void reset() {
		map.clear();
	}

	public Map<String, Info> getMap() {
		return map;
	}

}
