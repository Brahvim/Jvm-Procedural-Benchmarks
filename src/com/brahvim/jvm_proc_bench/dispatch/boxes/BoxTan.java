package com.brahvim.jvm_proc_bench.dispatch.boxes;

public class BoxTan extends Box {

    @Override
    public void compute() {

        super.value = Math.tan(super.value);

    }

}
