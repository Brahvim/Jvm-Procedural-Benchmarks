package com.brahvim.jvm_proc_bench.management;

public class ArrayManager {

	public float[] vectors;

	public ArrayManager(final int p_size) {
		this.vectors = new float[3 * p_size];
	}

	public int index(final int p_index) {
		return 3 * p_index;
	}

	public void setX(final int p_index, final float p_value) {
		this.vectors[0 + this.index(p_index)] = p_value;
	}

	public void setY(final int p_index, final float p_value) {
		this.vectors[1 + this.index(p_index)] = p_value;
	}

	public void setZ(final int p_index, final float p_value) {
		this.vectors[2 + this.index(p_index)] = p_value;
	}

	public static void main(final String[] p_args) {
		final long start = System.currentTimeMillis();
		final var man = new ArrayManager(Config.ITER);
		float sink = 0;

		for (int i = 0; i < Config.ITER; i++) {

			man.setX(i, sink += (i | 1234) * 0.1f);
			man.setY(i, sink += (i | 1234) * 0.5f);
			man.setZ(i, sink += (i | 1234) * 0.75f);

		}
		final long end = System.currentTimeMillis();

		System.out.printf("Sink: `%f`.\n", sink);
		System.out.printf("Time: %dms.\n", end - start);
	}

}
