package com.brahvim.jvm_proc_bench.dispatch.box;

public class BoxSin extends Box {

    @Override
    public void compute() {

        super.value = Math.sin(super.value);

    }

}
