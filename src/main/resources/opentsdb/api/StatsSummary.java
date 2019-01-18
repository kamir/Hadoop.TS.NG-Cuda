
package opentsdb.api;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datapoints",
    "rawDatapoints",
    "aggregationTime",
    "serializationTime",
    "storageTime",
    "timeTotal"
})
public class StatsSummary {

    @JsonProperty("datapoints")
    private Integer datapoints;
    @JsonProperty("rawDatapoints")
    private Integer rawDatapoints;
    @JsonProperty("aggregationTime")
    private Integer aggregationTime;
    @JsonProperty("serializationTime")
    private Integer serializationTime;
    @JsonProperty("storageTime")
    private Integer storageTime;
    @JsonProperty("timeTotal")
    private Double timeTotal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StatsSummary() {
    }

    /**
     * 
     * @param datapoints
     * @param serializationTime
     * @param rawDatapoints
     * @param aggregationTime
     * @param storageTime
     * @param timeTotal
     */
    public StatsSummary(Integer datapoints, Integer rawDatapoints, Integer aggregationTime, Integer serializationTime, Integer storageTime, Double timeTotal) {
        super();
        this.datapoints = datapoints;
        this.rawDatapoints = rawDatapoints;
        this.aggregationTime = aggregationTime;
        this.serializationTime = serializationTime;
        this.storageTime = storageTime;
        this.timeTotal = timeTotal;
    }

    @JsonProperty("datapoints")
    public Integer getDatapoints() {
        return datapoints;
    }

    @JsonProperty("datapoints")
    public void setDatapoints(Integer datapoints) {
        this.datapoints = datapoints;
    }

    public StatsSummary withDatapoints(Integer datapoints) {
        this.datapoints = datapoints;
        return this;
    }

    @JsonProperty("rawDatapoints")
    public Integer getRawDatapoints() {
        return rawDatapoints;
    }

    @JsonProperty("rawDatapoints")
    public void setRawDatapoints(Integer rawDatapoints) {
        this.rawDatapoints = rawDatapoints;
    }

    public StatsSummary withRawDatapoints(Integer rawDatapoints) {
        this.rawDatapoints = rawDatapoints;
        return this;
    }

    @JsonProperty("aggregationTime")
    public Integer getAggregationTime() {
        return aggregationTime;
    }

    @JsonProperty("aggregationTime")
    public void setAggregationTime(Integer aggregationTime) {
        this.aggregationTime = aggregationTime;
    }

    public StatsSummary withAggregationTime(Integer aggregationTime) {
        this.aggregationTime = aggregationTime;
        return this;
    }

    @JsonProperty("serializationTime")
    public Integer getSerializationTime() {
        return serializationTime;
    }

    @JsonProperty("serializationTime")
    public void setSerializationTime(Integer serializationTime) {
        this.serializationTime = serializationTime;
    }

    public StatsSummary withSerializationTime(Integer serializationTime) {
        this.serializationTime = serializationTime;
        return this;
    }

    @JsonProperty("storageTime")
    public Integer getStorageTime() {
        return storageTime;
    }

    @JsonProperty("storageTime")
    public void setStorageTime(Integer storageTime) {
        this.storageTime = storageTime;
    }

    public StatsSummary withStorageTime(Integer storageTime) {
        this.storageTime = storageTime;
        return this;
    }

    @JsonProperty("timeTotal")
    public Double getTimeTotal() {
        return timeTotal;
    }

    @JsonProperty("timeTotal")
    public void setTimeTotal(Double timeTotal) {
        this.timeTotal = timeTotal;
    }

    public StatsSummary withTimeTotal(Double timeTotal) {
        this.timeTotal = timeTotal;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public StatsSummary withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(datapoints).append(rawDatapoints).append(aggregationTime).append(serializationTime).append(storageTime).append(timeTotal).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StatsSummary) == false) {
            return false;
        }
        StatsSummary rhs = ((StatsSummary) other);
        return new EqualsBuilder().append(datapoints, rhs.datapoints).append(rawDatapoints, rhs.rawDatapoints).append(aggregationTime, rhs.aggregationTime).append(serializationTime, rhs.serializationTime).append(storageTime, rhs.storageTime).append(timeTotal, rhs.timeTotal).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
