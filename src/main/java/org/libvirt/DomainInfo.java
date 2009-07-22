package org.libvirt;

import org.libvirt.jna.virDomainInfo;

/**
 * This object is returned by Domain.getInfo()
 * 
 * @author stoty
 * 
 */
public class DomainInfo {
    /**
     * @author stoty
     * 
     */
    public static enum DomainState {
        /**
         * no state
         */
        VIR_DOMAIN_NOSTATE,
        /**
         * the domain is running
         */
        VIR_DOMAIN_RUNNING,
        /**
         * the domain is blocked on resource
         */
        VIR_DOMAIN_BLOCKED,
        /**
         * the domain is paused by user
         */
        VIR_DOMAIN_PAUSED,
        /**
         * the domain is being shut down
         */
        VIR_DOMAIN_SHUTDOWN,
        /**
         * the domain is shut off
         */
        VIR_DOMAIN_SHUTOFF,
        /**
         * the domain is crashed
         */
        VIR_DOMAIN_CRASHED
    }

    /**
     * the running state, one of virDomainFlag
     */
    public DomainState state;
    /**
     * the maximum memory in KBytes allowed
     */
    public long maxMem;
    /**
     * the memory in KBytes used by the domain
     */
    public long memory;
    /**
     * the number of virtual CPUs for the domain
     */
    public int nrVirtCpu;

    /**
     * the CPU time used in nanoseconds
     */
    public long cpuTime;

    public DomainInfo() {

    }

    public DomainInfo(virDomainInfo info) {
        this.cpuTime = info.cpuTime;
        this.maxMem = info.maxMem.longValue();
        this.memory = info.memory.longValue();
        this.nrVirtCpu = info.nrVirtCpu;
        this.state = DomainState.values()[info.state];
    }

    public String toString() {
        StringBuffer result = new StringBuffer("");
        result.append("state:" + state + "\n");
        result.append("maxMem:" + maxMem + "\n");
        result.append("memory:" + memory + "\n");
        result.append("nrVirtCpu:" + nrVirtCpu + "\n");
        result.append("cpuTime:" + cpuTime + "\n");
        return result.toString();
    }
}
