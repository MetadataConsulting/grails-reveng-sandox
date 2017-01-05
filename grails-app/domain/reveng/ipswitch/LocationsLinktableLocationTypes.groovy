package reveng.ipswitch

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class LocationsLinktableLocationTypes implements Serializable {

	String locationId
	String type
	Date apiCallDate
	Date importDate
	Date createdDate

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append locationId
		builder.append type
		builder.append apiCallDate
		builder.append importDate
		builder.append createdDate
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append locationId, other.locationId
		builder.append type, other.type
		builder.append apiCallDate, other.apiCallDate
		builder.append importDate, other.importDate
		builder.append createdDate, other.createdDate
		builder.isEquals()
	}

	static mapping = {
		id composite: ["locationId", "type", "apiCallDate", "importDate", "createdDate"]
        locationId column: 'locationId'
		version false
	}

	static constraints = {
		locationId maxSize: 15
		type maxSize: 50
		// createdDate unique: ["type", "locationID"]
	}
}
