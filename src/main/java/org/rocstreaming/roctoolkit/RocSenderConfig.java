// Code generated by bindgen.py from roc-streaming/bindgen
// roc-toolkit git tag: v0.4.0, commit: 62401be9

package org.rocstreaming.roctoolkit;

import java.time.Duration;
import lombok.*;

/**
 * Sender configuration.
 * <p>
 * RocSenderConfig object can be instantiated with {@link RocSenderConfig#builder()}.
 *
 * @see RocSender
 */
@Getter
@Builder(builderClassName = "Builder", toBuilder = true)
@ToString
@EqualsAndHashCode
public class RocSenderConfig {

    /**
     * The encoding used in frames passed to sender.
     * <p>
     * Frame encoding defines sample format, channel layout, and sample rate in
     * local frames created by user and passed to sender.
     * <p>
     * Should be set explicitly (zero value is invalid).
     */
    private MediaEncoding frameEncoding;

    /**
     * The encoding used for packets produced by sender.
     * <p>
     * Packet encoding defines sample format, channel layout, and sample rate in
     * network packets. If packet encoding differs from frame encoding,
     * conversion is performed automatically.
     * <p>
     * If zero, sender selects packet encoding automatically based on
     * {@code frameEncoding}. This automatic selection matches only encodings
     * that have exact same sample rate and channel layout, and hence don't
     * require conversions. If you need conversions, you should set packet
     * encoding explicitly.
     * <p>
     * If you want to force specific packet encoding, and built-in set of
     * encodings is not enough, you can use
     * {@link RocContext#registerEncoding()} to register custom encoding, and
     * set {@code packetEncoding} to registered identifier. If you use signaling
     * protocol like RTSP, it's enough to register in just on sender; otherwise,
     * you need to do the same on receiver as well.
     */
    private PacketEncoding packetEncoding;

    /**
     * The length of the packets produced by sender, in nanoseconds.
     * <p>
     * Number of nanoseconds encoded per packet. The samples written to the
     * sender are buffered until the full packet is accumulated or the sender is
     * flushed or closed. Larger number reduces packet overhead but also does
     * not allow smaller latency.
     * <p>
     * If zero, default value is used.
     */
    private Duration packetLength;

    /**
     * Enable packet interleaving.
     * <p>
     * If non-zero, the sender shuffles packets before sending them. This may
     * increase robustness but also increases latency.
     */
    private int packetInterleaving;

    /**
     * FEC encoding to use.
     * <p>
     * If FEC is enabled, the sender employs a FEC encoding to generate
     * redundant packet which may be used on receiver to restore lost packets.
     * This requires both sender and receiver to use two separate source and
     * repair endpoints.
     * <p>
     * If zero, default encoding is used ( {@link FecEncoding#DEFAULT} ).
     */
    private FecEncoding fecEncoding;

    /**
     * Number of source packets per FEC block.
     * <p>
     * Used if some FEC encoding is selected.
     * <p>
     * Sender divides stream into blocks of N source (media) packets, and adds M
     * repair (redundancy) packets to each block, where N is
     * {@code fecBlockSourcePackets} and M is {@code fecBlockRepairPackets}.
     * <p>
     * Larger number of source packets in block increases robustness (repair
     * ratio), but also increases latency.
     * <p>
     * If zero, default value is used.
     */
    private int fecBlockSourcePackets;

    /**
     * Number of repair packets per FEC block.
     * <p>
     * Used if some FEC encoding is selected.
     * <p>
     * Sender divides stream into blocks of N source (media) packets, and adds M
     * repair (redundancy) packets to each block, where N is
     * {@code fecBlockSourcePackets} and M is {@code fecBlockRepairPackets}.
     * <p>
     * Larger number of repair packets in block increases robustness (repair
     * ratio), but also increases traffic. Number of repair packets usually
     * should be 1/2 or 2/3 of the number of source packets.
     * <p>
     * If zero, default value is used.
     */
    private int fecBlockRepairPackets;

    /**
     * Clock source to use.
     * <p>
     * Defines whether write operation is blocking or non-blocking.
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
     * By default, latency tuning is <b>disabled</b> on sender. If you enable it
     * on sender, you need to disable it on receiver. You also need to set
     * {@code targetLatency} to the exact same value on both sides.
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
     * If latency tuning is enabled on sender (if {@code latencyTunerProfile} is
     * not {@link LatencyTunerProfile#INTACT} ), sender adjusts its clock to
     * keep actual latency as close as possible to the target.
     * <p>
     * By default, latency tuning is <b>disabled</b> on sender. If you enable it
     * on sender, you need to disable it on receiver. You also need to set
     * {@code targetLatency} to the exact same value on both sides.
     * <p>
     * If latency tuning is enabled, {@code targetLatency} should be non-zero.
     */
    private Duration targetLatency;

    /**
     * Maximum allowed delta between current and target latency, in nanoseconds.
     * <p>
     * How latency is calculated depends on {@code latencyTunerBackend} field.
     * <p>
     * If latency tuning is enabled on sender (if {@code latencyTunerProfile} is
     * not {@link LatencyTunerProfile#INTACT} ), sender monitors current
     * latency, and if it differs from {@code targetLatency} more than by
     * {@code latencyTolerance}, sender restarts connection to receiver.
     * <p>
     * By default, latency bounding is <b>disabled</b> on sender. If you enable
     * it on sender, you likely want to disable it on receiver.
     * <p>
     * If zero, default value is used (if latency tuning is enabled on sender).
     */
    private Duration latencyTolerance;

    public static RocSenderConfig.Builder builder() {
        return new RocSenderConfigValidator();
    }
}
