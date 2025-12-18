package com.brahvim.jvm_proc_bench.dispatch.box;

public class BoxTan extends Box {

    @Override
    public void compute() {

        super.value = Math.tan(super.value);

    }

}
