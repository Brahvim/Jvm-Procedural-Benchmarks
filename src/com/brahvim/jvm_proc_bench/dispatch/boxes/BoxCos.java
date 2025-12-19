package com.brahvim.jvm_proc_bench.dispatch.boxes;

public class BoxCos extends Box {

    @Override
    public void compute() {

        super.value = Math.cos(super.value);

    }

}
