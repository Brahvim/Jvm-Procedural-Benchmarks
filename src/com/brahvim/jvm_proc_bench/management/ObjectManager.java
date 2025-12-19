package com.brahvim.jvm_proc_bench.management;

public class ObjectManager {

	public Vector[] vectors;

	public ObjectManager(final int p_size) {
		this.vectors = new Vector[p_size];
		for (int i = 0; i < this.vectors.length; i++) {

			this.vectors[i] = new Vector();

		}
	}

	public Vector get(final int p_index) {
		return this.vectors[p_index];
	}

	public void setX(final int p_index, final float p_value) {
		this.vectors[p_index].x = p_value;
	}

	public void setY(final int p_index, final float p_value) {
		this.vectors[p_index].y = p_value;
	}

	public void setZ(final int p_index, final float p_value) {
		this.vectors[p_index].z = p_value;
	}

	public static void main(final String[] p_args) {
		final long start = System.currentTimeMillis();
		final var man = new ObjectManager(Config.ITER);
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
