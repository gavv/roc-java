// Code generated by bindgen.py from roc-streaming/bindgen
// roc-toolkit git tag: v0.4.0, commit: 62401be9

package org.rocstreaming.roctoolkit;

import java.time.Duration;
import lombok.*;

/**
 * Receiver configuration.
 * <p>
 * RocReceiverConfig object can be instantiated with {@link RocReceiverConfig#builder()}.
 *
 * @see RocReceiver
 */
@Getter
@Builder(builderClassName = "Builder", toBuilder = true)
@ToString
@EqualsAndHashCode
public class RocReceiverConfig {

    /**
     * The encoding used in frames returned by receiver.
     * <p>
     * Frame encoding defines sample format, channel layout, and sample rate in
     * local frames returned by receiver to user.
     * <p>
     * Should be set (zero value is invalid).
     */
    private MediaEncoding frameEncoding;

    /**
     * Clock source.
     * <p>
     * Defines whether read operation is blocking or non-blocking.
     * <p>
     * If zero, default value is used ( {@link ClockSource#DEFAULT} ).
     */
    private ClockSource clockSource;

    /**
     * Latency tuner backend.
     * <p>
     * Defines which latency is monitored and controlled by latency tuner.
     * Defines semantics of {@code targetLatency}, {@code min_latency}, and
     * {@code max_latency} fields.
     * <p>
     * If zero, default backend is used ( {@link LatencyTunerBackend#DEFAULT} ).
     */
    private LatencyTunerBackend latencyTunerBackend;

    /**
     * Latency tuner profile.
     * <p>
     * Defines whether latency tuning is enabled and which algorithm is used.
     * <p>
     * If zero, default profile is used ( {@link LatencyTunerProfile#DEFAULT} ).
     * <p>
     * By default, latency tuning is <b>enabled</b> on receiver. If you disable
     * it on receiver, you usually need to enable it on sender. In that case you
     * also need to set {@code targetLatency} to the same value on both sides.
     */
    private LatencyTunerProfile latencyTunerProfile;

    /**
     * Resampler backend.
     * <p>
     * Affects CPU usage, quality, and clock synchronization precision (if
     * latency tuning is enabled).
     * <p>
     * If zero, default backend is used ( {@link ResamplerBackend#DEFAULT} ).
     */
    private ResamplerBackend resamplerBackend;

    /**
     * Resampler profile.
     * <p>
     * Affects CPU usage and quality.
     * <p>
     * If zero, default profile is used ( {@link ResamplerProfile#DEFAULT} ).
     */
    private ResamplerProfile resamplerProfile;

    /**
     * Target latency, in nanoseconds.
     * <p>
     * How latency is calculated depends on {@code latencyTunerBackend} field.
     * <p>
     * If latency tuning is enabled on receiver (if {@code latencyTunerProfile}
     * is not {@link LatencyTunerProfile#INTACT} ), receiver adjusts its clock
     * to keep actual latency as close as possible to the target.
     * <p>
     * By default, latency tuning is <b>enabled</b> on receiver. If you disable
     * it on receiver, you likely want to enable it on sender. In this case you
     * also need to set {@code targetLatency} to the exact same value on both
     * sides.
     * <p>
     * If zero, default value is used.
     */
    private Duration targetLatency;

    /**
     * Maximum allowed delta between current and target latency, in nanoseconds.
     * <p>
     * How latency is calculated depends on {@code latencyTunerBackend} field.
     * <p>
     * If latency tuning is enabled on receiver (if {@code latencyTunerProfile}
     * is not {@link LatencyTunerProfile#INTACT} ), receiver monitors current
     * latency, and if it differs from {@code targetLatency} more than by
     * {@code latencyTolerance}, receiver terminates connection to sender (but
     * it then restarts if sender continues streaming).
     * <p>
     * By default, latency bounding is <b>enabled</b> on receiver. If you
     * disable it on receiver, you likely want to enable it on sender.
     * <p>
     * If zero, default value is used (if latency tuning is enabled on
     * receiver).
     */
    private Duration latencyTolerance;

    /**
     * Timeout for the lack of playback, in nanoseconds.
     * <p>
     * If there is no playback during this period, receiver terminates
     * connection to to sender (but it then restarts if sender continues
     * streaming).
     * <p>
     * This mechanism allows to detect dead, hanging, or incompatible clients
     * that generate unparseable packets.
     * <p>
     * If zero, default value is used. If negative, the check is disabled.
     */
    private Duration noPlaybackTimeout;

    /**
     * Timeout for choppy playback, in nanoseconds.
     * <p>
     * If there is constant stuttering during this period, receiver terminates
     * connection to sender (but it then restarts if sender continues
     * streaming).
     * <p>
     * This mechanism allows to detect situations when playback continues but
     * there are frequent glitches, for example because there is a high ratio of
     * late packets.
     * <p>
     * If zero, default value is used. If negative, the check is disabled.
     */
    private Duration choppyPlaybackTimeout;

    public static RocReceiverConfig.Builder builder() {
        return new RocReceiverConfigValidator();
    }
}
