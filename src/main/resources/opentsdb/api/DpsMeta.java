
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
    "firstTimestamp",
    "lastTimestamp",
    "setCount",
    "series"
})
public class DpsMeta {

    @JsonProperty("firstTimestamp")
    private Integer firstTimestamp;
    @JsonProperty("lastTimestamp")
    private Integer lastTimestamp;
    @JsonProperty("setCount")
    private Integer setCount;
    @JsonProperty("series")
    private Integer series;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DpsMeta() {
    }

    /**
     * 
     * @param series
     * @param lastTimestamp
     * @param firstTimestamp
     * @param setCount
     */
    public DpsMeta(Integer firstTimestamp, Integer lastTimestamp, Integer setCount, Integer series) {
        super();
        this.firstTimestamp = firstTimestamp;
        this.lastTimestamp = lastTimestamp;
        this.setCount = setCount;
        this.series = series;
    }

    @JsonProperty("firstTimestamp")
    public Integer getFirstTimestamp() {
        return firstTimestamp;
    }

    @JsonProperty("firstTimestamp")
    public void setFirstTimestamp(Integer firstTimestamp) {
        this.firstTimestamp = firstTimestamp;
    }

    public DpsMeta withFirstTimestamp(Integer firstTimestamp) {
        this.firstTimestamp = firstTimestamp;
        return this;
    }

    @JsonProperty("lastTimestamp")
    public Integer getLastTimestamp() {
        return lastTimestamp;
    }

    @JsonProperty("lastTimestamp")
    public void setLastTimestamp(Integer lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    public DpsMeta withLastTimestamp(Integer lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
        return this;
    }

    @JsonProperty("setCount")
    public Integer getSetCount() {
        return setCount;
    }

    @JsonProperty("setCount")
    public void setSetCount(Integer setCount) {
        this.setCount = setCount;
    }

    public DpsMeta withSetCount(Integer setCount) {
        this.setCount = setCount;
        return this;
    }

    @JsonProperty("series")
    public Integer getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(Integer series) {
        this.series = series;
    }

    public DpsMeta withSeries(Integer series) {
        this.series = series;
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

    public DpsMeta withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstTimestamp).append(lastTimestamp).append(setCount).append(series).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DpsMeta) == false) {
            return false;
        }
        DpsMeta rhs = ((DpsMeta) other);
        return new EqualsBuilder().append(firstTimestamp, rhs.firstTimestamp).append(lastTimestamp, rhs.lastTimestamp).append(setCount, rhs.setCount).append(series, rhs.series).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
