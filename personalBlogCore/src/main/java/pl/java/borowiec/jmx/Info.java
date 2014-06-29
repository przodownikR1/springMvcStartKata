package pl.java.borowiec.jmx;

import java.io.Serializable;

public class Info implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int requestCount;
	private double averageRespTime;
	private long sumRespTime;

	public void increase(long responseTime) {
		this.requestCount++;
		this.sumRespTime += responseTime;
		this.averageRespTime = (double) sumRespTime / (double) requestCount;
	}

	public int getRequestCount() {
		return requestCount;
	}

	public double getAverageRespTime() {
		return averageRespTime;
	}

	public long getSumRespTime() {
		return sumRespTime;
	}

}