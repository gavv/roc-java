// Code generated by bindgen.py from roc-streaming/bindgen
// roc-toolkit git tag: v0.4.0, commit: 62401be9

package org.rocstreaming.roctoolkit;

/**
 * Packet encoding.
 * <p>
 * Each packet encoding defines sample format, channel layout, and rate. Each
 * packet encoding is compatible with specific protocols.
 */
public enum PacketEncoding {

    /**
     * PCM signed 16-bit, 1 channel, 44100 rate.
     * <p>
     * Represents 1-channel L16 stereo encoding from RTP A/V Profile (RFC 3551).
     * Uses uncompressed samples coded as interleaved 16-bit signed big-endian
     * integers in two's complement notation.
     * <p>
     * Supported by protocols: <ul>
     * <li>{@link Protocol#RTP}</li>
     * <li>{@link Protocol#RTP_RS8M_SOURCE}</li>
     * <li>{@link Protocol#RTP_LDPC_SOURCE}</li>
     * </ul>
     */
    AVP_L16_MONO(11),

    /**
     * PCM signed 16-bit, 2 channels, 44100 rate.
     * <p>
     * Represents 2-channel L16 stereo encoding from RTP A/V Profile (RFC 3551).
     * Uses uncompressed samples coded as interleaved 16-bit signed big-endian
     * integers in two's complement notation.
     * <p>
     * Supported by protocols: <ul>
     * <li>{@link Protocol#RTP}</li>
     * <li>{@link Protocol#RTP_RS8M_SOURCE}</li>
     * <li>{@link Protocol#RTP_LDPC_SOURCE}</li>
     * </ul>
     */
    AVP_L16_STEREO(10),
    ;

    final int value;

    PacketEncoding(int value) {
        this.value = value;
    }
}
