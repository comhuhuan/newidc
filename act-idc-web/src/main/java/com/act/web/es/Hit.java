package com.act.web.es;

public class Hit<T> {
	private long total;
	private double max_score;
	private T hits;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public double getMax_score() {
		return max_score;
	}
	public void setMax_score(double max_score) {
		this.max_score = max_score;
	}
	public T getHits() {
		return hits;
	}
	public void setHits(T hits) {
		this.hits = hits;
	}

}
