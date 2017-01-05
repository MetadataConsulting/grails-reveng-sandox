package reveng.ipswitch

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class LocationsLinktableSpecialisms implements Serializable {

	String locationId
	String name
	Date apiCallDate
	Date importDate
	Date createdDate

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append locationId
		builder.append name
		builder.append apiCallDate
		builder.append importDate
		builder.append createdDate
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append locationId, other.locationId
		builder.append name, other.name
		builder.append apiCallDate, other.apiCallDate
		builder.append importDate, other.importDate
		builder.append createdDate, other.createdDate
		builder.isEquals()
	}

	static mapping = {
		id composite: ["locationId", "name", "apiCallDate", "importDate", "createdDate"]
        locationId column: 'locationId'
		version false
	}

	static constraints = {
		locationId maxSize: 15
		// createdDate unique: ["name", "locationID"]
	}
}
