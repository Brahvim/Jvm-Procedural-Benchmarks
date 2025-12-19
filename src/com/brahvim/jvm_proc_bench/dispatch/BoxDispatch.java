package com.brahvim.jvm_proc_bench.dispatch;

import com.brahvim.jvm_proc_bench.dispatch.boxes.Box;
import com.brahvim.jvm_proc_bench.dispatch.boxes.BoxCos;
import com.brahvim.jvm_proc_bench.dispatch.boxes.BoxNone;
import com.brahvim.jvm_proc_bench.dispatch.boxes.BoxSin;
import com.brahvim.jvm_proc_bench.dispatch.boxes.BoxTan;

public class BoxDispatch {

	public static double sink;
	public static Box[] boxes;
	public static double[] array;

	public static void main(final String[] p_args) {

		BoxDispatch.array = new double[Config.ITER];
		BoxDispatch.boxes = new Box[Config.ITER];

		for (int i = 0; i < Config.ITER; i++) {

			BoxDispatch.array[i] = 31 * i * Math.random() + 7;

		}

		final long startMillis = System.currentTimeMillis();
		final long startNanos = System.nanoTime();

		for (int i = 0; i < Config.ITER; i++) {

			final var value = BoxDispatch.array[i];
			final Box box = switch ((int) (value % 3)) {

				case 0 -> new BoxSin();
				case 1 -> new BoxCos();
				case 2 -> new BoxTan();
				default -> new BoxNone();

			};
			BoxDispatch.boxes[i] = box;
			box.value = value;

		}

		for (int i = 0; i < Config.ITER; i++) {

			final var b = BoxDispatch.boxes[i];
			b.compute();
			BoxDispatch.sink += b.value;

		}

		final long endMillis = System.currentTimeMillis();
		final long endNanos = System.nanoTime();

		System.out.printf("Sink: `%f`.\n", BoxDispatch.sink);
		System.out.printf("Time!: %dms, %dns.\n", endMillis - startMillis, endNanos - startNanos);

	}

}
