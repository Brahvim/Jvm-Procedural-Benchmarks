package com.brahvim.jvm_proc_bench.dispatch.boxes;

public class BoxSin extends Box {

    @Override
    public void compute() {

        super.value = Math.sin(super.value);

    }

}
