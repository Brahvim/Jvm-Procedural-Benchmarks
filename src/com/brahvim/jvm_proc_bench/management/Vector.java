package com.brahvim.jvm_proc_bench.management;

public class Vector {

	public float x, y, z;

	public void add(final Vector p_other) {
		this.x += p_other.x;
		this.y += p_other.y;
		this.z += p_other.z;
	}

}
