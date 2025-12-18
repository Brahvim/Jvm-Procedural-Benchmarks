package com.brahvim.jvm_proc_bench.dispatch;

public class SwitchDispatch {

	public static double sink;
	public static double[] array;

	public static void main(final String[] p_args) {

		SwitchDispatch.sink = 0;
		long arrayAllocNanos = 0;
		long arrayAllocMillis = 0;

		{
			final long startMillis = System.currentTimeMillis();
			final long startNanos = System.nanoTime();

			SwitchDispatch.array = new double[Config.ITER];

			final long endMillis = System.currentTimeMillis();
			final long endNanos = System.nanoTime();

			arrayAllocNanos = endNanos - startNanos;
			arrayAllocMillis = endMillis - startMillis;
		}

		for (int i = 0; i < Config.ITER; i++) {

			SwitchDispatch.array[i] = 31 * i * Math.random() + 7;

		}

		final long startMillis = System.currentTimeMillis();
		final long startNanos = System.nanoTime();

		for (int i = 0; i < Config.ITER; i++) {

			final var value = SwitchDispatch.dispatch(SwitchDispatch.array[i]);
			SwitchDispatch.sink += SwitchDispatch.array[i];
			SwitchDispatch.array[i] = value;

		}

		final long endMillis = System.currentTimeMillis();
		final long endNanos = System.nanoTime();

		System.out.printf("Sink: `%f`.\n", SwitchDispatch.sink);
		System.out.printf(

				"Time!: %dms, %dns.\n",
				endMillis - startMillis + arrayAllocMillis,
				endNanos - startNanos + arrayAllocNanos

		);
	}

	public static double dispatch(final double p_value) {
		return switch ((int) (p_value % 3)) {

			case 0 -> Math.sin(p_value);
			case 1 -> Math.cos(p_value);
			case 2 -> Math.tan(p_value);
			default -> p_value;

		};
	}

}
