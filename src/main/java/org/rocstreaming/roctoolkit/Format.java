// Code generated by bindgen.py from roc-streaming/bindgen
// roc-toolkit git tag: v0.3.0, commit: 57b932b8

package org.rocstreaming.roctoolkit;

/**
 * Sample format.
 * <p>
 * Defines how each sample is represented. Does not define channels layout and
 * sample rate.
 */
public enum Format {

    /**
     * PCM floats.
     * <p>
     * Uncompressed samples coded as 32-bit native-endian floats in range [-1;
     * 1]. Channels are interleaved, e.g. two channels are encoded as "L R L
     * R...".
     */
    PCM_FLOAT32(1),
    ;

    final int value;

    Format(int value) {
        this.value = value;
    }
}
