
package opentsdb.api;

import java.util.HashMap;
import java.util.List;
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
    "id",
    "dps",
    "dpsMeta",
    "meta"
})
public class Output {

    @JsonProperty("id")
    private String id;
    @JsonProperty("dps")
    private List<List<Integer>> dps = null;
    @JsonProperty("dpsMeta")
    private DpsMeta dpsMeta;
    @JsonProperty("meta")
    private List<Metum> meta = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Output() {
    }

    /**
     * 
     * @param id
     * @param dps
     * @param dpsMeta
     * @param meta
     */
    public Output(String id, List<List<Integer>> dps, DpsMeta dpsMeta, List<Metum> meta) {
        super();
        this.id = id;
        this.dps = dps;
        this.dpsMeta = dpsMeta;
        this.meta = meta;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Output withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("dps")
    public List<List<Integer>> getDps() {
        return dps;
    }

    @JsonProperty("dps")
    public void setDps(List<List<Integer>> dps) {
        this.dps = dps;
    }

    public Output withDps(List<List<Integer>> dps) {
        this.dps = dps;
        return this;
    }

    @JsonProperty("dpsMeta")
    public DpsMeta getDpsMeta() {
        return dpsMeta;
    }

    @JsonProperty("dpsMeta")
    public void setDpsMeta(DpsMeta dpsMeta) {
        this.dpsMeta = dpsMeta;
    }

    public Output withDpsMeta(DpsMeta dpsMeta) {
        this.dpsMeta = dpsMeta;
        return this;
    }

    @JsonProperty("meta")
    public List<Metum> getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(List<Metum> meta) {
        this.meta = meta;
    }

    public Output withMeta(List<Metum> meta) {
        this.meta = meta;
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

    public Output withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(dps).append(dpsMeta).append(meta).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Output) == false) {
            return false;
        }
        Output rhs = ((Output) other);
        return new EqualsBuilder().append(id, rhs.id).append(dps, rhs.dps).append(dpsMeta, rhs.dpsMeta).append(meta, rhs.meta).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
