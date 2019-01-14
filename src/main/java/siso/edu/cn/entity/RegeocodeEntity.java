package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegeocodeEntity {
    @JsonProperty("addressComponent")
    private AddressComponentEntity addressComponent;
    @JsonProperty("formatted_address")
    private String formattedAddress;

    public AddressComponentEntity getAddressComponent() {
        return addressComponent;
    }

    public void setAddressComponent(AddressComponentEntity addressComponent) {
        this.addressComponent = addressComponent;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}
