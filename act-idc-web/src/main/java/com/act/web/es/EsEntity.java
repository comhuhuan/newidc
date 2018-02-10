package com.act.web.es;

public class EsEntity<T> {
	private int took;
	private Boolean timed_out;
	private Shards _shards;
	private T hits;
	public T getHits() {
		return hits;
	}
	public void setHits(T hits) {
		this.hits = hits;
	}
	public int getTook() {
		return took;
	}
	public void setTook(int took) {
		this.took = took;
	}
	public Boolean getTimed_out() {
		return timed_out;
	}
	public void setTimed_out(Boolean timed_out) {
		this.timed_out = timed_out;
	}
	public Shards get_shards() {
		return _shards;
	}
	public void set_shards(Shards _shards) {
		this._shards = _shards;
	}

}
